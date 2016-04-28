package br.com.softplan.webcast.test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class Counter7
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
    }

    static void objectCounter() throws InterruptedException
    {
        final Counter7 count = new Counter7();
        
        ExecutorService executor = Executors.newFixedThreadPool(32);
        for (int i = 0; i < 1_000_000; i++) {
            executor.submit(new Runnable() 
            {
                @Override
                public void run()
                {
                    count.increment();
                }
            });
        }
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        
        System.out.println("Object Counter: " + count);
    }
    
    /**
     * http://winterbe.com/posts/2015/04/30/java8-concurrency-tutorial-synchronized-locks-examples/
     */
    static void conventionalCounter() throws InterruptedException 
    {
        final int count = 0;
        final int chunchoCount[] = new int[1];

        ExecutorService executor = Executors.newFixedThreadPool(32);
        for (int i = 0; i < 1000000; i++) {
            executor.submit(new Runnable() {
                public void run() {
                    chunchoCount[0]++;
                }
            });
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
        for (int i = 0; i < 1000000; i++) {
            executor.submit(new Runnable() {
                public void run() {
                    count.incrementAndGet();
                }
            });
        }
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        
        System.out.println("Thread Safe Counter: " + count.get());
    }
    
    
    

}
