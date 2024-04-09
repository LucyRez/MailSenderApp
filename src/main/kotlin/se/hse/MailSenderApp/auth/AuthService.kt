package se.hse.MailSenderApp.auth

import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import se.hse.MailSenderApp.user.AppUser
import se.hse.MailSenderApp.user.RegisterRequest
import se.hse.MailSenderApp.user.UserRepository
import java.lang.Exception


@Service
class AuthService(private val userRepository: UserRepository, private val passwordEncoder: PasswordEncoder,
    private val jwtService: JwtService, private val authenticationManager: AuthenticationManager
) {

    fun register(request: RegisterRequest): AuthResponse {
        val user = AppUser(null, request.username, passwordEncoder.encode(request.password))
        userRepository.save(user)

        return AuthResponse(jwtService.generateToken(user))
    }

    fun authenticate(request: RegisterRequest): AuthResponse {
        authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(
                request.username,
                request.password
            )
        )
        val user = userRepository.findByUsername(request.username) ?: throw Exception("User not found")
        val jwt = jwtService.generateToken(user)

        return AuthResponse(jwt)
    }
}