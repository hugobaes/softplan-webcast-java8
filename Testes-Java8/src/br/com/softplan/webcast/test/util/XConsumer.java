package br.com.softplan.webcast.test.util;

import java.util.function.Consumer;

//@FunctionalInterface
public interface XConsumer<A> extends Consumer<A>, XFunction<A, Void>
{
    @Override
    default Void apply(A t)
    {
        accept(t);
        return null;
    }

}
