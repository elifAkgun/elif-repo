package code.elif.dynamic;

import java.lang.reflect.Proxy;


import code.elif.Image;
import javafx.geometry.Point2D;

public class Client {

	public static void main(String[] args) {
		//Get Image from factory.
		Image img = ImageFactory.getImage("code-elif.bmp");
		//Client is again unaware of existence of proxy
		img.setLocation(new Point2D(10, 10));
		System.out.println("Image Location is: "+img.getLocation());
		System.out.println("Image is rendering...");
		//Actual object should be created at this time
		img.render();
	}
}
