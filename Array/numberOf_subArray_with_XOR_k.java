import java.util.*;
public class numberOf_subArray_with_XOR_k
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
        // FINDING THE NUMBER OF SUB ARRAY WITH XOR K
        int xr = 0;
        HashMap<Integer,Integer> hashh = new HashMap<>();
        hashh.put(0,1);
        int cnt = 0;
        int k;
        System.out.println("Enter the value of XOR");
        k = sc.nextInt();
        for(int i = 0; i < n; i++)
        {
            xr = xr ^ arr[i];
            int x = xr ^ k;
            if(hashh.containsKey(x))
            {
                cnt += hashh.get(x);
            }
            hashh.put(xr, hashh.getOrDefault(xr, 0) + 1);
        }
        System.out.println("Number of Sub Array with XOR k : "+cnt);
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