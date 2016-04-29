package br.com.hugobaes.softplan.webcast.lambda.tutorial;

import java.util.function.*;

public class Escopo
{
    static int staticCount = 0;
    
    int instanceCount = 0;
    
    public void main(String... λ)
    {
        int localCount[] = {0};

        Runnable r = () -> System.out.println(localCount[0]++);
    }
}













class X 
{
    static X burger;
    X x;
}

class XBurger extends X
{
    Consumer<XBurger> eat(X burger) { return XBurger -> X.burger = this.x = burger; }
}