package code.elif.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import code.elif.service.Scanner;

@Qualifier("ScannerB")
@Component
public class ScannerBImpl implements Scanner{

	@Override
	public void scan() {
		System.out.println("This is scanner B...");
	}

}
