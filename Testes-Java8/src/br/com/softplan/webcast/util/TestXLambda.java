package br.com.softplan.webcast.util;

import java.awt.event.*;
import java.util.UUID;
import java.util.function.*;

public class TestXLambda
{
    public static void main(String... $)
    {
        boolean JavaScript = false;
        boolean Java7 = true;
        boolean Java8 = true;

        Object n = JavaScript ? Java7 : Java8 ;

    	function();
    	supplier();
    	consumer();
    	predicate();
    }
    
    static void function()
    {
    	XFunction<String, Integer> xfunction = String::length;
    	
    	Function<String, Integer> function = xfunction;
    	
    	String string = "Function";
    	Integer length;
    	length = xfunction.apply(string);
    	length = function.apply(string);
    	
    	length = execute(xfunction, string);
    	length = execute(function,  string);
    }
    
    static void supplier()
    {
    	XSupplier<String> xsupplier = () -> UUID.randomUUID().toString();
        
    	Supplier<String> supplier = xsupplier;
        Function<Void, String> function = xsupplier;
        XFunction<Void, String> xfunction = xsupplier;
        
        String string;
        string = xsupplier.get();
        string = supplier.get();
        string = function.apply(null);
        string = xfunction.apply(null);
        
        string = execute(xsupplier, null);
        string = execute(xfunction, null);
        string = execute(function,  null);
        //-string = execute(supplier, null);
    }
    
    static void consumer()
    {
    	XConsumer<String> xconsumer = System.out::println;
        
    	
    	Consumer<String> consumer = xconsumer;
        Function<String, Void> function = xconsumer;
        XFunction<String, Void> xfunction = xconsumer;
        
        String string = "Consumer";
        xconsumer.accept(string);
        consumer.accept(string);

        Void nullValue;
        nullValue = function.apply(string);
        nullValue = xfunction.apply(string);
        
        nullValue = execute(xconsumer, string);
        nullValue = execute(xfunction, string);
        nullValue = execute(function,  string);
        //-nullValue = execute(consumer, string);
    }
    
    static void predicate()
    {
    	XPredicate<String> xpredicate = "lookup"::contains;
        
    	Predicate<String> predicate = xpredicate;
        Function<String, Boolean> function = xpredicate;
        XFunction<String, Boolean> xfunction = xpredicate;
        
        String string = "Phrase with lookup.";
        Boolean contains;
        contains = xpredicate.test(string);
        contains = predicate.test(string);
        contains = function.apply(string);
        contains = xfunction.apply(string);
        
        contains = execute(xpredicate, string);
        contains = execute(xfunction,  string);
        contains = execute(function,   string);
        //-contains = execute(predicate, string);
    }
    
    static <A, R> R execute(Function<A, R> function, A arg)
    {
    	return function.apply(arg);
    }
    
    static
    {
    	XConsumer<ActionEvent> xevent = (e) -> System.out.println(e);	
    	ActionListener listener = (e) -> System.out.println(e);
    	
    	xevent = listener::actionPerformed;
    	listener = xevent::accept;	
    }
}
