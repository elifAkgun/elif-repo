package code.elif.service.impl;

import org.springframework.stereotype.Component;

import code.elif.service.Scanner;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class ScannerAImpl implements Scanner {

  private int value;

  @Override
  public void scan() {

    for (int i = 0; i < 100; i++) {
     
      System.out.println("This is scanner A... running on " 
          + Thread.currentThread().getName() 
          + " value :" +value);
      
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      this.value = this.value +1;
    }

  }
}
