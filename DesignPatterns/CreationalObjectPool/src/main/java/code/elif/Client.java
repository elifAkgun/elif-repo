package code.elif;

import javafx.geometry.Point2D;

public class Client {


    private static final ObjectPool<Bitmap> bitmapObjectPool = new ObjectPool<>(
            () -> new Bitmap("Test.bmp"), 5
    );


    public static void main(String[] args) {

        System.out.println(bitmapObjectPool.getSize());

        Bitmap bitmap1 = bitmapObjectPool.get();
        bitmap1.setLocation(new Point2D(10,5));

        Bitmap bitmap2 = bitmapObjectPool.get();
        bitmap2.setLocation(new Point2D(2,4));

        bitmap1.draw();
        bitmap2.draw();

        System.out.println(bitmapObjectPool.getSize());

        bitmapObjectPool.release(bitmap1);

        System.out.println(bitmapObjectPool.getSize());

    }
}
