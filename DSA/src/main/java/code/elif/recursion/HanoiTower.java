package code.elif.recursion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HanoiTower {

    private static final Logger logger = LoggerFactory.getLogger(HanoiTower.class);
    static int movementCount = 0;

    public static void main(String[] args) {
        move(4, 'a', 'b', 'c');
    }

    private static void move(int disk, char source, char middle, char destination) {

        if (disk == 1) {
            movementCount++;
            logger.info("{}. Plate{} from {} to {}", movementCount, disk, source, destination);
            return;
        }
        move(disk - 1, source, destination, middle);
        movementCount++;
        logger.info("{}. Plate{} from {} to {}", movementCount, disk, source, destination);
        move(disk - 1, middle, source, destination);
    }
}
