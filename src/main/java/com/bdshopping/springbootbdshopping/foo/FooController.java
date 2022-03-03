package com.bdshopping.springbootbdshopping.foo;

import com.bdshopping.springbootbdshopping.foo.dto.CreateFooRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/foo")
public class FooController {
  private final FooService fooService;

  @GetMapping("/{first}")
  public ResponseEntity<Foo> findFooByFirst(@PathVariable String first) {
    Foo foundFoo = this.fooService.findByFirst(first);

    return new ResponseEntity<>(foundFoo, HttpStatus.OK);
  }

  @PostMapping("")
  public ResponseEntity<Foo> registerFoo(@RequestBody CreateFooRequestDto dto) {
    Foo createdFoo = this.fooService.registerFoo(dto);

    return new ResponseEntity<>(createdFoo, HttpStatus.OK);
  }
}
