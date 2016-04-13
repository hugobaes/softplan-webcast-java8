package br.com.softplan.webcast.test;

import java.util.concurrent.Callable;
import java.util.function.*;

public class Inferencia
{
    public static void main(String[] args) throws Exception
    {
        differentParamType();
        dynamicTypeLambda();
        polymorphism();
        voidType();
    }
    
    /**
     * Testa a sobrecarga de operadores e a inferência do tipo da Lambda. 
     */
    static void differentParamType() throws Exception
    {
        int x = 123_456;
        
        invoke(() -> {"1-braces".toString();}); //Runnable
        invoke(() -> "2-expression");           //Callable
        invoke(a3 -> a3.toLowerCase());         //StringTransformer
        invoke(() -> System.out.println("-> Local Var: " + x));
    }
    
    
    static void invoke(Runnable r) {
        System.out.println("Invoke: Runnable");
        r.run();
    }

    static <T> T invoke(Callable<T> c) throws Exception {
        System.out.println("Invoke: Callable");
        return c.call();
    }
    
    static String invoke(StringTransformer t) {
        System.out.println("Invoke: StringTransformer");
        return t.transform("done-4");
    }

    interface StringTransformer {
        String transform(String x);
    }
    
    
    /**
     * Testa como a mesma instrução lambda pode assumir tipos diferentes. 
     */
    static void dynamicTypeLambda()
    {
        Function<String, String> function = x -> x.toUpperCase();
        UnaryOperator<String> unary = x -> x.toUpperCase();
        StringTransformer transformer = x -> x.toUpperCase();
        
        String theString = "Desafio Java 8";
        
        System.out.println("Dynamic: function -> " + function.apply(theString));
        System.out.println("Dynamic: unary -> " + unary.apply(theString));
        System.out.println("Dynamic: transformer -> " + transformer.transform(theString));
        
        // Method references
        function = String::toUpperCase;
        unary = String::toUpperCase;
        transformer = String::toUpperCase;
    }
    
    /**
     * 
     */
    static void polymorphism() 
    {
        // Different instructions, same type
        TakeXGiveY<String, Integer> measurer = x -> x.length();
        TakeXGiveY<String, Integer> parseInt = x -> Integer.parseInt(x);
        measurer = parseInt;
        parseInt = measurer;
        
        // Different type
        TakeXGiveY<String, String> upper = x -> x.toUpperCase();
        //-measurer = upper;
        
        
        // SubType
        Str2Int str2Int = x -> Integer.parseInt(x);
        parseInt = str2Int;
        //-str2Int = parseInt;
        
        //---//
        
        measurer = String::length;
        parseInt = Integer::parseInt;
        str2Int = Integer::parseInt;
    }
    
    interface TakeXGiveY<X, Y>
    {
        Y execute(X t);
    }
    
    interface Str2Int extends TakeXGiveY<String, Integer>
    {
    }
    
    
    /**
     * 
     */
    static Void voidType() 
    {
        TakeXGiveY<Void, Void> voidToVoid = (Void nullOnly) -> {System.out.println("Void: voidToVoid"); return null;};
        voidToVoid.execute(null);
        
        Command command = () -> System.out.println("Void: command");
        command.execute();
        
        voidToVoid = command;
        voidToVoid.execute(null);
        
        //---//
        
        Runnable run = () ->  System.out.println("Void: run");
        run.run();
        
        //-command = run;
        
        command = Command.of(run);
        command.execute();
        
        voidToVoid = Command.of(run);
        voidToVoid.execute(null);
        
        return null;
    }
    
    
    interface Command extends TakeXGiveY<Void, Void>
    {
        void execute();
        
        @Override
        default Void execute(Void t)
        {
            execute();
            return null;
        }
        
        static Command of(Runnable run) 
        {
            return () -> run.run();
        }
    }
    
}
