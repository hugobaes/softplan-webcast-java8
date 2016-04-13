package br.com.hugobaes.softplan.webcast.lambda.tutorial;

import java.util.*;
import java.util.function.*;

public class Tutorial_Java_8_Lambdas
{

	public static void main(String... $) 
	{
	
		Comparator<Integer> comparatorJava7 = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		};
		
		Integer x;
		Comparator<Integer> comparatorJava8 = Integer::compare;
		
		ToIntFunction<String> predicate = "pivot"::compareToIgnoreCase;
		
		comparatorJava8 = Integer::compare;
		Integer.compare(o1, o2);
		
		Arrays.asList(5,4,3,2,1).sort((o1, o2) -> o1.compareTo(o2));
		
		
		Iterator<String> it = 
		new Iterator<String>() {

			@Override
			public boolean hasNext() {
				return false;
			}

			@Override
			public String next() {
				return null;
			}
			
		};
		
		Function<String, Integer> function;
		Consumer<Double> consumer;
		Supplier<Integer> supplier;
		Predicate<String> predicate;
		
		supplier.get();
		
		function.apply(t);
		consumer.accept(t);
		predicate.test(t);
		
		BiFunction<T, U, R> biFunction;
		BiConsumer<T, U>;
		BiPredicate<T, U>;
		
		UnaryOperator<String> unary;
		BinaryOperator<String> binary;
		binary.apply(u, u);
		
		IntFunction<Double> intFunction;
		ToIntFunction<String> toIntFunction;
		
		DoubleToIntFunction<R>;
		DoubleToLongFunction<R>;
		
		
		
		
	}
	
}

