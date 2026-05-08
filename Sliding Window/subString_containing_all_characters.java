// In this problem you will given an string consist of three characters a,b and c.
// You have to return the number of substring having all three characters.

import java.util.*;
public class subString_containing_all_characters
{
    public static int cnt_subString(String s)
    {
        int [] lastseen = {-1,-1,-1};
        int cnt = 0;
        for(int i = 0; i < s.length(); i++)
        {
            lastseen[s.charAt(i) - 'a'] = i;
            if(lastseen[0] != -1 && lastseen[1] != -1 && lastseen[2] != -1 )
            {
                int min1 = Math.min(lastseen[0],lastseen[1]);
                int min = Math.min(min1,lastseen[2]) + 1;
                cnt += min;
            }
        }
        return cnt;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string (consist of a,b,c) from which you want sub string.");
        String str = sc.nextLine();
        
        int cnt = cnt_subString(str);
        System.out.println("Number of subString with all three characters = "+cnt);
    }
}