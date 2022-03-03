package com.bdshopping.springbootbdshopping.foo;

import com.bdshopping.springbootbdshopping.foo.dto.CreateFooRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FooService {
  private final FooRepository fooRepository;

  public Foo findByFirst(String first) {
    Optional<Foo> foundFoo = this.fooRepository.findByFirst(first);
    return foundFoo.orElseThrow();
  }

  public Foo registerFoo(CreateFooRequestDto dto) {
    Foo foo = Foo.builder()
      .first(dto.getFirst())
      .last(dto.getLast()).build();

    return this.fooRepository.save(foo);
  }
}
