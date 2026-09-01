import java.util.*;
public class sum_of_beauty_of_all
{
    public static int getMaxCount(int[] freq)
    {
        int maxCount = Integer.MIN_VALUE;
        for(int i = 0; i < 26; i++)
        {
            maxCount = Math.max(maxCount, freq[i]);
        }
        return maxCount;
    }
    public static int getMinCount(int[] freq)
    {
        int minCount = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i++)
        {
            if(freq[i] != 0)
            {
                minCount = Math.min(minCount, freq[i]);
            }
        }
        return minCount;
    }
    public static int find_all_beauty_sum(String s)
    {
        int n = s.length();
        int sum = 0;

        for(int i = 0; i < n; i++)
        {
            int[] freq = new int[26];
            for(int j = i; j < n; j++)
            {
                freq[s.charAt(j) - 'a']++;
                int beauty = getMaxCount(freq) - getMinCount(freq);
                sum += beauty;
            }
        }
        return sum;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string from which you have to find sum of beauty of all subString.");
        String s = sc.nextLine();

        System.out.println("Strings you have Entered = "+s);
        
        int sum = find_all_beauty_sum(s);
        System.out.println("Sum of beauty of all subString = "+sum);
        
    }
}
