package se.hse.MailSenderApp.user

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import se.hse.MailSenderApp.auth.AuthResponse
import se.hse.MailSenderApp.auth.AuthService

@RestController
@RequestMapping("/user")
class UserController(val authService: AuthService) {
    @PostMapping("/register")
    fun register(@RequestBody registrationRequest: RegisterRequest): ResponseEntity<AuthResponse> {
        return ResponseEntity.ok(authService.register(registrationRequest))
    }

    @PostMapping("/login")
    fun login(
        @RequestBody request: RegisterRequest
    ): ResponseEntity<AuthResponse> {
        return ResponseEntity.ok(authService.authenticate(request))
    }
}