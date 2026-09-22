import java.util.*;
public class combination_sum_2_brute
{
    public static void find_combination_sum(int ind,int [] arr, int target, List<List<Integer>> ans, List<Integer>ds)
    {
        if(target == 0)
        {
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i = ind; i < arr.length; i++)
        {
            if(i > ind && arr[i] == arr[i-1])
            {
                continue;
            }
            if(arr[i] > target)
            {
                break;
            }
            ds.add(arr[i]);
            find_combination_sum(i+1, arr, target - arr[i], ans, ds);
            ds.remove(ds.size() - 1);
        }
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
        System.out.println("Enter the target sum you want.");
        int target = sc.nextInt();

        System.out.println("Array you have entered.");
        for(int x : candidates)
        {
            System.out.print(x+" ");
        }

        List<List<Integer>> ans = new ArrayList<>();
        find_combination_sum(0,candidates,target,ans,new ArrayList<>());
        System.out.println("\nCombinations that can make sum "+target+" = "+ans);
    }
}