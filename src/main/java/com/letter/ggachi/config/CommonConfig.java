package com.letter.ggachi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * please explain file!
 *
 * @author :uheejoon
 * @fileName :CommonConfig
 * @since :2024-02-15 오전 2:17
 */
@Configuration
public class CommonConfig {
  @Bean
  public PasswordEncoder passwordEncoder() {
    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }
}
