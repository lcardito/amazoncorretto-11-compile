package com.imggaming.example;

import io.vavr.control.Either;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.function.Function;

public class App {
  private final static Map<String, String> someMap = new HashMap<>();

  public static void main(String[] args) {

    final Either<Callable<String>, Callable<String>> callableEither = Either.right(() -> null);

    callableEither
        .map(
            (Function<Callable<String>, Either<StringWrapper, StringWrapper>>)
                orderCallable -> {
                  StringWrapper order1 =
                      Optional.ofNullable(someMap.get("key_1"))
                          .map(StringWrapper::new)
                          .orElseGet(
                              ThrowingSupplier.exceptionSafe(
                                  () -> new StringWrapper(callableEither.get().call())));

                  return Either.right(order1);
                })
        .getOrElseGet(
            callable -> {
              StringWrapper wrapper =
                  Optional.ofNullable(someMap.get("other_key"))
                      .map(StringWrapper::new)
                      .orElseGet(
                          ThrowingSupplier.exceptionSafe(
                              () -> new StringWrapper(callable.call())));

              return Either.left(wrapper);
            });
  }
}
