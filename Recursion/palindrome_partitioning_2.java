// In this problem you will be given an string s.
// You have to return minimum partions required to make it palindrome.
import java.util.*;
public class palindrome_partitioning_2
{
    public static boolean isPalindrome(String s, int start, int end)
    {
        while(start <= end)
        {
            if(s.charAt(start++) != s.charAt(end--))
            {
                return false;
            }
        }
        return true;
    }
    public static int find_partition(int ind, int n, String s)
    {
        if(ind == n)
        {
            return 0;
        }
        int min_cost = Integer.MAX_VALUE;
        for(int j = ind; j < n; j++)
        {
            if(isPalindrome(s,ind,j))
            {
                int cost = 1 + find_partition(j+1, n, s);
                min_cost = Math.min(cost,min_cost);
            }
        }
        return min_cost;
    }
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string whose minimum palidrome partion you want.");
        String s = sc.nextLine();
        int ans = find_partition(0,s.length(),s) - 1;
        System.out.println("Minimum patitions required to make "+s+" a palidrome = "+ans);
    }
}