package code.elif.app.features.java16.AccessingInternalApiExample;

import java.io.IOException;
import java.lang.reflect.Field;
import java.security.KeyStore;
import java.security.KeyStoreException;

public class Example {
    public static void main(String[] args) throws KeyStoreException, NoSuchFieldException, IllegalAccessException, IOException {
//        KeyStore ks = KeyStore.getInstance("jceks");
//        Field f = ks.getClass().getDeclaredField("keyStoreSpi");
//        f.setAccessible(true);
//
//        System.out.println(f.get(ks));

        System.out.println("Hello world");

        System.in.read();
    }
}
