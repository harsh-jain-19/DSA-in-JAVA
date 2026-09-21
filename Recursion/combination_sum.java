import java.util.*;
public class combination_sum
{
    public static void find_combination_sum(int ind,int [] arr, int target, List<List<Integer>> ans, List<Integer>ds)
    {
        if(ind == arr.length)
        {
            if(target == 0)
            {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(arr[ind] <= target)
        {
            ds.add(arr[ind]);
            find_combination_sum(ind, arr, target - arr[ind], ans, ds);
            ds.remove(ds.size() - 1);
        }
        find_combination_sum(ind+1, arr, target, ans, ds);
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array.");
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i< n; i++)
        {
            System.out.println("Enter the value of "+i+" index.");
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the target sum you want.");
        int target = sc.nextInt();

        System.out.println("Array you have entered.");
        for(int x : arr)
        {
            System.out.print(x+" ");
        }

        List<List<Integer>> ans = new ArrayList<>();
        find_combination_sum(0,arr,target,ans,new ArrayList<>());
        System.out.println("\nCombinations that can make sum "+target+" = "+ans);
    }
}