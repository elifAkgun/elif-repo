package code.elif.iteration;

public class TowerOfHanoi {

// how many moves does it take to move disks from first layer to third layer?

//     -||-          ||           ||
//    --||--         ||           ||
//   ---||---        ||           ||
//   ////////     ////////     ////////


//      ||           ||           ||
//      ||           ||           ||
//   ---||---      --||--        -||-
//   ////////     ////////     ////////


//      ||           ||           ||
//      ||          -||-          ||
//      ||         --||--      ---||---
//   ////////     ////////     ////////


//      ||           ||          -||-
//      ||           ||         --||--
//      ||           ||        ---||---
//   ////////     ////////     ////////

    static int movement = 0;

    public static void main(String[] args) {
        int diskCount = 3;
        solve(diskCount, 'A', 'B', 'C');
        System.out.println(movement);
    }


    private static void solve(int diskCount, char first, char middle, char last) {
        if (diskCount == 0) {
            movement++;
            System.out.println("Plate " + diskCount + " from " + first + " to " + last);
            return;
        }
        movement++;
        System.out.println("Plate " + diskCount + " from " + first + " to " + last);
        solve(diskCount - 1, first, last, middle);
        movement++;
        System.out.println("Plate " + diskCount + " from " + first + " to " + last);
        solve(diskCount - 1, middle, first, middle);
    }

}

