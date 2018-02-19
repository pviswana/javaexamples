package com.algorithms.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1]
 *
 */
public class TwoSum {
    public static void main(String args[]) {
        int[] nums = new int[] {2, 8, 5, 3, 7};
        int target = 9;
        TwoSum twoSum = new TwoSum();
        int[] returnValues = twoSum.twoSum(nums, target);
        if (returnValues != null) {
            System.out.println("Two indices are :" + returnValues[0] + "," + returnValues[1]);
        }
    }

    /**
     *
     * @param nums
     * @param target
     * @return the two numbers that add up to the target value
     */
    public int[] twoSum(int[] nums, int target) {
        int[] returnValues = null;
        Map<Integer, Integer> mapValues = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int compliment = target - nums[i];

            if (mapValues.containsKey(compliment)) {
                returnValues = new int[] {mapValues.get(compliment), i};
                break;
            } else {
                mapValues.put(nums[i], i);
            }
        }
        return returnValues;
    }
}

