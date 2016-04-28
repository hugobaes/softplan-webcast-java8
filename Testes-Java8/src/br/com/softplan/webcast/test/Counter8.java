package br.com.softplan.webcast.test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

class Counter8
{
    int count;
    void increment() {count++;}
    
    @Override
    public String toString()
    {
        return ""+count;
    }
    
    public static void main(String... λ) throws Exception
    {
        objectCounter();
        conventionalCounter();
        threadSafeCounter();
        parallelStreamCounter();
    }
    
    static void objectCounter() throws InterruptedException
    {
        Counter8 count = new Counter8();
        
        ExecutorService executor = Executors.newFixedThreadPool(32);
        IntStream
        	.range(0, 1_000_000)
        	.forEach(i -> executor.submit(count::increment));
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        
        System.out.println("Object Counter: " + count);
    }
    
    static void conventionalCounter() throws InterruptedException {
        int count = 0;
        int chunchoCount[] = new int[1];

        ExecutorService executor = Executors.newFixedThreadPool(32);
        for (int i = 0; i < 1_000_000; i++) {
            executor.submit(() -> chunchoCount[0]++);
        }
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        
        System.out.println("Conventional Counter: " + chunchoCount[0]);
    }
    
    /**
     * http://stackoverflow.com/questions/16976660/functional-way-to-implement-a-thread-safe-shared-counter
     */
    static void threadSafeCounter() throws InterruptedException 
    {
        final AtomicInteger count = new AtomicInteger();

        ExecutorService executor = Executors.newFixedThreadPool(32);
        for (int i = 0; i < 1_000_000; i++) {
            executor.submit(() -> count.incrementAndGet());
        }
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        
        System.out.println("Thread Safe Counter: " + count.get());
    }
    
    static void parallelStreamCounter() throws InterruptedException {
        int count = 0;
        int chunchoCount[] = new int[1];

        IntStream
            .range(0, 1_000_000)
            .parallel()
            .forEach(i -> chunchoCount[0]++);
        
        System.out.println("Parallel Stream Counter: " + chunchoCount[0]);
    }
    
    
}
