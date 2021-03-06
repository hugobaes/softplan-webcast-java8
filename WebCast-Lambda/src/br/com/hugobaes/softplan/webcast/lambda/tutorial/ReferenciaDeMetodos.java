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
        
        intParser = Integer::valueOf;
        
        intParser = s -> Integer.valueOf(s);
        
        System.out.println("Int: " + intParser.apply("000012345"));
        
        
        
        
        /*** Construtor ***/
        
        Supplier<Date> dateGenerator;
        
        dateGenerator = Date::new;
        
        dateGenerator = () -> new Date();
        
        System.out.println("Now: " + dateGenerator.get());
        

        
        
        
        /*** Método de Instância de um objeto específico ***/
        
        List<String> fruitList = Arrays.asList("apple", "orange", "watermelon");

        Predicate<String> isFruit;
        
        isFruit = fruitList::contains;
        
        isFruit = s -> fruitList.contains(s);
        
        System.out.println("Airplane? " + isFruit.test("airplane"));
        

        
        
        /*** Método de Instância de um objeto arbitrário ***/
        
        Function<String, String> toUpper;
        
        toUpper = String::toUpperCase;
        
        toUpper = s -> s.toUpperCase();
        
        System.out.println(toUpper.apply("O Rly? Ya Rly! No Way!"));
        
        
        
        /**************************************************/
    }
}

