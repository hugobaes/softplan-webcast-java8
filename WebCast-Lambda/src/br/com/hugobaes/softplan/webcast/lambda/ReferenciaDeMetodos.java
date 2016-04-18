package br.com.hugobaes.softplan.webcast.lambda;

import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.function.*;

public class ReferenciaDeMetodos
{
    public static void main(String[] args) throws Exception
    {
        /**​/
        
        Runnable gc = () -> System.gc();
        gc = System::gc;
        
        /**​/
        
        System.out.println("\n - Chamadas Via Referencia - \n");
        chamadasViaReferencia();
        
        /**/
        
        System.out.println("\n - Tipagem Dinamica - \n");
        tipagemDinamica();
        
        /**/
        
        System.out.println("\n - Abusando da Inferencia de Tipos - \n");
        abusandoDaInferenciaDeTipos();
        
        /**/
    }

    /**
     * http://www.informit.com/articles/article.aspx?p=2171751&seqNum=3
     */
    static void chamadasViaReferencia()
    {
        // Supplier<Acesso> supplierNew = () -> new Acesso();
        Supplier<Acesso> newSupplier = Acesso::new;
        
        // Function<String, Acesso> functionLogar = username -> Acesso.logar(username);
        Function<String, Acesso> logarFunction = Acesso::logar;
        
        // Consumer<Acesso> consumerDeslogar = fulano -> fulano.deslogar(); 
        Consumer<Acesso> deslogarConsumer = Acesso::deslogar;
        
        // Consumer<Acesso> consumerRevogar = acesso -> Acesso.revogar(acesso);
        Consumer<Acesso> revogarConsumer = Acesso::revogar;
        
        // Acesso anonimo = new Acesso();
        Acesso anonimo = newSupplier.get();
        System.out.println(anonimo);
        
        // Acesso.revogar(anonimo)
        revogarConsumer.accept(anonimo);
        System.out.println(anonimo);
        
        // Acesso fulano = Acesso.logar("fulano");
        Acesso fulano = logarFunction.apply("fulano");
        System.out.println(fulano);
        
        // fulano.deslogar();
        deslogarConsumer.accept(fulano);
        System.out.println(fulano);
        
        // 
        Acesso beltrano = Acesso.logar("beltrano");
        Runnable runnable = beltrano::deslogar;
        runnable.run();
        System.out.println(beltrano);
    }
    
    static void tipagemDinamica()
    {
        /* String # compareToIgnoreCase */
        
        // Uso convencional
        int comparacao = "pivot".compareToIgnoreCase("string");
        System.out.println("pivot <=> string: " + comparacao);
        
        // Referência de instância é chamado a método daquela instância 
        Function<String, Integer> pivotFunction = "pivot"::compareToIgnoreCase;
        comparacao = pivotFunction.apply("azul");
        System.out.println("pivot <=> azul: " + comparacao);
        
        ToIntFunction<String> pivotToIntFunction = "pivot"::compareToIgnoreCase;
        comparacao = pivotToIntFunction.applyAsInt("pivot");
        System.out.println("pivot <=> pivot: " + comparacao);
        
        
        // Referência estática a método de instância, o primeiro argumento é sempre this
        BiFunction<String, String, Integer> compareBiFunction = String::compareToIgnoreCase;
        ToIntBiFunction<String, String> compareToIntBiFunction = String::compareToIgnoreCase;
        Comparator<String> compareComparator = String::compareToIgnoreCase;
        
        comparacao = compareBiFunction.apply("pivot", "tovip");
        System.out.println("pivot <=> tovip: " + comparacao);
        
        comparacao = compareToIntBiFunction.applyAsInt("pivot", "naotomais");
        System.out.println("pivot <=> naotomais: " + comparacao);
        
        comparacao = compareComparator.compare("pivot", "topobre");
        System.out.println("pivot <=> topobre: " + comparacao);
        
        
        // Ignora o retorno
        Consumer<String> pivotConsumer = "pivot"::compareToIgnoreCase;
        pivotConsumer.accept("-");
        
        
        
        /* String # toUpperCase */
        
        // Referência estática a método de instância, o primeiro argumento é sempre this
        Function<String, String> upperFunction = String::toUpperCase;
        UnaryOperator<String> upperUnaryOperator = String::toUpperCase;
        
        upperFunction.apply("teste");
        upperUnaryOperator.apply("teste");
        
        // Referência de instância é chamado a método daquela instância 
        Supplier<String> upperSupplier = "string"::toUpperCase;
        Runnable upperRunnable = "string"::toUpperCase;
        Callable<String> upperCallable = "string"::toUpperCase;
        Consumer<String> upperConsumer = String::toUpperCase;
        
        
        /* */
        
        UnaryOperator<String> unaryConcat = "prefixo_"::concat;
        BinaryOperator<String> binaryConcat = String::concat;
        
        IntBinaryOperator intBinaryOperator = Integer::compare;
        
        BiFunction<Integer, Integer, Integer> integerBiFunction = Integer::compareTo;
        BinaryOperator<Integer> integerBinaryOperator = Integer::compareTo;
        
        Integer mil = 100;
        Function<Integer, Integer> integerFunction = mil::compareTo;
        UnaryOperator<Integer> integerUnaryOperator = mil::compareTo;
    }
    
    
    
    static void abusandoDaInferenciaDeTipos() throws Exception
    {
        Object object = ((Supplier<Object>)Object::new).get();
        System.out.println("Supplier -> new: " + object);
        
        int compare = ((Comparator<String>)String::compareToIgnoreCase).compare("aaa", "AAA");
        System.out.println("Comparator -> compareToIgnoreCase: " + compare);
        
        String hex = ((Function<Integer, String>)Integer::toHexString).apply(0xBEBE_CAFE); //-1094792450
        System.out.println("Function -> toHexString: " + hex);
        
        String upper = ((UnaryOperator<String>)String::toUpperCase).apply("teste");
        System.out.println("UnaryOperator -> toUpperCase: " + upper);
        
        ((Consumer<String>)System.out::println).accept("Consumer -> println");
        
        ((Runnable)Object::new).run();
        Object b = ((Callable<Object>)Object::new).call();
        
        ((Runnable)ReferenciaDeMetodos::teste).run();
        
    }

    static void teste() 
    {
        System.out.println("Static Teste");
    }
}


class Acesso
{
    final String usuario;
    boolean logado;
    
    Acesso() 
    {
        this("ANONIMO");
    }
    
    private Acesso(String usuario)
    {
        this.usuario = usuario;
        logado = true;
    }
    
    void deslogar()
    {
        this.logado = false;
    }
    
    static Acesso logar(String usuario)
    {
        // ... verifica usuario ...
        
        return new Acesso(usuario.toUpperCase());
    }
    
    static void revogar(Acesso acesso)
    {
        acesso.logado = false;
    }
    
    @Override
    public String toString()
    {
        return String.format("Usuario [%s] : %s", usuario, logado);
    }
}