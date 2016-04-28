package br.com.hugobaes.softplan.webcast.lambda.tutorial;

import java.util.function.*;
import java.util.*;
import java.time.LocalDate;

public class NovasInterfaces
{
    /** Principais interfaces **/
    public static void main(String... λ)
    {
        // --- Declaração da Interface Funcional --- //
        
        Function<String, Integer> strToIntFunction;
        Supplier<LocalDate>       dateSupplier;
        Consumer<Collection<?>>   collectionConsumer;
        Predicate<Double>         doublePredicate;
        
        
        
        // --- Expressão Lambda --- //
        
        strToIntFunction   = s  -> s.length(); 
        dateSupplier       = () -> LocalDate.now();
        collectionConsumer = c  -> System.out.println("collection: " + c.toString());
        doublePredicate    = d  -> d >= 0.0;
        
        
        
        // --- Execução do Lambda --- //
        
        Integer length = strToIntFunction.apply("Anticonstitucionalissimamente");
        System.out.println("length: " + length);
        
        LocalDate now = dateSupplier.get();
        System.out.println("now: " + now);
        
        List<Integer> theNumbers = Arrays.asList(4,8,15,16,23,42);
        collectionConsumer.accept(theNumbers);
        
        boolean positive = doublePredicate.test(-1.618);
        System.out.println("positive: " + positive);
    }
    
    
    
    
    
    
    /** 2 Argumentos **/
    {
        BiFunction<String, String, Integer> biFunction;
        BiConsumer<String, Collection<?>> biConsumer;
        BiPredicate<Double, Double> biPredicate;
        
        biFunction = (s1, s2) -> s1.length() + s2.length();
        biConsumer = (prefix, c) -> System.out.println(prefix + ":" + c.toString());
        biPredicate = (d1, d2) -> d1 > d2;
    }
    
    /** Function de um único tipo **/
    {
        Function<String, String> function = s -> s.toUpperCase();
        
        UnaryOperator<String> unary = s -> s.toUpperCase();
        
        function = unary;
        
        
        BiFunction<String, String, String> biFunction = 
                (s1, s2) -> s1.concat(s2);
                
        BinaryOperator<String> binary = (s1, s2) -> s1.concat(s2);
        
        biFunction = binary;
    }
    
    /** Variações com tipos primitivos **/
    {
        IntFunction<String> intFunction;
        IntSupplier intSupplier;
        IntConsumer intConsumer;
        IntPredicate intPredicate;
        IntUnaryOperator intUnary;
        IntBinaryOperator intBinary;
        ToIntFunction<String> toIntFunction;
        ToIntBiFunction<String, Double> toIntBiFunction;

        
        
        LongFunction<String> longFunction;
        LongSupplier longSupplier;
        LongConsumer longConsumer;
        LongPredicate longPredicate;
        LongUnaryOperator longUnary;
        LongBinaryOperator longBinary;
        ToLongFunction<String> toLongFunction;
        ToLongBiFunction<String, Double> toLongBiFunction;
        

        
        DoubleFunction<String> doubleFunction;
        DoubleSupplier doubleSupplier;
        DoubleConsumer doubleConsumer;
        DoublePredicate doublePredicate;
        DoubleUnaryOperator doubleUnary;
        DoubleBinaryOperator doubleBinary;
        ToDoubleFunction<String> toDoubleFunction;
        ToDoubleBiFunction<String, Double> toDoubleBiFunction;
 
        
        BooleanSupplier booleanSupplier;
    }
}

class Tipo {}
class TipoRetorno extends Tipo {}
class TipoArgumento extends Tipo {}
