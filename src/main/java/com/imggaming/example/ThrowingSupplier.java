package com.imggaming.example;

import java.util.Objects;
import java.util.function.Supplier;

@FunctionalInterface
public interface ThrowingSupplier<T, E extends Exception> {

  T get() throws E;

  static <T, E extends Exception> Supplier<T> exceptionSafe(
      ThrowingSupplier<T, E> throwingSupplier) {
    Objects.requireNonNull(throwingSupplier);
    return () -> {
      try {
        return throwingSupplier.get();
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    };
  }
}
