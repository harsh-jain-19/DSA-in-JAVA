import java.util.Scanner;
public class square_root
{
    public static int search(int val)
    {
        int low,high,mid,ans;
        low = 0;
        high = val;
        ans = 1;
        while(low <= high)
        {
            mid = (low+high)/2;
            int x = (mid*mid);
            if(x <= val)
            {
                ans = mid;
                low = mid+1;
            }
            else
            {
                high = mid -1;
            }
        }
        return high;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int ans,val;
        System.out.println("Enter the element whose square root you want to find");
        val = sc.nextInt();
        ans = search(val);
        System.out.println("Square Root = "+ans);
    }
}