package code.elif;

import java.util.Hashtable;
import java.util.Map;

public class LeetCodeExample {
    public static void main(String[] args) {
        int[] nums = {2,4,11,3};
        int target = 6;

        int[] output = twoSum(nums, target);

        for (int index : output) {
            System.out.println(index);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] output = new int[2];
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();

        //initialize hashtable
        for (int i = 0; i < nums.length; i++) {
            hashtable.put(i, nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            int second = target - nums[i];

            if (hashtable.containsValue(second)) {
                output[0] = i;

                for (Map.Entry entry : hashtable.entrySet()) {
                    if (second == (Integer) entry.getValue() && i != (Integer) entry.getKey()) {
                        output[1] = (Integer) entry.getKey();
                        return output; //breaking because its one to one map
                    }
                }

            }
        }

        return output;

    }
}
