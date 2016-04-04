package br.com.softplan.webcast.test;

import java.util.*;
import java.util.function.*;

public class Generics
{
    /**​/
    public static void main(String[] args)
    {
        List<Object> listA = null;
        List<?> listB = null;
        List<Integer> listC = null;
        List<? extends Integer> listD = null;
        
        listA = listB; // Object = ?
        listB = listA; // ? = Object
        
        listA = listC; // Object = Integer
        listC = listA; // Integer = Object
        
        listA = listD; // Object = ? extends Integer
        listD = listA; // ? extends Integer = Object
        
        listB = listC; // ? = Integer
        listC = listB; // Integer = ?
        
        listB = listD; // ? = ? extends Integer 
        listD = listB; // ? extends Integer = ?
        
        listC = listD;
        listD = listC;
        
        listA.add(new Object());
        listB.add(new Object());
        listC.add(new Object());
        listD.add(new Object());
        
        listA.add(7);
        listB.add(7);
        listC.add(7);
        listD.add(7);
    }
    /**/
}
