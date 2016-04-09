package br.com.softplan.webcast.test.util;

import java.util.function.*;

@FunctionalInterface
public interface XPredicate<A> extends Predicate<A>, Function<A, Boolean>
{
    @Override
    default Boolean apply(A t)
    {
        return test(t);
    }
}
