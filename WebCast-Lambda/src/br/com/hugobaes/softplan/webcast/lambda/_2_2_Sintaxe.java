package br.com.hugobaes.softplan.webcast.lambda;

import java.util.*;
import java.util.function.*;

/**
 * Sintaxe.
 * <p>
 * Descreva a sintaxe das expressões lambda, incluindo exemplos de cada variação.
 * Demonstre como é feita a referência a métodos.
 * Explique as regras de escopo das expressões lambda.
 * Apresente as interfaces funcionais (pacote java.util.function).
 * <p>
 * Roteiro:
 * <ol>
 * <li>Overview de Lambda
 * <li>Transformação Classe -> Anonymous Class -> Lambda
 * <li>Comparativo da Classe com Lambda
 * <li>Mostrar escopo de variável local, parametros e atributos de instância
 * <li> - Exemplo de Lambda com 1 argumento e retorno
 * <li> - Exemplo de Lambda com 2 argumentos e retorno 
 * <li> - Exemplo de Lambda se, argumentos e retorno 
 * <li> - Exemplo de Lambda sem argumentos e sem retorno 
 * <li> - Exemplo de Lambda com 1 argumento e 2 instruções
 * <li>Apresentar as principais interfaces funcionais
 * <li>Overview das variações das interfaces funcionais
 * <li>Usar métodos existentes como lambdas 
 * <li>Referência estática a métodos the instância   
 * </ol>
 * 
 * @author Hugo Baés
 */
public class _2_2_Sintaxe
{
    public static void main(String[] args)
    {
        new _2_2_Sintaxe().referenciaDeMetodos();
    }
    
    /**
     * https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html
     */
    public void referenciaDeMetodos() 
    {
        Integer a=1, b=2, c=3;
        Integer[] array = new Integer[]{b,c,a};
        
        Arrays.sort(array, Integer::compare);
        System.out.println(Arrays.toString(array));
        
        Comparator<Integer> comparator = Integer::compare;
        BinaryOperator<Integer> binaryOperator = Integer::compare;
        
        
        Arrays.sort(array, comparator);
        
        Supplier<Object> supplier = Object::new;
        Supplier<_2_2_Sintaxe> s = _2_2_Sintaxe::new;
    }
    
    /**
     * http://www.informit.com/articles/article.aspx?p=2303960&seqNum=7
     * http://stackoverflow.com/questions/25055392/lambdas-local-variables-need-final-instance-variables-dont
     */
    public void regrasDeEscopo() 
    {
        
    }
    
    /**
     * http://www.tutorialspoint.com/java8/java8_functional_interfaces.htm
     */
    public void interfacesFuncionais()
    {
        /* Zero Argumentos */
        
        Supplier<TipoRetorno> supplier;
        Runnable runnable;
        
        supplier = () -> new TipoRetorno();
        runnable = () -> System.out.println("no-args");
        
        
        /* Um Argumento */
        
        Function<TipoParametro, TipoRetorno> function;
        Consumer<TipoParametro> consumer;
        Predicate<TipoParametro> predicate;
        
        UnaryOperator<Tipo> unaryOperator;
        
        function = x -> new TipoRetorno();
        consumer = x -> System.out.println(x);
        predicate = x -> true;
        
        unaryOperator = x -> new Tipo();
        
        
        /* Dois Argumentos */
        
        BiFunction<TipoParametro, TipoParametro, TipoRetorno> biFunction;
        BiConsumer<TipoParametro, TipoParametro> biConsumer;
        BiPredicate<TipoParametro, TipoParametro> biPredicate;
        
        BinaryOperator<Tipo> binaryOperator;
        
        biConsumer = (x, y) -> System.out.println("" + x + y);
        biPredicate = (x, y) -> x.equals(y);
        biFunction = (x, y) -> new TipoRetorno();
        
        binaryOperator = (x, y) -> new Tipo();
        
        /* Primitivas */
        
        // int
        
        IntSupplier intSupplier;
        IntConsumer intConsumer;
        IntPredicate intPredicate;
        IntFunction<TipoRetorno> intFunction;
        IntUnaryOperator intUnaryOperator;
        IntBinaryOperator intBinaryOperator;
        
        ToIntFunction<TipoParametro> toIntFunction;
        ToIntBiFunction<TipoParametro, TipoParametro> toIntBiFunction;
        
        ObjIntConsumer<TipoParametro> objIntConsumer;
        
        
        // long
        
        LongSupplier longSupplier;
        LongConsumer longConsumer;
        LongPredicate longPredicate;
        LongFunction<TipoRetorno> longFunction;
        LongUnaryOperator longUnaryOperator;
        LongBinaryOperator longBinaryOperator;
        
        ToLongFunction<TipoParametro> toLongFunction;
        ToLongBiFunction<TipoParametro, TipoParametro> toLongBiFunction;
        
        ObjLongConsumer<TipoParametro> objLongConsumer;
        

        // double
        
        DoubleSupplier doulbeSupplier;
        DoubleConsumer doulbeConsumer;
        DoublePredicate doulbePredicate;
        DoubleFunction<TipoRetorno> doulbeFunction;
        DoubleUnaryOperator doulbeUnaryOperator;
        DoubleBinaryOperator doulbeBinaryOperator;
        
        ToDoubleFunction<TipoParametro> toDoubleFunction;
        ToDoubleBiFunction<TipoParametro, TipoParametro> toDoubleBiFunction;
        
        ObjDoubleConsumer<TipoParametro> objDoubleConsumer;
        
        
        // convers�es
        
        IntToLongFunction intToLongFunction;
        IntToDoubleFunction intToDoubleFunction;
        LongToIntFunction longToIntFunction;
        LongToDoubleFunction longToDoubleFunction;
        DoubleToIntFunction doubleToIntFunction;
        DoubleToLongFunction doubleToLongFunction;
        
        // boolean
        BooleanSupplier booleanSupplier;
    }
}

@FunctionalInterface
interface Interface {
    void f();
    default void x() {}
    default Object o() {return null;}
}


class Tipo {}
class TipoParametro extends Tipo {}
class TipoRetorno extends Tipo {}
