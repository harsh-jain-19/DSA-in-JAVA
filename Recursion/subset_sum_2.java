import java.util.*;
public class subset_sum_2
{
    public static void find_subset_sum(int ind,int [] arr, List<Integer> ds, List<List<Integer>> ans)
    {
        ans.add(new ArrayList<>(ds));
        for(int i = ind; i < arr.length; i++)
        {
            if(i != ind && arr[i] == arr[i-1])
            {
                continue;
            }
            ds.add(arr[i]);
            find_subset_sum(i+1, arr, ds, ans);
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

        System.out.println("Array you have entered.");
        for(int x : candidates)
        {
            System.out.print(x+" ");
        }
        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();
        find_subset_sum(0, candidates, new ArrayList<>(), ans);
        System.out.println("\nSubsets sum = "+ans);
    }
}