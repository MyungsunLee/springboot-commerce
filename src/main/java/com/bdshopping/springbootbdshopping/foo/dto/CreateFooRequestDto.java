package com.bdshopping.springbootbdshopping.foo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CreateFooRequestDto {
  private String first;
  private String last;
}
