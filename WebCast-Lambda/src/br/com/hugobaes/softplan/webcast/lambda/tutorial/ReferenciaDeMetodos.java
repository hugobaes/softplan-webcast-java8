package br.com.hugobaes.softplan.webcast.lambda.tutorial;

import java.time.LocalDate;
import java.util.*;
import java.util.function.*;

public class ReferenciaDeMetodos
{
    public static void main(String... $)
    {
        Function<String, Integer> function;
        Supplier<LocalDate> supplier;
        Consumer<Collection<?>> consumer;
        Predicate<String> predicate;

        function = String::length; 
        supplier = LocalDate::now;
        consumer = System.out::println;
        predicate = "my long phrase"::contains;
        
        System.out.println(function.apply("12345"));
        System.out.println(supplier.get());
        consumer.accept(Arrays.asList(1,2,3,4,5));
        System.out.println(predicate.test("long"));

    }
}
