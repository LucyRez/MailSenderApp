package se.hse.MailSenderApp.auth

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import se.hse.MailSenderApp.user.AppUser
import se.hse.MailSenderApp.user.RegisterRequest
import se.hse.MailSenderApp.user.UserRepository

@Service
class AuthService(private val userRepository: UserRepository, private val passwordEncoder: PasswordEncoder) {

    fun register(request: RegisterRequest): AuthResponse {
        val user = AppUser(null, request.username, passwordEncoder.encode(request.password))
        userRepository.save(user)

        return AuthResponse("df")
    }
}