package leetcode;

import java.util.Arrays;

public class Merge_Sorted_Array {

    public static void main(String[] args) {
        var p = new Merge_Sorted_Array();
        p.merge(new int[]{1,2,3,0,0,0}, 3,
                new int[]{2,5,6}, 3);
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i=m; i<m+n; i++){
            nums1[i]=nums2[i-m];
        }
        Arrays.sort(nums1);
    }
}
