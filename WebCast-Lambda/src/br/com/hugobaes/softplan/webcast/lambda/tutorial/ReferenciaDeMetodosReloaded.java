package br.com.hugobaes.softplan.webcast.lambda.tutorial;

import java.util.*;
import java.util.function.*;

public class ReferenciaDeMetodosReloaded
{
    public static void main(String... λ)
    {
        /*** Método Estático ***/
        
        Function<String, Integer> intParser = Integer::valueOf;
        
        intParser = s -> Integer.valueOf(s);
        
        System.out.println("Int: " + intParser.apply("000012345"));
        
        
        
        
        
        /*** Construtor ***/
        
        Supplier<Date> dateGenerator = Date::new;
        
        dateGenerator = () -> new Date();
        
        System.out.println("Now: " + dateGenerator.get());
        
        

        
        Function<Long, Date> dateConverter = Date::new;
        
        dateConverter = l -> new Date(l);
        
        System.out.println("Not Now: " + dateConverter.apply(489578827777L));
        
        
        
        
        
        /*** Método de Instância de um objeto específico ***/
        
        List<String> fruitList = Arrays.asList("apple", "orange", "watermelon");

        Predicate<String> isFruit = fruitList::contains;
        
        isFruit = s -> fruitList.contains(s);
        
        System.out.println("Airplane? " + isFruit.test("airplane"));
        

        
        
        /*** Método de Instância de um objeto arbitário ***/
        
        BiPredicate<List<String>, String> isOnList = List::contains;
        
        isOnList = (list, str) -> list.contains(str);
        
        System.out.println("Airplane?¿? " + isOnList.test(fruitList, "airplane"));
        
        
        
        
        List<String> vehicleList = Arrays.asList("car", "boat", "airplane");
        
        System.out.println("Airplane!!1! " + isOnList.test(vehicleList, "airplane"));

        
        /**************************************************/
    }
}