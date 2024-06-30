package me.tenyks.jdk_plus.lang;


/**
 * Represents a function that accepts three arguments and produces a result.
 *
 * @param <T1> The type of the first input to the function
 * @param <T2> The type of the second input to the function
 * @param <T3> The type of the third input to the function
 * @param <R>  the type of the result of the function
 * @author Ben Hale
 */
@FunctionalInterface
public interface Function3<T1, T2, T3, R> {

    /**
     * Applies this function to the given arguments.
     *
     * @param t1 the first input argument
     * @param t2 the second input argument
     * @param t3 the third input argument
     * @return the function result
     */
    R apply(T1 t1, T2 t2, T3 t3);

}