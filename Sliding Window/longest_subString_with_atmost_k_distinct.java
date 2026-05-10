// In this problem you will be given an string.
// You will also be given an integer k.
// You have to return the length of longest subString with atmost k diffrent characters.

import java.util.*;
public class longest_subString_with_atmost_k_distinct
{
    public static int find_subString(String s, int k)
    {
        int l,r,maxLen;
        l = r = maxLen = 0;
        HashMap<Character,Integer> hashh = new HashMap<>();
        while(r < s.length())
        {
            hashh.put(s.charAt(r),hashh.getOrDefault(s.charAt(r),0)+1);
            if(hashh.size() > k)
            {
                hashh.put(s.charAt(l),hashh.get(s.charAt(l)) - 1);
                if(hashh.get(s.charAt(l)) == 0)
                {
                    hashh.remove(s.charAt(l));
                }
                l++;
            }
            if(hashh.size() <= k)
            {
                maxLen = Math.max(maxLen, r-l+1);
            }
            r++;
        }
        return maxLen;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string from which you want sub string.");
        String str = sc.nextLine();
        System.out.println("Enter the number of distinct character you want.");
        int k = sc.nextInt();
        int maxLen = find_subString(str,k);
        System.out.println("Length of longest substring with "+k+" diffrent character = "+maxLen);
    }
}