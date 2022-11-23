package com.app.food.team.foodapp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@ConfigurationProperties(prefix = "rsa")
public record RsaKeyPropertiesConfiguration(RSAPublicKey publicKey, RSAPrivateKey privateKey) {
}
