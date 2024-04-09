package se.hse.MailSenderApp.auth

import org.springframework.stereotype.Service
import se.hse.MailSenderApp.user.AppUser
import se.hse.MailSenderApp.user.RegisterRequest
import se.hse.MailSenderApp.user.UserRepository

@Service
class AuthService(private val userRepository: UserRepository) {

    fun register(request: RegisterRequest): AuthResponse {
        val user = AppUser(null, request.username, request.password)
        userRepository.save(user)

        return AuthResponse("df")
    }
}