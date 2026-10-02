// In this problem you will be given an string s.
// You have to return all palindrome subString from it.
// By doing palindrome partiontion.
import java.util.*;
public class palindrome_partioning
{
    public static boolean isPalindrome(String s, int start, int end)
    {
        while(start <= end)
        {
            if(s.charAt(start++) != s.charAt(end--))
            {
                return false;
            }
        }
        return true;
    }
    public static void find_partition(int ind, String s, List<String> path, List<List<String>> ans)
    {
        if(ind == s.length())
        {
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i = ind; i < s.length(); ++i)
        {
            if(isPalindrome(s,ind,i))
            {
                path.add(s.substring(ind,i+1));
                find_partition(i+1, s, path, ans);
                path.remove(path.size()-1);
            }
            
        }
    }
    public static List<List<String>> partition(String s)
    {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        find_partition(0,s,path,ans);
        return ans;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string whose palidrome partion you want.");
        String s = sc.nextLine();
        List<List<String>> ans = new ArrayList<>();
        ans = partition(s);
        System.out.println("Palindrome strings from "+s+" = "+ans);
    }
}