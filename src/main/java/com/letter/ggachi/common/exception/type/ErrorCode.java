package com.letter.ggachi.common.exception.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

  LOGIN_INVALID_FAILED(HttpStatus.UNAUTHORIZED, "회원 정보를 불러오는데 실패했습니다."),

  // MEMBER
  ALREADY_EXISTS_EMAIL(HttpStatus.BAD_REQUEST, "이미 사용중인 이메일입니다."),
  ALREADY_EXISTS_NICKNAME(HttpStatus.BAD_REQUEST, "이미 사용중인 닉네임입니다."),

  INVALID_MEMBER_ID(HttpStatus.BAD_REQUEST, "잘못된 회원 번호입니다."),
  INVALID_EMAIL(HttpStatus.BAD_REQUEST, "존재하지 않는 이메일입니다."),
  INVALID_NICKNAME(HttpStatus.BAD_REQUEST, "잘못된 형식의 닉네임입니다."),

//  INACTIVE_MEMBER(HttpStatus.UNAUTHORIZED, "이메일 인증이 되지 않은 사용자입니다."),
//  BLOCKED_MEMBER(HttpStatus.UNAUTHORIZED, "정지된 사용자입니다."),
//  WITHDRAWAL_MEMBER(HttpStatus.UNAUTHORIZED, "탈퇴한 사용자입니다."),
//
//  INACTIVE_SING_IN(HttpStatus.UNAUTHORIZED, "로그인이 필요한 서비스입니다."),
  MISMATCH_PASSWORD(HttpStatus.BAD_REQUEST, "비밀번호가 일치하지 않습니다."),

  // POST
  INVALID_POST_ID(HttpStatus.BAD_REQUEST, "존재하지 않는 게시글 번호입니다."),
  MISMATCH_WRITER(HttpStatus.BAD_REQUEST, "작성자가 아닙니다."),

  ;

  private final HttpStatus httpStatus;
  private final String message;
}
