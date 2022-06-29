package code.elif;

//Factory to get image objects. 
public class ImageFactory {
	//We'll provide proxy to caller instead of real object
    public static Image getImage(String fileName){
        return new ImageProxy(fileName);
    }
	
}
