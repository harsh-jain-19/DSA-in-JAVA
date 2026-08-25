import java.util.*;
public class count_number_of_subStrings
{
     // Function to count substrings with at most k distinct characters
    public static int atMostKDistinct(String s, int k) {
        int left = 0, res = 0;
        Map<Character, Integer> freq = new HashMap<>();

        // Iterate with right pointer
        for (int right = 0; right < s.length(); right++) {
            freq.put(s.charAt(right), freq.getOrDefault(s.charAt(right), 0) + 1);

            // Shrink window if distinct characters exceed k
            while (freq.size() > k) {
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);
                if (freq.get(leftChar) == 0) freq.remove(leftChar);
                left++;
            }

            // Add count of substrings in current window
            res += (right - left + 1);
        }
        return res;
    }

    // Function to count substrings with exactly k distinct characters
    public static int countSubstrings(String s, int k) {
        return atMostKDistinct(s, k) - atMostKDistinct(s, k - 1);
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String from which you want to calculate number of subString.");
        String str = sc.nextLine();

        System.out.println("Enter minimum number of distinct character every sunString shuold have.");
        int k = sc.nextInt();

        System.out.println("String You Have Entered = "+str);

        int str_int = countSubstrings(str,k);
        System.out.println("String "+str+" = "+str_int);
    }
}