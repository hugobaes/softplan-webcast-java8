package br.com.hugobaes.softplan.webcast.lambda;

import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.concurrent.*;

/**
 * 
 * @author Hugo Baés
 */
public class ComparativoJava7Java8
{
    public static void main(String[] args) throws Exception
    {
        Runnable runnable;
        Callable<?> callable;
        Comparator<?> comparator;
        ActionListener actionListener;
        
        BlocoSimples blocoSimples;
        BlocoGenerico<String, Integer> blocoGenerico;
        
        runnable = new Runnable() 
        {
            @Override
            public void run()
            {
                System.out.println("Runnable");
            }
        };
        
        new Thread(runnable).start();
        
        callable = new Callable<String>()
        {
            @Override
            public String call() throws Exception
            {
                System.out.println("Callable execution");
                return "Callable return";
            }
        };
        
        
        ExecutorService pool = Executors.newSingleThreadExecutor();
        Future<?> callableReturn = pool.submit(callable);
        pool.shutdown();
        System.out.println(callableReturn.get());
        
        comparator = new MeuComparador();
        
        actionListener = (event) -> System.out.println("ActionListener: " + event);
        
        blocoSimples = () -> System.out.println("Bloco Simples");
        blocoGenerico = i -> i.toString();
    }
}


class MeuComparador implements Comparator<String> 
{
    @Override
    public int compare(String o1, String o2)
    {
        return o1.compareToIgnoreCase(o2);
    }
    
}