import java.util.*;
public class largestSubArray_with_zero_sum
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the size of an Array");
        n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the "+i+" element");
            arr[i] = sc.nextInt();
        }
        // FINDIND LENGTH OF LARGEST SUB ARRAY WITH SUM 0

        int sum = 0, maxi = 0;
        HashMap<Integer,Integer> mpp = new HashMap<>();
        for(int i = 0; i < n; i++)
        {
            sum = sum + arr[i];
            if(sum == 0)
            {
                maxi = i + 1;
            }
            else
            {
                if(mpp.get(sum) != null)
                {
                    maxi = Math.max(maxi, i - mpp.get(sum));
                }
                else
                {
                    mpp.put(sum,i);
                }
            }
        }
        System.out.println("Length Of Largest Sub Array With Sum 0 is :"+maxi);
        for(int i = 0; i < n; i++)
        {
            if(i!=0)
            {
                System.out.print(","+arr[i]);
            }
            else
            {
                System.out.print(arr[i]);
            }
        }
    }
}