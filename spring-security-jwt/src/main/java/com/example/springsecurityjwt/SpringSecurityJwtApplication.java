package com.example.springsecurityjwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLOutput;
import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class SpringSecurityJwtApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		final String Secret_Key = "hdw6gg8";

		//Generate Token using JWT java API
		String token =
		Jwts.builder()
				.setId("A1234") //id
				.setSubject("Rakesh") //subject or name
				.setIssuer("GOVTOFINDIA")  // provide
				.setIssuedAt(new Date(System.currentTimeMillis())) // token generation time
				.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(1L))) // token expiry time
				.signWith(SignatureAlgorithm.HS256,  //SIgn algorithm
						Base64.getEncoder().encode(Secret_Key.getBytes())) //secretkey
				.compact(); // returns token in string format

		System.out.println(token);

		// Reading/Parsing the token
		Claims c =
		Jwts.parser().setSigningKey(Base64.getEncoder().encode(Secret_Key.getBytes())) // secret key
		.parseClaimsJws(token).getBody();

		System.out.println(c.getExpiration());
	}
}

