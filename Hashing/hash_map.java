// Doing Hasing through array is taking more storage as it is declared in starting.
// Hashmap uses less storage as compared to array.
import java.util.*;
public class hash_map
{
    public static void main(String[] arsg)
    {
        Scanner sc = new Scanner(System.in);
        int n,x=1,a;
        System.out.println("Enter the size of an Array");
        n = sc.nextInt();
        int [] arr = new int[n];
        HashMap<Integer,Integer> hashh = new HashMap<>();
        System.out.println("Enter the elements of an Array");
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the "+i+" element");
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++)
        {
            hashh.put(arr[i], hashh.getOrDefault(arr[i], 0) + 1);
        }
        while(x == 1)
        {
            System.out.println("Enter the number of which you want to check Frequency in array");
            a = sc.nextInt();
            System.out.println(a+" occurs "+hashh.get(a)+" times in array");
            System.out.println("If you again want to check the ferquency of any number then press 1");
            x = sc.nextInt();

        }
    }
}