// @Service
// public class PasswordResetService {

//     private static final SecureRandom RANDOM = new SecureRandom();
//     private static final String INVALID = "Invalid or expired code.";

//     private final UserRepository userRepository;
//     private final PasswordResetCodeRepository codeRepository;
//     private final JavaMailSender mailSender;

//     public PasswordResetService(UserRepository userRepository,
//                                 PasswordResetCodeRepository codeRepository,
//                                 JavaMailSender mailSender) {
//         this.userRepository = userRepository;
//         this.codeRepository = codeRepository;
//         this.mailSender = mailSender;
//     }

//     private ResponseStatusException bad(String message) {
//         return new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
//     }

//     // Steps 3-4 of the flow: create and email the code
//     @Transactional
//     public void sendCode(String email) {
       
//         userRepository.findByEmail(email.trim()).ifPresent(user -> {
//             codeRepository.deleteByUser(user);                    // only one active code per user

//             String code = String.format("%06d", RANDOM.nextInt(1_000_000));

//             PasswordResetCode entry = new PasswordResetCode();
//             entry.setUser(user);
//             entry.setCode(code);
//             entry.setExpiryDate(LocalDateTime.now().plusMinutes(10));
//             codeRepository.save(entry);

//             // remove once mail works
//             System.out.println("RESET CODE for " + user.getEmail() + " = " + code);

//             SimpleMailMessage mail = new SimpleMailMessage();
//             mail.setTo(user.getEmail());
//             mail.setSubject("Your Medicare password reset code");
//             mail.setText("Your verification code is " + code
//                     + ". It is valid for 10 minutes. If you did not request this, ignore this email.");
//             mailSender.send(mail);
//         });
//     }

//     // Steps 7-8 of the flow: check the code and save the new password
//     @Transactional(noRollbackFor = ResponseStatusException.class)
//     public void resetPassword(String email, String code, String newPassword) {
//         if (email == null || code == null) throw bad(INVALID);
//         if (newPassword == null || newPassword.length() < 8)
//             throw bad("Password must contain at least 8 characters.");

//         UserModel user = userRepository.findByEmail(email.trim()).orElseThrow(() -> bad(INVALID));
//         PasswordResetCode entry = codeRepository.findTopByUserOrderByIdDesc(user)
//                 .orElseThrow(() -> bad(INVALID));

//         if (entry.getExpiryDate().isBefore(LocalDateTime.now())) {
//             codeRepository.delete(entry);
//             throw bad("Code expired. Please request a new one.");
//         }
//         if (entry.getAttempts() >= 5) {
//             codeRepository.delete(entry);
//             throw bad("Too many wrong attempts. Please request a new code.");
//         }
//         if (!entry.getCode().equals(code.trim())) {
//             entry.setAttempts(entry.getAttempts() + 1);          // saved because of noRollbackFor
//             throw bad(INVALID);
//         }

//         user.setPassword(newPassword);                           // plain text for now; see "Later" below
//         userRepository.save(user);
//         codeRepository.delete(entry);                            // a code works only once
//     }
// }