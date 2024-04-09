package se.hse.MailSenderApp.user

import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority

@Entity
data class AppUser(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    val username: String,

    val password: String,

    @Enumerated(EnumType.STRING)
    var role: UserRole = UserRole.USER
)

enum class UserRole : GrantedAuthority {
    ADMIN, USER;
    override fun getAuthority(): String {
        return name
    }
}