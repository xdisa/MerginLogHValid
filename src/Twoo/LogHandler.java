package Twoo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler {

    private final Object delegate;

    public LogHandler(Object delegate){
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("method started:" + method.getName());
        Object result = method.invoke(delegate, args);
        long end = System.currentTimeMillis();
        try {
            System.out.println("method is finished. Result : " + method.getName() + result.toString());
            System.out.println("time:" + (end-start));
            return  result;}
        catch( NullPointerException e){
            System.out.println("method is finished. : " + method.getName());
            System.out.println("result is null");}
            System.out.println("time:" + (end-start));

        return result;
    }
}
