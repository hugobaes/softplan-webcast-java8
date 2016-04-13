package br.com.softplan.webcast.util;

import java.util.function.*;

public interface XSupplier<R> extends Supplier<R>, XFunction<Void, R>
{
    @Override
    default R apply(Void t)
    {
        return get();
    }
    
	static <R> XSupplier<R> of(Supplier<R> supplier)
	{
		return supplier::get;
	}
}
