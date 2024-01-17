package com.letter.ggachi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class GgachiApplication {

  public static void main(String[] args) {
    SpringApplication.run(GgachiApplication.class, args);
  }

}
