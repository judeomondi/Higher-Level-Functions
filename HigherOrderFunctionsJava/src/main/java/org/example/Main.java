package org.example;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {

        int [] Loans = {12900, 15700, 4000, 3999, 8000, 20000, 900};

       double sum =  Arrays.stream(Loans)
                .filter(Loan  -> Loan > 5000)
                .mapToDouble(Loan -> Loan * 2.5)
                .reduce(0, (a,b) -> a+b);

        System.out.println(sum);

        int sums = Arrays.stream(Loans).sum();
        System.out.println(sums);

        int [] n = Arrays.stream(Loans).filter(Loan -> Loan == 900).toArray();
        System.out.println(Arrays.toString(n));



        System.out.println(sumUtil(a->a,2,3));
        System.out.println(sumUtil(a->a * a,2,3));
        System.out.println(sumUtil(a->a * a * a,2,3));
        System.out.println(sumUtil(a->2*2*2*a, 1,5));

        System.out.println("******************************\n");
        otherFunctions();

        //Optionals
        String y = resolve().orElse("Name");
        System.out.println(y);

    }

    public static int sumUtil(Function<Integer, Integer> op, int a, int b) {
        return op.apply(a) + op.apply(b);
    }

    public static void otherFunctions(){
        BiFunction<Integer, Integer, String> add = (a,b) -> Integer.toString(a+b);
        System.out.println(add.apply(1,5));
        Consumer<String> print = System.out::println;
        print.accept("Hello Jude");

        Supplier<String> sup = () -> "This is new";
        System.out.println(sup.get());

        Predicate<Integer> testEven = (a) -> a%2==0;
        System.out.println(testEven.test(5));


    }

    public static Optional<String> resolve(){
        String y = null;
        return Optional.ofNullable(y);
    }
}