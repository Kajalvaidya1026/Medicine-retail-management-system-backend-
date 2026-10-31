package com.deesha.medicine_distribution.repository;

import com.deesha.medicine_distribution.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {

    UserModel findByEmail(String email);

}
// @Transactional
// public void sendCode(String email) {
//     UserModel user = userRepository.findByEmail(email.trim());

//     // Unknown email: do nothing, so the response never reveals who is registered
//     if (user == null) {
//         return;
//     }

//     codeRepository.deleteByUser(user);                    // only one active code per user

//     String code = String.format("%06d", RANDOM.nextInt(1_000_000));

//     PasswordResetCode entry = new PasswordResetCode();
//     entry.setUser(user);
//     entry.setCode(code);
//     entry.setExpiryDate(LocalDateTime.now().plusMinutes(10));
//     codeRepository.save(entry);

//     // DEV ONLY: remove once mail works
//     System.out.println("RESET CODE for " + user.getEmail() + " = " + code);

//     SimpleMailMessage mail = new SimpleMailMessage();
//     mail.setTo(user.getEmail());
//     mail.setSubject("Your Medicare password reset code");
//     mail.setText("Your verification code is " + code
//             + ". It is valid for 10 minutes. If you did not request this, ignore this email.");
//     mailSender.send(mail);
// }