package se.hse.MailSenderApp.auth

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import se.hse.MailSenderApp.user.AppUser
import java.util.*
import javax.crypto.SecretKey

@Service
class JwtService {
    private val secretKey = "my0320character0ultra0secure0and0ultra0long0secret"

    fun extractAllClaims(token: String): Claims {
        return Jwts.parser().verifyWith(signingKey())
            .build().parseSignedClaims(token).payload
    }

    fun isValid(token: String, user: UserDetails): Boolean {

        return extractAllClaims(token).subject == user.username && !extractAllClaims(token).expiration.before(Date())
    }

    fun generateToken(user: AppUser): String {

        return Jwts.builder().subject(user.username)
            .issuedAt(Date(System.currentTimeMillis()))
            .expiration(Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))
            .signWith(signingKey())
            .compact()
    }

    private fun signingKey(): SecretKey {
        val keyBytes = Decoders.BASE64.decode(secretKey)
        return Keys.hmacShaKeyFor(keyBytes)
    }
}