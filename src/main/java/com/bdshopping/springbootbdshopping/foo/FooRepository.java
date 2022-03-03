package com.bdshopping.springbootbdshopping.foo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface FooRepository extends MongoRepository<Foo, String> {
  public Optional<Foo> findByFirst(String first);
  public List<Foo> findByLast(String last);
}
