// TIME COMPLEXITY = O(n log val)
import java.util.Scanner;
public class nth_root
{
    public static int power(int i, int n)
    {
        int ans = 1;
        for(int j = 0; j < n; j++)
        {
            ans = ans*i;
        }
        return ans;
    }
    public static int search(int val, int n)
    {
        int low,high,mid,ans;
        low = 0;
        high = val;
        ans = 1;
        while(low <= high)
        {
            mid = (low+high)/2;
            int x = power(mid,n);
            if(x == val)
            {
                ans = mid;
                return ans;
            }
            else if(x < val)
            {
                low = mid+1;
            }
            else
            {
                high = mid -1;
            }
        }
        return -1;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int ans,val,n;
        System.out.println("Enter the element whose nth root you want to find");
        val = sc.nextInt();
        System.out.println("Enter the value of number of root");
        n = sc.nextInt();
        ans = search(val,n);
        System.out.println(val+" Root "+n+" = "+ans);
    }
}