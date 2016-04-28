package br.com.hugobaes.softplan.webcast.lambda.tutorial;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.*;
import java.util.stream.IntStream;

public class ProductionLine<T>
{
    Supplier<T> generator;
    Predicate<T> selector;
    Function<T, T> processor;
    Consumer<T> aggregator;
    Runnable deployer;
    
    void startEngine(int total) 
    {
        while (total > 0) 
        {
            T element = generator.get();
            if (selector.test(element)) 
            { 
                T processed = processor.apply(element);
                aggregator.accept(processed);
                total--;
            }
        }
        deployer.run();
    }
    
    public static void main(String... λ)
    {
        List<Integer> numberList = new ArrayList<>();
        
        ProductionLine<Integer> factory = new ProductionLine<>();
        factory.generator  = () -> (int)(Math.random()*100);
        factory.selector   = x -> x % 2 == 0;
        factory.processor  = x -> x - 50;
        factory.aggregator = numberList::add;
        factory.deployer   = () -> System.out.println(numberList);
        
        factory.startEngine(10);
    }
    
    
    
    public static void main2(String... λ)
    {
        String[] molecule = {"T", "A", "C", "G"};
        StringBuilder dna = new StringBuilder();

        ProductionLine<String> factory = new ProductionLine<>();
        factory.generator  = () -> molecule[(int)(Math.random()*4)];
        factory.selector   = x -> Math.random() < 0.5;
        factory.processor  = x -> Math.random() < 0.1 ? "?" : x;
        factory.aggregator = dna::append;
        factory.deployer   = () -> 
            System.out.printf("Sequence[%d]: %s", dna.length(), dna.toString());
        
        factory.startEngine(20);
    }
}
