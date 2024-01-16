package com.letter.ggachi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class Hello {
  @GetMapping
  public String index() {
    return "index.html";
  }
}
