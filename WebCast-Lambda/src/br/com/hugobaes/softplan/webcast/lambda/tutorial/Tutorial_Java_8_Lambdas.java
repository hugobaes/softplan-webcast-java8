package br.com.hugobaes.softplan.webcast.lambda.tutorial;

import java.awt.event.*;
import java.util.*;
import java.util.function.*;

public class Tutorial_Java_8_Lambdas
{
	Comparator<Integer> integerComparator = 
	   (a1, a2) -> a1.compareTo(a2) 
	;
	   
	Runnable runnable = 
       () -> System.out.println("Runnble");
    ;
    
    ActionListener listener =         
        e -> System.out.println("Evento: " + e.getActionCommand())
    ;
        
     
}

