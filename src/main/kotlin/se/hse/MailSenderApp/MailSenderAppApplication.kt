package se.hse.MailSenderApp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MailSenderAppApplication

fun main(args: Array<String>) {
	runApplication<MailSenderAppApplication>(*args)
}
