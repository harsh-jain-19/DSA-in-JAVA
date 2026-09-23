import java.util.*;
public class subset_sum_1
{
    public static void find_subset_sum(int ind,int sum, int [] arr, int n, List<Integer> ans)
    {
        if(ind == n)
        {
            ans.add(sum);
            return;
        }
        
        find_subset_sum(ind+1, sum + arr[ind], arr, n, ans);
        find_subset_sum(ind+1, sum, arr, n, ans);
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array.");
        int n = sc.nextInt();
        int [] candidates = new int[n];
        for(int i = 0; i< n; i++)
        {
            System.out.println("Enter the value of "+i+" index.");
            candidates[i] = sc.nextInt();
        }

        System.out.println("Array you have entered.");
        for(int x : candidates)
        {
            System.out.print(x+" ");
        }
        int sum = 0;

        List<Integer> ans = new ArrayList<>();
        find_subset_sum(0,sum,candidates,n,ans);
        Collections.sort(ans);
        System.out.println("\nSubsets sum = "+ans);
    }
}