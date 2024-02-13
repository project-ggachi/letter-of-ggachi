package com.letter.ggachi.common.exception;

import com.letter.ggachi.common.exception.type.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PostException {
  private final HttpStatus httpStatus;
  private final String message;

  public PostException(ErrorCode errorCode) {
    this.httpStatus = errorCode.getHttpStatus();
    this.message = errorCode.getMessage();
  }
}
