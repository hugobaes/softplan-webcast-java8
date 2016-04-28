package br.com.hugobaes.softplan.webcast.lambda.tutorial;

import java.awt.event.*;
import java.util.*;
import java.util.function.*;

public class AnonymousClassToLambda
{
    public static void main(String... λ)
    {
        /*** Comparator ***/
    	Comparator<Integer> comparator;
    	
    	// Anonymous Class
    	comparator = new Comparator<Integer>() 
    	{
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o1.compareTo(o2);
            }
        };
        
        // Lambda
        comparator = (o1, o2) -> o1.compareTo(o2);
 
       
        

        
        
        
        /*** Runnable ***/
        Runnable runnable;
        
        // Anonymous Class
        runnable = new Runnable() 
    	{
            @Override
            public void run()
            {
                System.out.println("Runnable");
            }
        };
        
        // Lambda
        runnable = () -> System.out.println("Runnable");
        
        
        
        
        
        
        /*** ActionListener ***/
        ActionListener listener;
        
        // Anonymous Class
        listener = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println(e.getActionCommand());
            }
        };
        
        // Lambda
        listener = e -> System.out.println(e.getActionCommand());
   
        
        
    }
}

