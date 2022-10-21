package code.elif.threads.latency;


import sun.net.www.content.image.png;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main6 {

    public static final String ORIGINAL_IMAGE_DEST = "./resources/null-object.png";
    public static final String ORIGINAL_IMAGE_OUT = "./out/s.jpg";

    public static void main(String[] args) throws IOException, InterruptedException {

        BufferedImage originalImage = ImageIO.read(new File(ORIGINAL_IMAGE_DEST));
        BufferedImage coloredImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_RGB);


        long startTimeMillis = System.currentTimeMillis();

        System.out.println("started....");

        reColorMultiThread(originalImage, coloredImage, 32);
        // reColorSingleThread(originalImage, coloredImage, 0, 0);
        System.out.println("image process...." + (System.currentTimeMillis() - startTimeMillis));

        File output = new File(ORIGINAL_IMAGE_OUT);
        ImageIO.write(coloredImage, "jpg", output);

        System.out.println("finished...." + (System.currentTimeMillis() - startTimeMillis));

    }

    private static void reColorMultiThread(BufferedImage originalImage, BufferedImage coloredImage, int numberOfThread) throws InterruptedException {
        List<Thread> imageThreads = new ArrayList<>();
        int width = originalImage.getWidth();
        int height = originalImage.getHeight() / numberOfThread;

        for (int i = 0; i < numberOfThread; i++) {

            final int threadMultiplier = i;
            int leftCorner = 0;
            int topCorner = threadMultiplier * height;
            Thread thread = new Thread(() -> {
                reColorImage(originalImage, coloredImage, leftCorner, topCorner,
                        width, height);
            });
            imageThreads.add(thread);

        }


        for (Thread imageThread : imageThreads) {
            imageThread.start();
        }
        for (Thread imageThread : imageThreads) {
            imageThread.join();
        }
    }

    public static void reColorSingleThread(BufferedImage original, BufferedImage colored,
                                           int leftCorner, int topCorner) {
        reColorImage(original, colored, 0, 0, original.getWidth(), original.getHeight());
    }

    public static void reColorImage(BufferedImage original, BufferedImage colored,
                                    int leftCorner, int topCorner,
                                    int width, int height) {


        for (int x = leftCorner; x < leftCorner + width && x < original.getWidth();
             x++) {
            for (int y = topCorner; y < topCorner + height && y < original.getHeight(); y++) {
                int rgb = reColorPixel(original.getRGB(x, y));
                setRGB(colored, x, y, rgb);
            }

        }
    }

    public static void setRGB(BufferedImage image, int x, int y, int rgb) {
        image.getRaster().setDataElements(x, y, image.getColorModel().getDataElements(rgb, null));
    }

    public static int reColorPixel(int rgb) {
        int red = getRed(rgb);
        int blue = getBlue(rgb);
        int green = getGreen(rgb);

        int newRed = 0;
        int newGreen = 0;
        int newBlue = 0;

        if (isShadeOfBlack(red, green, blue)) {
            newRed = 253;
            newGreen = 253;
            newBlue = 253;
        } else {
            newRed = red;
            newGreen = green;
            newBlue = blue;
        }

        return calculateRgbValue(newRed, newGreen, newBlue);
    }

    public static int calculateRgbValue(int red, int green, int blue) {
        int rgb = 0;
        rgb |= blue;
        rgb |= (green << 8);
        rgb |= (red << 16);
        rgb |= 0xFF000000;
        return rgb;
    }

    //returns: if pixel is related with Gray true
    public static boolean isShadeOfGray(int red, int green, int blue) {
        return Math.abs(red - green) < 30 &&
                Math.abs(green - blue) < 30 &&
                Math.abs(blue - green) < 30;
    }

    //returns: if pixel is related with Gray true
    public static boolean isShadeOfBlack(int red, int green, int blue) {
        return (red < 90 && red > 45 )&&
                (green < 90 && green > 45 )&&
                (blue < 90 && blue > 45 );
    }

    //this method returns blue value of rgb
    public static int getBlue(int rgb) {
        return (rgb & 0x000000FF);
    }

    //this method returns green value of rgb
    public static int getGreen(int rgb) {
        return (rgb & 0x0000FF00) >> 8;
    }

    //this method returns red value of rgb
    public static int getRed(int rgb) {
        return (rgb & 0x00FF0000) >> 16;
    }
}