package code.elif.recursion;

public class HanoiTower {

    static int movementCount =0;
    public static void main(String[] args) {
        move(4, 'a', 'b', 'c');
    }

    private static void move(int disk, char source, char middle, char destination) {

        if (disk == 1) {
            movementCount++;
            System.out.println(movementCount + ". Plate" + disk + " from " + source + " to " + destination);
            return;
        }
        move(disk - 1, source, destination, middle);
        movementCount++;
        System.out.println(movementCount + ". Plate" + disk + " from " + source + " to " + destination);
        move(disk - 1, middle, source, destination);
    }
}
