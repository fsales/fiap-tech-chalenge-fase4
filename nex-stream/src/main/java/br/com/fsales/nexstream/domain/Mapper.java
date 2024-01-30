package br.com.fsales.nexstream.domain;

/**
 * interface funcional personalizada que aceite uma função de mapeamento como um argumento
 *
 * @param <T>
 * @param <R>
 */
@FunctionalInterface
public interface Mapper<T, R> {

    R apply(T t);

}
