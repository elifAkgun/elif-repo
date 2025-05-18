package code.elif.datastructure.array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Array {

    private static final Logger logger = LoggerFactory.getLogger(Array.class);

    public static void main(String[] args) {

        int[][][] threeDimArray = {{{100, 101, 102}, {200, 201, 202}}};

        for (int i = 0; i < threeDimArray.length; i++) {
            for (int j = 0; j < threeDimArray[i].length; j++) {
                for (int k = 0; k < threeDimArray[i][j].length; k++) {
                    logger.info(threeDimArray[i][j][k] + " ");
                }
            }
        }
    }
}
