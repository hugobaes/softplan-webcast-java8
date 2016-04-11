package br.com.softplan.webcast.test;

import java.util.function.UnaryOperator;

public class Recursion 
{
	static UnaryOperator<Integer> factorial;
	static { factorial = i -> i == 0 ? 1 : i * factorial.apply( i - 1 ); }
	
    public static void main(String... $) 
    {
    	System.out.println("5! = " + factorial.apply(5));
    	
    	
    	System.out.println("Before:");
    	TailRecursion tail = t -> t.recurse(t);
    	tail.recurse(tail);
    	System.out.println("After: " + tail);
    }
    
    interface TailRecursion
    {
    	TailRecursion recurse(TailRecursion parent);
    }
}
