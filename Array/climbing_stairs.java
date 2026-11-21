// In this problem you will be given an integer n.
// n is representing number of steps to reach at the top.
// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
import java.util.*;
public class climbing_stairs
{
    public static int total_ways(int n)
    {
        if (n == 0 || n == 1) {
            return 1;
        }

        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of steps required to reach top.");
        int n = sc.nextInt();
        int x = total_ways(n);
        System.out.println("Total number of ways to reach top = "+x);
    }
}