import java.util.Arrays;
import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array length
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        // Input array elements
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Input value of k
        System.out.print("Enter the number of subsets (k): ");
        int k = scanner.nextInt();

        Solution1 solution = new Solution1();
        boolean result = solution.canPartitionKSubsets(nums, k);

        // Output the result
        if (result) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        scanner.close();
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (total % k != 0) {
            return false;
        }

        Arrays.sort(nums);
        int subsetSum = total / k;
        boolean[] visited = new boolean[nums.length];
        return canPartition(nums, visited, 0, k, 0, subsetSum);
    }

    private boolean canPartition(int[] nums, boolean[] visited, int start, int k, int curSum, int subsetSum) {
        if (k == 0) {
            return true;
        }
        if (curSum == subsetSum) {
            return canPartition(nums, visited, 0, k - 1, 0, subsetSum);
        }
        for (int i = start; i < nums.length; i++) {
            if (visited[i] || curSum + nums[i] > subsetSum) {
                continue;
            }
            visited[i] = true;
            if (canPartition(nums, visited, i + 1, k, curSum + nums[i], subsetSum)) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }
}
