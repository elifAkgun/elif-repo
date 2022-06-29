package code.elif;

import javafx.geometry.Point2D;

public class Client {

	public static void main(String[] args) {
		Image image = ImageFactory.getImage("elif.jpg");
		image.setLocation(new Point2D(10,3));
		System.out.println("Image Location is " + image.getLocation());
		System.out.println("Image is rendering...");
		image.render();

	}

}
