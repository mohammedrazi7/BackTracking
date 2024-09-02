import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution3 {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> t = new ArrayList<>();
    private int[] nums;
    private boolean[] vis;

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

        Solution3 solution = new Solution3();
        List<List<Integer>> result = solution.permuteUnique(nums);

        // Output the result
        System.out.println("The unique permutations are:");
        for (List<Integer> permutation : result) {
            System.out.println(permutation);
        }

        scanner.close();
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums); // Sort the array to handle duplicates
        this.nums = nums;
        vis = new boolean[nums.length]; // Initialize the visited array
        dfs(0); // Start the depth-first search
        return ans;
    }

    private void dfs(int i) {
        if (i == nums.length) { // Base case: when a permutation is complete
            ans.add(new ArrayList<>(t)); // Add the current permutation to the answer list
            return;
        }
        for (int j = 0; j < nums.length; ++j) {
            // Skip the element if it's already used or it's a duplicate that hasn't been used in this position
            if (vis[j] || (j > 0 && nums[j] == nums[j - 1] && !vis[j - 1])) {
                continue;
            }
            t.add(nums[j]); // Choose the element
            vis[j] = true; // Mark the element as visited
            dfs(i + 1); // Recur for the next position
            vis[j] = false; // Unmark the element
            t.remove(t.size() - 1); // Remove the element from the current permutation
        }
    }
}
