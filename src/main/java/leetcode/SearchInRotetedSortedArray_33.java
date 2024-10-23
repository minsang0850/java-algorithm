package leetcode;

public class SearchInRotetedSortedArray_33 {
    public int search(int[] nums, int target) {
        var finded = findRotated(nums, 0, nums.length - 1);
        var front = search(nums, target, 0, finded);
        var back = search(nums, target, finded, nums.length);
        if (front == -1 && back == -1) {
            return -1;
        }
        return front == -1
               ? back
               : front;
    }

    private int search(int[] nums, int target, int i, int finded) {
        if (i >= finded) {
            return -1;
        }
        var mid = (i + finded) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] > target) {
            return search(nums, target, i, mid);
        }
        return search(nums, target, mid + 1, finded);
    }

    private int findRotated(int[] nums, int start, int end) {
        if (start == end) {
            return start;
        }
        var mid = (start + end) / 2;
        if (nums[mid] > nums[mid + 1]) {
            return mid + 1;
        }
        if (nums[mid] < nums[start]) {
            return findRotated(nums, start, mid);
        }
        return findRotated(nums, mid + 1, end);
    }
}
