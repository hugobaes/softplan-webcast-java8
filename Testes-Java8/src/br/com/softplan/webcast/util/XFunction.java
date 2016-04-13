package br.com.softplan.webcast.util;

import java.util.function.*;

@FunctionalInterface
public interface XFunction<A, R> extends Function<A, R> 
{
	static <A> XFunction<A, Void> of(Consumer<A> consumer) 
	{
		return XConsumer.of(consumer);
	}
	
	static <A> XFunction<A, Boolean> of(Predicate<A> predicate) 
	{
		return XPredicate.of(predicate);
	}
	
	static <R> XFunction<Void, R> of(Supplier<R> supplier) 
	{
		return XSupplier.of(supplier);
	}
	
}
