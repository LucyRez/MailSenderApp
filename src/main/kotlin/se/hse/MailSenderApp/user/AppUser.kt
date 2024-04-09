package se.hse.MailSenderApp.user

import jakarta.persistence.*

@Entity
data class AppUser (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    val username: String,

    val password: String,

    @Enumerated(EnumType.STRING)
    var role: UserRole = UserRole.USER
)

enum class UserRole {
    ADMIN, USER;
}