package leetcode;

public class FindFirstAndLastPositionOfElementInSortedArray_34 {
    public int[] searchRange(int[] nums, int target) {
        var answer = new int[2];
        answer[0]=binarySearchLeftmost(nums, target);
        answer[1]=binarySearchRightmost(nums, target);
        return answer;
    }

    public static int binarySearchLeftmost(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1; // target이 없는 경우를 위한 초기값

        // Step 1: target의 첫 인덱스를 찾는 이진 탐색
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
                if (arr[mid] == target) {
                    result = mid; // 중복 값이 있는 경우 가장 왼쪽 인덱스를 저장
                }
            }
        }

        // Step 2: target이 배열에 없는 경우 target보다 작은 값 중 가장 큰 값의 인덱스를 반환
        if (result == -1) {
            return -1; // target이 없을 때 right은 target보다 작은 가장 큰 인덱스를 가리킴
        }

        return result;
    }

    public static int binarySearchRightmost(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1; // target이 없는 경우를 위한 초기값

        // Step 1: target의 첫 인덱스를 찾는 이진 탐색
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
                if (arr[mid] == target) {
                    result = mid; // 중복 값이 있는 경우 가장 오른쪽 인덱스를 저장
                }
            }

        }

        // Step 2: target이 배열에 없는 경우 target보다 작은 값 중 가장 큰 값의 인덱스를 반환
        if (result == -1) {
            return -1; // target이 없을 때 right은 target보다 작은 가장 큰 인덱스를 가리킴
        }

        return result;
    }
}
