package Twoo;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String,String> loggedMap = (Map<String,String>) Proxy.newProxyInstance(
            ClassLoader.getSystemClassLoader(),
            new Class[]{Map.class},
            new LogHandler(new HashMap<>()));

        loggedMap.put("1","one");
        loggedMap.put("2","two");
        loggedMap.get("1");
loggedMap.isEmpty();
loggedMap.replace("1","one","oneeeeeee");



    }
}