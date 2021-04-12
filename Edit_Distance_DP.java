public class Edit_Distance_DP {
    /*Given 2 strings, find min edit operations required to convert 1st to 2nd
    insert
    replace
    remove
    All operations have same cost
    */
    public static void main(String[] args) {
        String a = "XY", b= "AXYB";
        System.out.println("Edit Distance using Recursion (time = exponential) : " + editDistance_Recursion(a,b, a.length(), b.length()));
        System.out.println("Edit Distance using DP (time=m*n space=m*n) : " + editDistance_DP(a,b));
        System.out.println("Edit Distance using DP(Space Optimised time=m*n space=m) : " + editDistance_DP_spaceOptimised(a,b));
    }

    static int editDistance_Recursion(String a, String b, int m, int n)
    {
        if (m == 0)
            return n;
        if (n == 0)
            return m;
        if (a.charAt(m - 1) == b.charAt(n - 1))
            return editDistance_Recursion(a, b, m-1, n-1);

        return 1
            + Math.min(editDistance_Recursion(a, b, m, n - 1), // Insert
                  Math.min(editDistance_Recursion(a, b, m - 1, n), // Remove
                  editDistance_Recursion(a, b, m - 1,n - 1)) // Replace
              );
    }

    static int editDistance_DP(String a, String b)
    {
        int m = a.length(), n = b.length();
        int dp[][] = new int[m + 1][n + 1];
 
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                
                if (i == 0)
                    dp[i][j] = j; 
                else if (j == 0)
                    dp[i][j] = i;

                else if (a.charAt(i - 1)
                         == b.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
 
                else
                    dp[i][j] = 1
                               + Math.min(dp[i][j - 1], // Insert
                                     Math.min(dp[i - 1][j], // Remove
                                     dp[i - 1][j - 1])); // Replace
            }
        }
        return dp[m][n];
    }

    static int editDistance_DP_spaceOptimised(String a, String b)
    {
        int m = a.length();
        int n = b.length();
     
        // Create a DP array to memoize result
        // of previous computations
        int [][]DP = new int[2][m + 1];
     
     
        // Base condition when second String
        // is empty then we remove all characters
        for (int i = 0; i <= m; i++)
            DP[0][i] = i;
     
        // Start filling the DP
        // This loop run for every
        // character in second String
        for (int i = 1; i <= n; i++) 
        {
           
            // This loop compares the char from
            // second String with first String
            // characters
            for (int j = 0; j <= m; j++)
            {
               
                // if first String is empty then
                // we have to perform add character
                // operation to get second String
                if (j == 0)
                    DP[i % 2][j] = i;
     
                // if character from both String
                // is same then we do not perform any
                // operation . here i % 2 is for bound
                // the row number.
                else if (a.charAt(j - 1) == b.charAt(i - 1)) {
                    DP[i % 2][j] = DP[(i - 1) % 2][j - 1];
                }
     
                // if character from both String is
                // not same then we take the minimum
                // from three specified operation
                else {
                    DP[i % 2][j] = 1 + Math.min(DP[(i - 1) % 2][j],
                                           Math.min(DP[i % 2][j - 1],
                                               DP[(i - 1) % 2][j - 1]));
                }
            }
        }
     
        // after complete fill the DP array
        // if the n is even then we end
        // up in the 0th row else we end up
        // in the 1th row so we take n % 2
        // to get row
        return DP[n % 2][m];
    }
}
