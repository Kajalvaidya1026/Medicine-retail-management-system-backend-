// @Entity
// @Table(name = "password_reset_codes")
// @Getter @Setter
// public class PasswordResetCode {
//     @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false, length = 6)
//     private String code;

//     @ManyToOne(optional = false)
//     @JoinColumn(name = "user_id")
//     private UserModel user;

//     @Column(nullable = false)
//     private LocalDateTime expiryDate;

//     @Column(nullable = false)
//     private int attempts = 0;
// }