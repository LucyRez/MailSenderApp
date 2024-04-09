package se.hse.MailSenderApp.mail

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/mail")
class EmailController(val emailService: EmailService) {

    @PostMapping("/send")
    fun sendEmail(@RequestBody email: EmailRequest): ResponseEntity<String> {

    }

}