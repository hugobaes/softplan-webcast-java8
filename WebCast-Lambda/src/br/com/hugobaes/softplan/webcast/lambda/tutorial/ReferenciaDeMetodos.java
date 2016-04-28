package br.com.hugobaes.softplan.webcast.lambda.tutorial;

import java.time.LocalDate;
import java.util.*;
import java.util.function.*;

public class ReferenciaDeMetodos
{
    public static void main(String... λ)
    {
        /*** Método Estático ***/
        
        Function<String, Integer> intParser;
        
        intParser = s -> Integer.valueOf(s);
        
        intParser = Integer::valueOf;
        
        System.out.println("Int: " + intParser.apply("000012345"));
        
        
        
        
        /*** Construtor ***/
        
        Supplier<Date> dateGenerator;
        
        dateGenerator = () -> new Date();
        
        dateGenerator = Date::new;
        
        System.out.println("Now: " + dateGenerator.get());
        
        
        
        
        /*** Método de Instância de um objeto específico ***/
        
        List<String> fruitList = Arrays.asList("apple", "orange", "watermelon");

        Predicate<String> isFruit;
        
        isFruit = s -> fruitList.contains(s);
        
        isFruit = fruitList::contains;
        
        System.out.println("Airplane? " + isFruit.test("airplane"));
        

        
        
        /*** Método de Instância de um objeto arbitário ***/
        
        Function<String, String> toUpper;
        
        toUpper = s -> s.toUpperCase();
        
        toUpper = String::toUpperCase;
        
        System.out.println(toUpper.apply("O Rly? Ya Rly! No Way!"));
        
        
        
        /**************************************************/
    }
}
