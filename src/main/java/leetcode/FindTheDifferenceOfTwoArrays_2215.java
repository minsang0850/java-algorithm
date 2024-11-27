package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindTheDifferenceOfTwoArrays_2215 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        var set1 = new HashSet<Integer>();
        for (int num : nums1) {
            set1.add(num);
        }

        var set2 = new HashSet<Integer>();
        for (int num : nums2) {
            set2.add(num);
        }
        var answer = new ArrayList<List<Integer>>();
        var diff1 = new ArrayList<Integer>();
        for (int num : set1) {
            if (!set2.contains(num)) {
                diff1.add(num);
            }
        }
        answer.add(diff1);
        var diff2 = new ArrayList<Integer>();
        for (int num : set2) {
            if (!set1.contains(num)) {
                diff2.add(num);
            }
        }
        answer.add(diff2);
        return answer;
    }
}
