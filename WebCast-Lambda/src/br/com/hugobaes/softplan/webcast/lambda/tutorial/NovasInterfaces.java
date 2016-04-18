package br.com.hugobaes.softplan.webcast.lambda.tutorial;

import java.time.LocalDate;
import java.util.Collection;
import java.util.function.*;

public class NovasInterfaces
{
    // Principais interfaces
    {
        Function<String, Integer> function;
        Supplier<LocalDate> supplier;
        Consumer<Collection<?>> consumer;
        Predicate<Double> predicate;
        
        function = s -> s.length(); 
        supplier = () -> LocalDate.now();
        consumer = c -> System.out.println(c.toString());
        predicate = d -> d > 0.5;
    }
    
    // 2 Argumentos
    {
        BiFunction<String, String, Integer> biFunction;
        BiConsumer<String, Collection<?>> biConsumer;
        BiPredicate<Double, Double> biPredicate;
        
        biFunction = (s1, s2) -> s1.length() + s2.length();
        biConsumer = (prefix, c) -> System.out.println(prefix + ":" + c.toString());
        biPredicate = (d1, d2) -> d1 > d2;
    }
    
    // Subclasses de Function
    {
        Function<String, String> function = str -> str.toUpperCase();
        UnaryOperator<String> unary = str -> str.toUpperCase();
        
        function = unary;
        
        BiFunction<String, String, String> biFunction = (str1, str2) -> str1.concat(str2);
        BinaryOperator<String> binary = (str1, str2) -> str1.concat(str2);
        
        biFunction = binary;
    }
    
    // Primitivas como argumentos
    {
        IntFunction<String> intFunction;
        IntConsumer intConsumer;
        IntPredicate intPredicate;
        IntUnaryOperator intUnary;
        IntBinaryOperator intBinary;
        
        
        LongFunction<String> longFunction;
        LongConsumer longConsumer;
        LongPredicate longPredicate;
        LongUnaryOperator longUnary;
        LongBinaryOperator longBinary;

        
        DoubleFunction<String> doubleFunction;
        DoubleConsumer doubleConsumer;
        DoublePredicate doublePredicate;
        DoubleUnaryOperator doubleUnary;
        DoubleBinaryOperator doubleBinary;

    }
    
    // Primitivas como Retorno
    {
        IntSupplier intSupplier;
        ToIntFunction<String> toIntFunction;
        ToIntBiFunction<String, Double> toIntBiFunction;
        
        LongSupplier longSupplier;
        ToLongFunction<String> toLongFunction;
        ToLongBiFunction<String, Double> toLongBiFunction;
        
        DoubleSupplier doubleSupplier;
        ToDoubleFunction<String> toDoubleFunction;
        ToDoubleBiFunction<String, Double> toDoubleBiFunction;
        
        BooleanSupplier booleanSupplier;
    }
}

class Tipo {}
class TipoRetorno extends Tipo {}
class TipoArgumento extends Tipo {}
