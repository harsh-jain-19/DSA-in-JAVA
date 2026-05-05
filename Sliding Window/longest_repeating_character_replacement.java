// In this problem you will be given an string containing all Upper Case Character.
// You will also be given an integer k specifing number of characters you can change.
// You have to return the length of longest substring with same characters after changing k characters.

import java.util.Scanner;
public class longest_repeating_character_replacement
{
    public static int longest_repeating(String str, int k)
    {
        int n = str.length();
        int l = 0, r = 0, maxLen = 0,maxF = 0;
        int [] hashh = new int[26];
        while(r < n)
        {
            hashh[str.charAt(r) - 'A']++;
            maxF = Math.max(maxF,hashh[str.charAt(r) - 'A']);
            if((r-l+1) - maxF > k)
            {
                hashh[str.charAt(l) - 'A']--;
                maxF = 0;
                for(int i = 0; i < 26; i++)
                {
                    maxF = Math.max(maxF,hashh[i]);
                }
                l++;
            }
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        return maxLen;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String from which you want sub string");
        String str = sc.nextLine();
        System.out.println("Enter the number of characters you can change.");
        int k = sc.nextInt();
        
        int maxLen = longest_repeating(str,k);
        System.out.println("Length of longest substring with same characters after changing "+k+" characters = "+maxLen);

        System.out.println(str);
    }
}