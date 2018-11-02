package com.codecool;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;
import java.util.function.UnaryOperator;

public class Streams {
    public static void main(String[] args) {
        /*
         * Create a stream out of the following array.
         */

        String[] a1 = {"one", "two", "three"};
        Stream<String> s1 = Arrays.stream(a1);
        s1.forEach(result -> System.out.print(result + " "));
        System.out.print("\n");

        /*
         * Create a stream containing the Strings "one" , "two" and "three"
         * without using an array
         */

        Stream<String> s2 = Stream.of("one", "two", "three");
        s2.forEach(result -> System.out.print(result + " "));
        System.out.print("\n");

        /*
         * Create a stream using a stream builder.
         */

        Stream.Builder<String> b1 = Stream.builder();
        b1.accept("one");
        b1.accept("two");
        b1.accept("three");
        Stream<String> s3 = b1.build();
        s3.forEach(result -> System.out.print(result + " "));
        System.out.print("\n");

        /*
         * Collect one of the above defined streams into a list.
         *
         * HINT: the keyword here is "collect"
         */

        Stream<String> sX = Stream.of("one", "two", "three");  // This step is necessary for printing, because Java 8 streams cannot be reused.
        List<String> l1 = sX.collect(Collectors.toList());
        l1.forEach(result -> System.out.print(result + " "));
        System.out.print("\n");

        /*
         * Streams can be infinite.  We obviously cannot create such a
         * stream by supplying all the elements ourselves.
         *
         * HINT: When looking for methods to create such streams
         * realize that:
         * - These methods cannot belong to an instance
         * - They are returning streams
         */

        /*
         * Create a stream of the powers of two.
         */

        Integer twoToTheZeroth = 1;
        UnaryOperator<Integer> doubler = (Integer x) -> 2 * x;
        Stream<Integer> s4 = Stream.iterate(twoToTheZeroth, doubler);

        /*
         * Create a stream containing the first ten elements of s4.
         */

        Stream<Integer> s5 = s4.limit(10);
        s5.forEach(result -> System.out.print(result + " "));
        System.out.print("\n");

        /*
         * Create a stream containing the elements of the Fibonacci
         * sequence.
         *
         * HINT: You will need to create a new class for this.
         */

        Fibonacci fibSupp = new Fibonacci();
        Stream<Integer> s6 = Stream.generate(fibSupp).limit(10);
        System.out.print(fibSupp.firstNumber + " " + fibSupp.secondNumber + " ");
        s6.forEach(result -> System.out.print(result + " "));

    }
}
