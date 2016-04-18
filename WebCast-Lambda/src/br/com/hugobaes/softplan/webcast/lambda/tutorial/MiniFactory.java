package br.com.hugobaes.softplan.webcast.lambda.tutorial;

import java.util.*;
import java.util.function.*;
import java.util.stream.IntStream;

public class MiniFactory<T>
{
    Supplier<T> generator;
    Function<T, T> processor;
    Predicate<T> validator;
    Consumer<T> aggregator;
    Runnable deployer;
    
    void startEngine(int count) {
        while (count-->0) 
        {
            T object = generator.get();
            T processed = processor.apply(object);
            if (validator.test(processed)) 
                aggregator.accept(processed);
        }
        deployer.run();
    }
    
    public static void main(String... $)
    {
        List<Integer> myNumbers = new ArrayList<>();
        
        MiniFactory<Integer> engine = new MiniFactory<>();
        engine.generator = () -> (int)(Math.random()*100);
        engine.processor = x -> x - 50;
        engine.validator = x -> x % 2 == 0;
        engine.aggregator = x -> myNumbers.add(x);
        engine.deployer = () -> System.out.println(myNumbers);
        
        engine.startEngine(10);
        
        x();
    }
    
    static void x()
    {
        List<Integer> myNumbers = new ArrayList<>();

        MiniFactory<Integer> engine = new MiniFactory<>();
        engine.generator = () -> (int)(1_000_00);
        engine.processor = x -> x/2;
        engine.validator = x -> true;
        engine.aggregator = x -> myNumbers.add(x+123);
        engine.deployer = () -> System.out.printf("Result[%d]:%s", 
                myNumbers.size(), myNumbers);
        
        engine.startEngine(3);
    }
}
