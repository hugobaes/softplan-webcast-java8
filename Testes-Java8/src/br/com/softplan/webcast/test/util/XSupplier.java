package br.com.softplan.webcast.test.util;

import java.util.function.*;

public interface XSupplier<R> extends Supplier<R>, Function<Void, R>
{
    @Override
    default R apply(Void t)
    {
        return get();
    }
}
