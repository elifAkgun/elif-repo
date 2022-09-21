package code.elif;

public class RomanLetters {

    public static void main(String[] args) {
        System.out.print(pivotIndex(58));

    }

    public static String pivotIndex(int num) {
        int[] nums = new int[4];

        nums[0] = (num - (num % 1000)) / 1000;
        nums[1] = (num % 1000 - num % 100) / 100;
        nums[2] = (num % 100 - num % 10) / 10;
        nums[3] = num % 10;


        String s = "";
        if (nums[0] > 0 && nums[0] < 4) {
            for (int i = 0; i < nums[0]; i++) {
                s += "M";
            }
        }
        if (nums[1] > 0) {
            if (nums[1] < 4) {
                for (int i = 0; i < nums[1]; i++) {
                    s += "C";
                }
            } else if (nums[1] == 4) {
                s += "CD";
            } else if (nums[1] == 5) {
                s += "D";
            } else if (nums[1] > 5 && nums[1] < 9) {
                s += "D";
                for (int i = 0; i < nums[1] % 5; i++) {
                    s += "C";
                }
            } else if (nums[1] == 9) {
                s += "CM";
            }

        }
        if (nums[2] > 0) {

            if (nums[2] >= 0 && nums[2] < 4) {
                for (int i = 0; i < nums[2]; i++) {
                    s += "X";
                }
            } else if (nums[2] == 4) {
                s += "XL";
            } else if (nums[2] == 5) {
                s += "L";
            } else if (nums[2] > 5 && nums[2] < 9) {
                s += "L";
                for (int i = 0; i < nums[2] % 5; i++) {
                    s += "X";
                }
            } else if (nums[2] == 9) {
                s += "XC";
            }

        }
        if (nums[3] > 0) {
            if (nums[3] >= 0 && nums[3] < 4) {
                for (int i = 0; i < nums[3]; i++) {
                    s += "I";
                }
            } else if (nums[3] == 4) {
                s += "IV";
            } else if (nums[3] == 5) {
                s += "V";
            }
            if (nums[3] > 5 && nums[3] < 9) {
                s += "V";
                for (int i = 0; i < nums[3] % 5; i++) {
                    s += "I";
                }
            } else if (nums[3] == 9) {
                s += "IX";
            }
        }
        return s;
    }

}
