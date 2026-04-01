package br.com.apilocallinkmanager.commom;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Fixture {

    public static <T> T make(final Class<T> clazz) {
        return Instancio.create(clazz);
    }

    public static <T> T make(final T mockClass) {
        return (T) Instancio.create(mockClass.getClass());
    }

    public static <T> List<T> makeList(final Class<T> clazz) {
        return makeList(clazz, 1);
    }

    public static <T> List<T> makeList(final Class<T> clazz, final Integer size) {
        return Instancio.ofList(clazz)
            .size(size)
            .create();
    }

    public static String makeStringOfSize(final Integer size) {
        return IntStream.rangeClosed(1, size)
            .mapToObj(n -> "1")
            .collect(Collectors.joining());
    }
}
