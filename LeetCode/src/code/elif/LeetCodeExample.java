package code.elif;

import java.util.HashMap;
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
        HashMap<Integer, Integer> hashtable = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int second = target - nums[i];

            if (hashtable.containsKey(second)) {
                output[0] = i;
                output[1] = hashtable.get(second);
                return output;
            }

            hashtable.put(nums[i], i);
        }
        return output;

    }
}
