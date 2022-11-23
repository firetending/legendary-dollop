## All back-end documentation goes here:
Please don't make changes directly to main branch

## Documentation:
To create private/public keys for JWT encoding:
    in resources/certs:
        openssl genrsa -out keypair.pem 2048
        openssl rsa -in keypair.pem -pubout -out public.pem
        openssl pkcs8 -topk8 -inform PEM -outform PEM -nocrypt -in keypair.pem -out private.pem
    then remove keypair.pem

    These key files should not be added to git in the future
    For production we should re-generate the keys and add them to gitignore

JWT authentication: https://www.youtube.com/watch?v=KYNR5js2cXE&t=1208s

To install a mock mail server for development:
    npm install -g maildev
    maildev --ip 127.0.0.1 --smtp 1025
For whatever reason spring is ignoring the mail config


## Sending emails:
https://www.quickprogrammingtips.com/spring-boot/how-to-send-email-from-spring-boot-applications.html


## Spring security docs:
https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter
https://www.baeldung.com/java-config-spring-security
https://spring.io/guides/gs/securing-web/
https://docs.spring.io/spring-security/reference/servlet/authorization/authorize-http-requests.html
https://github.com/spring-projects/spring-security-samples/blob/main/servlet/spring-boot/java/jwt/login/src/main/java/example/RestConfig.java
https://www.javaavancado.com/wp-content/uploads/2016/05/Spring_Security_Completo.pdf
https://docs.spring.io/spring-security/reference/servlet/exploits/csrf.html


## Spring Sessions:
https://www.javainuse.com/spring/springboot_session

## Sending emails:
https://www.courier.com/guides/java-send-email/
https://netcorecloud.com/tutorials/examples-for-sending-emails-from-javamail-api/

## Free Email Servers:
https://medevel.com/list-os-mail-server/
https://www.hmailserver.com/download

Paid Services with free option:
https://sendgrid.com
https://pepipost.com


implementation 'org.springframework.session:spring-session-core'




