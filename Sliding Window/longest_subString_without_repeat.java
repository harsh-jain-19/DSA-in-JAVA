// In this problem we will be given an string.
// We have to return an longest subString without repeating am same character.

import java.util.*;
public class longest_subString_without_repeat
{
    public static int find_subString(String s)
    {
        int [] hashh = new int[256];
        for(int i = 0; i < 256; i++)
        {
            hashh[i] = -1;
        }
        int n = s.length();
        int l = 0;
        int r = 0;
        int maxLen = 0;
        while(r < n)
        {
            if(hashh[s.charAt(r)] != -1)
            {
                if(hashh[s.charAt(r)] >= l)
                {
                    l = hashh[s.charAt(r)] + 1;
                }
            }
            int len = r-l+1;
            maxLen = Math.max(len,maxLen);
            hashh[s.charAt(r)] = r;
            r++;
        }
        return maxLen;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string from which you want sub string.");
        String str = sc.nextLine();
        int n = str.length();
        int maxLen = find_subString(str);
        System.out.println("Length of longest substring without repetation of character = "+maxLen);
    }
}