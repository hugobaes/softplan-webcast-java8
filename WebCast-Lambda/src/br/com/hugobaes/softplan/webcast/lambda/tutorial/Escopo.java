package br.com.hugobaes.softplan.webcast.lambda.tutorial;

import java.util.function.*;

import br.com.hugobaes.softplan.webcast.lambda.tutorial.XBurger.That;

public class Escopo
{
    private static int staticCount;
    
    private int instanceCount;
    
    public static void instanceMethod()
    {
        int[] localCount = {0};

        Runnable staticIncrement = () -> staticCount++;
//        Runnable instanceIncrement = () -> instanceCount++;
        Runnable localIncrement = () -> localCount[0]++;
        
        Runnable localRead = () -> System.out.println(localCount[0]);
        Runnable shadow = () -> {
//          int localCount = 1;
        };
    }
}



class XBurger 
{
    static class That { static int x; }
    int x;
    
    Consumer<Integer> eat(int burger) { return (x) -> That.x = this.x = x-burger;  }
}