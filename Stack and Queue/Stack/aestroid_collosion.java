// In this problem you will be given an array containing the size of the aestroid.
// Postive sign denotes that aestroid moves in right direction.
// Negative sign denotes that aestroid moves in left direction.
// If there are two aestroid travelling in opposite direction then smaller aestroid will be destroyed.
// And if the size is same then both of them will be destroyed.
// We have to return the final state of all the aestroid.
import java.util.*;

public class aestroid_collosion
{
    public static List<Integer> after_collosion(int [] nums)
    {
        List<Integer> st = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < n; i++)
        {
            if(nums[i] > 0)
            {
                st.add(nums[i]);
            }
            else
            {
                while(! st.isEmpty() && st.getLast() > 0 && (st.getLast() < Math.abs(nums[i])))
                {
                    st.remove(st.size() - 1);
                }
                if(! st.isEmpty() && st.getLast() == Math.abs(nums[i]))
                {
                    st.remove(st.size() - 1);
                }
                else if(st.isEmpty() || st.getLast() < 0)
                {
                    st.add(nums[i]);
                }
            }
        }
        return st;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the number of aestroids you have.");
        n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the size of "+i+" aestroid");
            arr[i] = sc.nextInt();
        }

        List<Integer> ans = new ArrayList<>();
        ans = after_collosion(arr);

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
        System.out.println("\nFINAL STATE AFTER COLLOSION");
        System.out.println(ans);
    }
}