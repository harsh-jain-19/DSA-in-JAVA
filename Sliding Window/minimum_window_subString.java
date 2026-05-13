// In this problem you be given a strings s and t.
// You have to return smallest substring from s that have all characters of t.
import java.util.*;

public class minimum_window_subString
{
    public static String find_subString(String s, String t)
    {
        int l,r,cnt,minLen,Sindex;
        l = r = cnt = 0;
        Sindex = -1;
        minLen = Integer.MAX_VALUE;
        HashMap<Character,Integer> mpp = new HashMap<>(); 
        int n = s.length();
        int m = t.length();

        for(int i = 0; i < m; i++)
        {
            mpp.put(t.charAt(i),mpp.getOrDefault(t.charAt(i),0) + 1);
        }

        while(r < n)
        {
            if(mpp.getOrDefault(s.charAt(r),0) > 0)
            {
                cnt++;
                
            }
            mpp.put(s.charAt(r),mpp.getOrDefault(s.charAt(r),0) - 1);
            while(cnt == m)
            {
                if((r-l+1) < minLen)
                {
                    minLen = r-l+1;
                    Sindex = l;
                }
                mpp.put(s.charAt(l),mpp.get(s.charAt(l)) + 1);
                if(mpp.get(s.charAt(l)) > 0)
                {
                    cnt--;
                }
                l++;
            }
            r++;
        }
        if(Sindex == -1)
        {
            return "";
        }
        else
        {
            return s.substring(Sindex, Sindex+minLen);
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string from which you want sub string.");
        String s = sc.nextLine();
        System.out.println("Enter the strign whose all character you want in subString.");
        String t = sc.nextLine();
        String minStr = find_subString(s,t);
        System.out.println("Smallest substring from s with "+t+" character = "+minStr);
    }
}