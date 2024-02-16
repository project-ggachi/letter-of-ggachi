package com.letter.ggachi.domain.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Check Duplicated Info
 *
 * @author :uheejoon
 * @fileName :ValidateInfoResponse
 * @since :2024-02-14 오후 9:31
 */
@Getter
@Builder
public class ValidateInfoResponse {
  private Boolean isDuplicate;
}
