package br.com.softplan.webcast.test;

import java.util.*;
import java.util.concurrent.Callable;

public class TesteJava7
{
    
    public static void main(String... λ) throws Exception
    {
        final int x = 123_456;
        List<Integer> inteiros = Arrays.asList(5, 1, 3, 2, 4, 1);
        System.out.println(inteiros);
        
        invoke(new Runnable() {
            public void run() {
                "1-braces".toString();
            };
        });
        invoke(new Callable<String>() {
            public String call() throws Exception {
                return "2-expression"; 
            }
        });
        invoke(new Teste() {
            public String doStr(String a3) {
                return a3.toLowerCase();
            }
        });
        invoke(new Runnable() {
            public void run() {
                System.out.println("Variavel Local: " + x);
            }
        });
        
    }
    
    
    static void invoke(Runnable r) {
        System.out.println("Invoke: Runnable");
        r.run();
    }

    static <T> T invoke(Callable<T> c) throws Exception {
        System.out.println("Invoke: Callable");
        return c.call();
    }
    
    static String invoke(Teste t) {
        System.out.println("Invoke: Teste");
        return t.doStr("done-4");
    }

    interface Teste {
        String doStr(String x);
    }
    
    
}
