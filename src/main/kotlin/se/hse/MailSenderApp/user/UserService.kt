package se.hse.MailSenderApp.user

import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private val userRepository: UserRepository): UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        if (username == null) {
            throw UsernameNotFoundException("There is no such user")
        }

        val user = userRepository.findByUsername(username) ?: throw UsernameNotFoundException("There is no such user")

        return User(user.username, user.password, Collections.singleton(user.role))
    }

}