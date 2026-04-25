import java.util.*;
public class sliding_window_maximum_optimal
{
    public static List<Integer> find_swm(int [] nums, int k)
    {
        int n = nums.length;
        List<Integer> swm = new ArrayList<>();
        if(k > n)
        {
            return swm;
        }
        Deque<Integer> dq = new LinkedList<>();

        for(int i = 0; i < n; i++)
        {
            if(! dq.isEmpty() && dq.peekFirst() <= i-k)
            {
                dq.pollFirst();
            }
            while(! dq.isEmpty() && nums[dq.peekLast()] <= nums[i])
            {
                dq.pollLast();
            }
            dq.offerLast(i);
            if(i >= k-1)
            {
                swm.add(nums[dq.peekFirst()]);
            }
        }

        return swm;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the size of your array.");
        n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the "+i+" element");
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the length of your window");
        int k = sc.nextInt();

        List<Integer> swm = new ArrayList<>();
        swm = find_swm(arr,k);

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

        System.out.println("\nSliding Window Maximum = "+swm);
    }
}