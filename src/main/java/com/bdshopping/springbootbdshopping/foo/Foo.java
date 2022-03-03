package com.bdshopping.springbootbdshopping.foo;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Foo {
  @Id
  private String id;

  private String first;
  private String last;
}
