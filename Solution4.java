import java.util.Scanner;

public class Solution4 {
    public boolean isProductEqualToTarget(int[] nums, int target) {
        return backtrack(nums, target, 1, 0);
    }

    private boolean backtrack(int[] nums, int target, int currentProduct, int index) {
        // Base case: if the current product equals the target
        if (currentProduct == target) {
            return true;
        }

        // Base case: if we've considered all elements or currentProduct exceeds target
        if (index == nums.length || currentProduct > target) {
            return false;
        }

        // Case 1: Include the current element in the product
        if (backtrack(nums, target, currentProduct * nums[index], index + 1)) {
            return true;
        }

        // Case 2: Exclude the current element from the product and move to the next
        if (backtrack(nums, target, currentProduct, index + 1)) {
            return true;
        }

        return false; // If neither inclusion nor exclusion works, return false
    }

    public static void main(String[] args) {
        Solution4 solution = new Solution4();

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
        int target = scanner.nextInt();

        boolean result = solution.isProductEqualToTarget(nums, target);

        // Output the result
        if (result) {
            System.out.println("There is a subset with a product equal to the target.");
        } else {
            System.out.println("No subset with a product equal to the target exists.");
        }
    }
}
