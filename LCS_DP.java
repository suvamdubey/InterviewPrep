public class LCS_DP {
    public static void main(String[] args) {
        String a = "AXYSEROCMERMPEV", b = "AXCBHYBSECPE RIJ EIJV";
        System.out.println("Length of LCS using m*n time m*n space "+ lcs_len_2dspace(a,b));
        System.out.println("Length of LCS using m*n time n space "+lcs_len_1dspace(a,b));
        System.out.println("LCS using m*n time m*n space "+ lcs(a,b));
    }
    static int lcs_len_2dspace(String a, String b)
    {
        int m = a.length(), n = b.length();
        int L[][] = new int[m+1][n+1];
        for(int i=0;i<=m;i++)
        {
            for(int j=0;j<=n;j++)
            {
                if (i==0||j==0)
                {
                    L[i][j] = 0;
                }
                else if (a.charAt(i-1)==b.charAt(j-1))
                {
                    L[i][j] = L[i-1][j-1] + 1;
                }
                else
                L[i][j] = Math.max(L[i-1][j], L[i][j-1]); 
      
            }
        }
        return L[m][n];
    }

    static int lcs_len_1dspace(String a, String b)
    {

   int m = a.length(), n = b.length(); 
      
        int L[][] = new int[2][n+1]; 
        int bi=0; 
      
        for (int i = 0; i <= m; i++) 
        { 

            bi = i & 1; 
      
            for (int j = 0; j <= n; j++) 
            { 
                if (i == 0 || j == 0) 
                    L[bi][j] = 0; 
      
                else if (a.charAt(i - 1) ==  
                         b.charAt(j - 1)) 
                    L[bi][j] = L[1 - bi][j - 1] + 1; 
      
                else
                    L[bi][j] = Math.max(L[1 - bi][j],  
                                        L[bi][j - 1]); 
            } 
        } 
        return L[bi][n]; 
    } 
    static String lcs(String a, String b)
    {
        int m= a.length(), n = b.length();
        int[][] L = new int[m+1][n+1]; 
        for (int i=0; i<=m; i++) 
        { 
            for (int j=0; j<=n; j++) 
            { 
                if (i == 0 || j == 0) 
                    L[i][j] = 0; 
                else if (a.charAt(i-1) == b.charAt(j-1)) 
                    L[i][j] = L[i-1][j-1] + 1; 
                else
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]); 
            } 
        } 
   
           
        String s = "";

        int i = m; 
        int j = n; 
        while (i > 0 && j > 0) 
        { 
            // If current character in X[] and Y are same, then 
            // current character is part of LCS 
            if (a.charAt(i-1) == b.charAt(j-1)) 
            { 
                // Put current character in result 
                s = a.charAt(i-1) + s;  
                  
                // reduce values of i, j and index 
                i--;  
                j--;      
            } 
   
            
            else if (L[i-1][j] > L[i][j-1]) 
                i--; 
            else
                j--; 
        } 
        return s;
   
    }
}
