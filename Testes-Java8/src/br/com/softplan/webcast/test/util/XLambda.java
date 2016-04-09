package br.com.softplan.webcast.test.util;

import java.util.function.*;

public class XLambda
{
    public static void main(String... $)
    {
        Supplier<String> hugo = () -> "Hugo";
        XSupplier<String> xHugo = () -> "Hugo";
        
        hugo = xHugo;
        //-xHugo = hugo;
        
        Function<Void, String> fuHugo = (x) -> "Hugo";
        XFunction<Void, String> xfuHugo = (x) -> "Hugo";
        
        fuHugo = xfuHugo;
        fuHugo = xHugo;
        //-fuHugo = hugo;
        
        //-xfuHugo = fuHugo;
        //-xfuHugo = xHugo;
        //-xfuHugo = hugo;
        
        //-hugo = fuHugo;
        //-hugo = xfuHugo;
        //-xHugo = fuHugo;
        //-xHugo = xfuHugo;
        
    }
}
