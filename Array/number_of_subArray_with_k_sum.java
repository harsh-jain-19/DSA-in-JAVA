import java.util.*;
public class number_of_subArray_with_k_sum
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

        // FINDING NUMBER OF SUB ARRAYS WITH SUM K

        HashMap<Integer,Integer> hashh = new HashMap<>();
        hashh.put(0,1);
        int presum = 0, cnt = 0;;
        int k;
        System.out.println("Enter the sum");
        k = sc.nextInt();
        for(int i = 0; i < n; i++)
        {
            presum += arr[i];
            if (hashh.containsKey(presum - k))
            {
                cnt = cnt + hashh.get(presum - k);
            }
            hashh.put(presum, hashh.getOrDefault(presum, 0) + 1);
        }
        System.out.println("Sub Array with sum k are "+cnt);
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