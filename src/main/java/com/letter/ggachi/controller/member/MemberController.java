package com.letter.ggachi.controller.member;

import com.letter.ggachi.domain.dto.MemberLoginDto;
import com.letter.ggachi.domain.entity.Member;
import com.letter.ggachi.service.member.MemberService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

  private final MemberService memberService;
  @GetMapping("/login")
  public String login() {return "member/login";}
//  @PostMapping("/login")
//  public void login(@ModelAttribute @Valid MemberLoginDto memberLoginDto, BindingResult result, HttpSession session){
//    log.info("{}", memberLoginDto);
//    if(result.hasErrors()) {
//    }
//  }
  @PostMapping("/login")
  public void signup(@ModelAttribute MemberLoginDto memberLoginDto)
  {
    log.info("{}", memberLoginDto );
//    memberService.save(Member.builder().nickname(memberLoginDto.getLoginId()).password(memberLoginDto.getPassword()).build());
  }

  @ResponseBody
  @GetMapping("/{nickname}")
  public Member getNickname(@PathVariable String nickname) {
    return null;
  }


}
