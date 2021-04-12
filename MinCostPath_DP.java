public class MinCostPath_DP {
    /*
     * Given a cost matrix cost[][] and a position (m, n) in cost[][], write a
     * function that returns cost of minimum cost path to reach (m, n) from (0, 0).
     * Each cell of the matrix represents a cost to traverse through that cell. The
     * total cost of a path to reach (m, n) is the sum of all the costs on that path
     * (including both source and destination). You can only traverse down, right
     * and diagonally lower-right cells from a given cell, i.e., from a given cell
     * (i, j), cells (i+1, j), (i, j+1), and (i+1, j+1) can be traversed. You may
     * assume that all costs are positive integers.
     */

    public static void main(String[] args) {
        int cost[][] = {{1,2,3}, {4,8,2},{1,5,3}};
        System.out.println("Min Cost Path using Recursion (time = exponential) : " + minCostPath_Recursion(cost, cost.length-1, cost[0].length-1));
        System.out.println("Min Cost Path using DP (time=m*n space=m*n) : " + minCostPath_DP(cost));
        System.out.println("Min Cost Path using DP(Space Optimised time=m*n space=m) : " + minCostPath_DP_spaceOptimised(cost));
    }

    static int minCostPath_Recursion(int[][] cost, int m, int n) {
        if (n < 0 || m < 0)
            return Integer.MAX_VALUE;
        else if (m == 0 && n == 0)
            return cost[m][n];
        else
            return cost[m][n] + Math.min(minCostPath_Recursion(cost, m - 1, n - 1),
                    Math.min(minCostPath_Recursion(cost, m - 1, n), minCostPath_Recursion(cost, m, n - 1)));
    }

    static int minCostPath_DP(int[][] cost) {
        int m = cost.length-1, n = cost[0].length-1;
        int i, j;
        int tc[][] = new int[m + 1][n + 1];

        tc[0][0] = cost[0][0];

        for (i = 1; i <= m; i++)
            tc[i][0] = tc[i - 1][0] + cost[i][0];

        for (j = 1; j <= n; j++)
            tc[0][j] = tc[0][j - 1] + cost[0][j];

        for (i = 1; i <= m; i++)
            for (j = 1; j <= n; j++)
                tc[i][j] = Math.min(tc[i - 1][j - 1], Math.min(tc[i - 1][j], tc[i][j - 1])) + cost[i][j];

        return tc[m][n];
    }

    static int minCostPath_DP_spaceOptimised(int[][] cost) {
        int m = cost.length, n = cost[0].length;
        for (int i = 1; i < m; i++) {
            cost[i][0] += cost[i - 1][0];
        }

        for (int j = 1; j < n; j++) {
            cost[0][j] += cost[0][j - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cost[i][j] += Math.min(cost[i - 1][j - 1], Math.min(cost[i - 1][j], cost[i][j - 1]));
            }
        }

        return cost[m - 1][n - 1];
    }
}
