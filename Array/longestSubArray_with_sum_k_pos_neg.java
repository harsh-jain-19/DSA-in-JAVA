import java.util.*;
public class longestSubArray_with_sum_k_pos_neg
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
        // FINDING LENGTH OF LONGEST SUB ARRAY
        HashMap<Integer,Integer> hashh = new HashMap<>();
        int k,Tsum=0,maxLen=0;
        System.out.println("Enter the Number you are looking as sum of sub array");
        k = sc.nextInt();

        for(int i = 0; i < n; i++)
        {
            Tsum = Tsum + arr[i];
            if(Tsum == k)
            {
                maxLen = i+1;
            }
            int rem = Tsum - k;
            if(hashh.containsKey(rem))
            {
                int len = i - hashh.get(rem);
                if(maxLen < len)
                {
                    maxLen = len;
                } 
            }
            if(hashh.containsKey(Tsum) == false)
            {
                hashh.put(Tsum,i);
            }
        }
        System.out.println("Length of Longest Sub Array With Sum K is "+maxLen);

        // PRINTING
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