// In this problem you will be given an string s containing numbers.
// You will also be given an integer target.
// Yout task is to add binary operators between the numbers of string.
// So that it becomes target after performing all operations.
import java.util.*;
public class expression_add_operator
{
    public static void solve(int ind, String num, int target, String curr, List<String> ans, long prev, long res)
    {
        if(ind == num.length())
        {
            if(res == target)
            {
                ans.add(curr);
            }
            return;
        }

        String st = "";
        long currRes = 0;
        for(int i = ind; i < num.length(); i++)
        {
            if(i > ind && num.charAt(ind) == '0')
            {
                break;
            }
            st += num.charAt(i);
            currRes = currRes*10+(num.charAt(i) - '0');
            if(ind == 0)
            {
                solve(i+1, num, target, st, ans, currRes, currRes);
            }
            else
            {
                solve(i+1, num, target, curr+"+"+st, ans, currRes, res+currRes);
                solve(i+1, num, target, curr+"-"+st, ans, -currRes, res-currRes);
                solve(i+1, num, target, curr+"*"+st, ans, prev*currRes, res-prev+(prev*currRes));
            }
        }


    }
    public static List<String> addOperators(String num, int target)
    {
        List<String> ans = new ArrayList<>();
        solve(0,num,target,"",ans,0,0);
        return ans;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string s.");
        String s = sc.next();
        System.out.println("Enter the target.");
        int target = sc.nextInt();

        List<String> ans = new ArrayList<>();
        ans = addOperators(s,target);
        System.out.println(ans +" = "+ target); 
    }
}