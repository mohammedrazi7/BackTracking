import java.util.Scanner;

public class Solution5 {

    private int count;

    public int totalNQueens(int n) {
        count = 0;
        boolean[] cols = new boolean[n];           // Track columns where queens are placed
        boolean[] diag1 = new boolean[2 * n - 1];  // Track major diagonals
        boolean[] diag2 = new boolean[2 * n - 1];  // Track minor diagonals
        backtrack(0, n, cols, diag1, diag2);
        return count;
    }

    private void backtrack(int row, int n, boolean[] cols, boolean[] diag1, boolean[] diag2) {
        if (row == n) { // All queens are placed successfully
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row - col + n - 1;  // Index for major diagonal
            int d2 = row + col;          // Index for minor diagonal

            // If no queens are attacking in this column and diagonals
            if (!cols[col] && !diag1[d1] && !diag2[d2]) {
                // Place the queen
                cols[col] = true;
                diag1[d1] = true;
                diag2[d2] = true;

                // Move to the next row
                backtrack(row + 1, n, cols, diag1, diag2);

                // Backtrack: remove the queen and reset the markers
                cols[col] = false;
                diag1[d1] = false;
                diag2[d2] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution5 solution = new Solution5();
        int n = sc.nextInt();
        int result = solution.totalNQueens(n);
        System.out.println("Number of distinct solutions for " + n + "-Queens: " + result);
    }
}
