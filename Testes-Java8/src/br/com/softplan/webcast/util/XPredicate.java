package br.com.softplan.webcast.util;

import java.util.function.*;

@FunctionalInterface
public interface XPredicate<A> extends Predicate<A>, XFunction<A, Boolean>
{
    @Override
    default Boolean apply(A t)
    {
        return test(t);
    }
    
	static <A> XPredicate<A> of(Predicate<A> predicate)
	{
		return predicate::test;
	}
}
