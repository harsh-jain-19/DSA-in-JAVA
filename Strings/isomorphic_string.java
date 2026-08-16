import java.util.*;
public class isomorphic_string
{
    public static boolean check_isomorphic(String s, String t)
    {
        // Arrays to track last seen positions of characters in s and t
          int[] m1 = new int[256], m2 = new int[256];
  
          // Get length of the strings
          int n = s.length();
  
          // Loop through all characters in the strings
          for (int i = 0; i < n; ++i) {
              // Return false if mapping is inconsistent
              if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
  
              // Update last seen index for both characters
              m1[s.charAt(i)] = i + 1;
              m2[t.charAt(i)] = i + 1;
          }
  
          // Return true if all character mappings are consistent
          return true;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first string.");;
        String s = sc.nextLine();

        System.out.println("Enter the second string.");;
        String t = sc.nextLine();

        boolean check = check_isomorphic(s,t);
        if(check)
        {
            System.out.println("Strings are Isomorphic.");
        }       
        else
        {
            System.out.println("Strings are not Isomorphic.");
        } 
    }
}