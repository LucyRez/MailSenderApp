package se.hse.MailSenderApp.user

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<AppUser, Long> {
    fun findByUsername(username: String): AppUser?
}