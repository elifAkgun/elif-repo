package code.elif.threads.latency;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main6 {

    public static final String ORIGINAL_IMAGE_DEST = "./resources/many-flowers.jpg";
    public static final String ORIGINAL_IMAGE_OUT = "./out/many-flowers.jpg";

    public static void main(String[] args) throws IOException {

        BufferedImage originalImage = ImageIO.read(new File(ORIGINAL_IMAGE_DEST));
        BufferedImage coloredImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_RGB);
        reColorSingleThread(originalImage, coloredImage);

        File output = new File(ORIGINAL_IMAGE_OUT);
        ImageIO.write(coloredImage,"jpg",output);
    }

    public static void reColorSingleThread(BufferedImage original, BufferedImage colored) {
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

        if (isShadeOfGray(red, green, blue)) {
            newRed = Math.min(255, red + 30);
            newGreen = Math.max(0, green - 80);
            newBlue = Math.max(0, blue - 20);
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
