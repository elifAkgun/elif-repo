package code.elif;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import code.elif.service.Scanner;
import code.elif.service.ScannerAppConfig;

public class ScannerClientApp {


  public static void main(String[] args) {

    ApplicationContext context = new AnnotationConfigApplicationContext(ScannerAppConfig.class);

    Scanner s1 = (Scanner) context.getBean("scannerA");

   
    Runnable r = () -> {
      Scanner s  = (Scanner) context.getBean("scannerA");
      s.scan();
    };
    
    Thread t = new Thread(r);
    
    t.start();

    s1.scan();
    

  }

}
