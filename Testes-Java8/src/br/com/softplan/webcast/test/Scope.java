package br.com.softplan.webcast.test;

public class Scope
{
    static int staticInt;
    static Runnable staticλ = () -> System.out.println("Static scope: \t\t\t\t" + staticInt++);
    
    int instanceInt;
    Runnable instanceλ = () -> System.out.println("Instance scope: \t\t\t" + staticInt++ + instanceInt++);
    
    void instanceMethod() 
    {
        int localInt = 0;
        Runnable localλ = () -> System.out.println("Local scope: \t\t\t\t" + staticInt++ + instanceInt++ +  localInt);
        localλ.run();
    }
    
    static void staticMethod() 
    {
        int staticLocalInt = 0;
        Runnable staticLocalλ = () -> System.out.println("Static local scope: \t\t\t" + staticInt++ + staticLocalInt);
        staticLocalλ.run();
    }
    
    class InnerScope
    {
        int innerInt;
        Runnable innerλ = () -> System.out.println("Inner instance scope: \t\t\t" + staticInt++ + instanceInt++ + innerInt++);
        
        void innerMethod()
        {
            int innerLocalInt = 0;
            Runnable innerLocalλ = () -> System.out.println("Inner local scope: \t\t\t" + staticInt++ + instanceInt++ + innerInt++ + innerLocalInt);
            innerLocalλ.run();
        }
    }
    
    static class StaticInnerScope
    {
        static int staticInnerStaticInt;
        static Runnable staticInnerStaticλ = () -> System.out.println("Static inner static scope: \t\t" + staticInt++ + staticInnerStaticInt++);
        
        int staticInnerInstanceInt;
        Runnable staticInnerInstanceλ = () -> System.out.println("Static inner instance scope: \t\t" + staticInt++ + staticInnerStaticInt++ + staticInnerInstanceInt++);
        
        void staticInnerInstanceMethod()
        {
            int staticInnerInstanceLocalInt = 0;
            Runnable staticInnerInstanceLocalλ = () -> System.out.println("Static inner instance local scope: \t" + staticInt++ + staticInnerStaticInt++ + staticInnerInstanceInt++ + staticInnerInstanceLocalInt);
            staticInnerInstanceLocalλ.run();
        }
        
        static void staticInnerStaticMethod()
        {
            int staticInnerStaticLocalInt = 0;
            Runnable staticInnerStaticLocalλ = () -> System.out.println("Static inner static local scope: \t" + staticInt++ + staticInnerStaticInt++ + staticInnerStaticLocalInt);
            staticInnerStaticLocalλ.run();
        }
    }
    
    public static void main(String... λ)
    {

        
        // Scope Order
        /**-/
        Scope.staticλ.run();
        Scope.staticMethod();
        Scope.StaticInnerScope.staticInnerStaticλ.run();
        Scope.StaticInnerScope.staticInnerStaticMethod();
        
        Scope instance = new Scope();
        instance.instanceλ.run();
        instance.instanceMethod();
        
        InnerScope innerInstance = instance.new InnerScope();
        innerInstance.innerλ.run();
        innerInstance.innerMethod();
        
        Scope.StaticInnerScope staticInnerInstance = new Scope.StaticInnerScope();
        staticInnerInstance.staticInnerInstanceλ.run();
        staticInnerInstance.staticInnerInstanceMethod();
        /**/
        
        // Declaration order
        /**/
        Scope instance = new Scope();
        InnerScope innerInstance = instance.new InnerScope();
        Scope.StaticInnerScope staticInnerInstance = new Scope.StaticInnerScope();
        
        Scope.staticλ.run();
        instance.instanceλ.run();
        instance.instanceMethod();
        Scope.staticMethod();
        
        innerInstance.innerλ.run();
        innerInstance.innerMethod();
        
        Scope.StaticInnerScope.staticInnerStaticλ.run();
        staticInnerInstance.staticInnerInstanceλ.run();
        staticInnerInstance.staticInnerInstanceMethod();
        Scope.StaticInnerScope.staticInnerStaticMethod();
        /**/
        
    }

}
