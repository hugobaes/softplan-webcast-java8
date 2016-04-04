package br.com.softplan.webcast.test;

import java.util.concurrent.Callable;
import java.util.function.*;

public class TesteJava8
{
    
    public static void main(String[] args) throws Exception
    {
        int x = 123_456;
        
        invoke(() -> {"1-braces".toString();});
        invoke(() -> "2-expression");
        invoke(a3 -> a3.toLowerCase());
        invoke(() -> System.out.println("Variavel Local: " + x));
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
    
    interface Action<T, U>
    {
        U execute(T t);
        
        static Action<Void, Void> command(Runnable run) 
        {
            return (Void v) -> { run.run(); return null; };
        }
    }
    
    interface Command extends Action<Void, Void>
    {
        void execute();
        
        @Override
        default Void execute(Void t)
        {
            execute();
            return null;
        }
    }
    
    static 
    {
        Teste teste = x -> x.toUpperCase();
        Function<String, String> function = x -> x.toUpperCase();
        UnaryOperator<String> unary = x -> x.toUpperCase();
        Action<String, String> action = x -> x.toUpperCase();
        
        Action<Void, Void> actionVoid = (Void v) -> {System.out.println("actionVoid"); return null;};
        actionVoid.execute(null);
        
        Command commandVoid = () -> System.out.println("commandVoid");
        commandVoid.execute();
        
        actionVoid = commandVoid;
        actionVoid.execute(null);
    }
    
}
