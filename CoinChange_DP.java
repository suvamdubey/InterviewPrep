public class CoinChange_DP {
    public static void main(String[] args) {
        int c[] = { 2, 3, 5, 10 };
        int N[] = { 56, 12, 45, 100 };
        for (int i : N) {
            System.out.println(
                    "Coin Change using Recursion (time = exponential) of " + i + " : " + coinChange_Recursion(i, c, c.length));
            System.out.println("Coin Change using DP (time=n*coins_len space=n) of " + i + " : " + coinChange_DP(i, c));
        }
    }

    static int coinChange_Recursion(int n, int coins[], int pos) {
        if (n == 0)
            return 1;

        if (n < 0)
            return 0;

        if (pos <= 0 && n >= 1)
            return 0;

        return coinChange_Recursion(n, coins, pos - 1) + coinChange_Recursion(n - coins[pos - 1], coins, pos);
    }

    static int coinChange_DP(int n, int coins[]) {
        int DP[] = new int[n + 1];

        DP[0] = 1;

        for (int i = 0; i < coins.length; i++)
            for (int j = coins[i]; j <= n; j++)
                DP[j] += DP[j - coins[i]];

        return DP[n];
    }
}
