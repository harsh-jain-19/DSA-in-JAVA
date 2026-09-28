// In this problem we will be given two integers k and n.
// k means number of integers we can use.
// n means the sum we have to make using k integers.
// Our task is to return List<List<Integer>> containing k integers whose sum equals to n.
// NOTE: We can use numbers from 1 to 9 and each number can only be used once.
import java.util.*;
public class combination_sum_3
{
    public static void find_combination_sum(int ind,int k, int n, List<List<Integer>> ans, List<Integer>ds)
    {
        if(n == 0 && k == 0)
        {
            ans.add(ds);
            return;
        }
        if(ind > 9)
        {
            return;
        }
        if(n < 0 || k < 0)
        {
            return;
        }
        List<Integer> temp = new ArrayList<>(ds);
        temp.add(ind);
        find_combination_sum(ind+1, k-1, n-ind, ans, temp);
        // ds.remove(ds.size() - 1);
        find_combination_sum(ind+1, k, n, ans, ds);
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of k.");
        int k = sc.nextInt();
        System.out.println("Enter the value of n.");
        int n = sc.nextInt();

        List<List<Integer>> ans = new ArrayList<>();

        find_combination_sum(1,k,n,ans,new ArrayList<>());
        System.out.println("Combinations that can make sum "+n+" = "+ans);
    }
}