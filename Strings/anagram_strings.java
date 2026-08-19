import java.util.*;
public class anagram_strings
{
    public static boolean anagram(String s1, String s2)
    {
        if(s1.length() != s2.length())
        {
            return false;
        }
        int [] arr = new int[26];
        for(int i = 0; i < s1.length(); i++)
        {
            arr[s1.charAt(i) - 'A']++;
            arr[s2.charAt(i) - 'A']--;
        }
        for(int i = 0; i < s1.length(); i++)
        {
            if(arr[i] != 0)
            {
                return false;
            }
        }
        return true;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first string.");;
        String s1 = sc.nextLine();

        System.out.println("Enter the second string.");
        String s2 = sc.nextLine();

        boolean check = anagram(s1, s2);
        if(check)
        {
            System.out.println("s1 and s2 are anagram strings.");
        }       
        else
        {
            System.out.println("s1 and s2 are not anagram strings.");
        } 
    }
}