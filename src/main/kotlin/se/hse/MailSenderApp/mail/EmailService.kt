package se.hse.MailSenderApp.mail

import jakarta.mail.MessagingException
import jakarta.mail.internet.MimeMessage
import org.springframework.context.annotation.Bean
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.JavaMailSenderImpl
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Service
class EmailService {
    private val mailSender: JavaMailSender = getJavaMailSender()

    @Async
    fun send(to: String, email: String?) {

    }

    @Bean
    fun getJavaMailSender(): JavaMailSender {

    }


    fun buildConfirmationEmail(name: String, link: String): String {
        return """<div style="font-family:Helvetica,Arial,sans-serif;font-size:16px;margin:0;color:#0b0c0c">

<span style="display:none;font-size:1px;color:#fff;max-height:0"></span>

  <table role="presentation" width="100%" style="border-collapse:collapse;min-width:100%;width:100%!important" cellpadding="0" cellspacing="0" border="0">
    <tbody><tr>
      <td width="100%" height="53" bgcolor="#0b0c0c">
        
        <table role="presentation" width="100%" style="border-collapse:collapse;max-width:580px" cellpadding="0" cellspacing="0" border="0" align="center">
          <tbody><tr>
            <td width="70" bgcolor="#0b0c0c" valign="middle">
                <table role="presentation" cellpadding="0" cellspacing="0" border="0" style="border-collapse:collapse">
                  <tbody><tr>
                    <td style="padding-left:10px">
                  
                    </td>
                    <td style="font-size:28px;line-height:1.315789474;Margin-top:4px;padding-left:10px">
                      <span style="font-family:Helvetica,Arial,sans-serif;font-weight:700;color:#ffffff;text-decoration:none;vertical-align:top;display:inline-block">Confirm your email</span>
                    </td>
                  </tr>
                </tbody></table>
              </a>
            </td>
          </tr>
        </tbody></table>
        
      </td>
    </tr>
  </tbody></table>
  <table role="presentation" class="m_-6186904992287805515content" align="center" cellpadding="0" cellspacing="0" border="0" style="border-collapse:collapse;max-width:580px;width:100%!important" width="100%">
    <tbody><tr>
      <td width="10" height="10" valign="middle"></td>
      <td>
        
                <table role="presentation" width="100%" cellpadding="0" cellspacing="0" border="0" style="border-collapse:collapse">
                  <tbody><tr>
                    <td bgcolor="#1D70B8" width="100%" height="10"></td>
                  </tr>
                </tbody></table>
        
      </td>
      <td width="10" valign="middle" height="10"></td>
    </tr>
  </tbody></table>



  <table role="presentation" class="m_-6186904992287805515content" align="center" cellpadding="0" cellspacing="0" border="0" style="border-collapse:collapse;max-width:580px;width:100%!important" width="100%">
    <tbody><tr>
      <td height="30"><br></td>
    </tr>
    <tr>
      <td width="10" valign="middle"><br></td>
      <td style="font-family:Helvetica,Arial,sans-serif;font-size:19px;line-height:1.315789474;max-width:560px">
        
            <p style="Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c">Hi $name,</p><p style="Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c"> Thank you for registering. Please click on the below link to activate your account: </p><blockquote style="Margin:0 0 20px 0;border-left:10px solid #b1b4b6;padding:15px 0 0.1px 15px;font-size:19px;line-height:25px"><p style="Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c"> <a href="$link">Activate Now</a> </p></blockquote>
 Link will expire in 15 minutes. <p>See you soon</p>        
      </td>
      <td width="10" valign="middle"><br></td>
    </tr>
    <tr>
      <td height="30"><br></td>
    </tr>
  </tbody></table><div class="yj6qo"></div><div class="adL">

</div></div>"""
    }

    fun buildCredentialsEmail(email: String, password: String): String {
        return "<strong>Your email has been successfully verified!</strong> " +
                "<div> <p>You can now use the credentials below to authenticate.</p> " +
                "<p>Email: " + email + "</p> <p>Password: " + password + "</p> </div>"
    }

}