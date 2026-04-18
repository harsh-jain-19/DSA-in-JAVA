// In this problem you will be given an string "nums" consist of numbers from 0 - 9.
// You have to remove k digits from that string.
// In such a way that the remaing number is smallest.

import java.util.*;
public class remove_k_digits
{
    public static String remove_digits(String str, int k)
    {
        int n = str.length();
        Stack<Character> stackk = new Stack<>();
        
        for(int i = 0; i < n; i++)
        {
            while(! stackk.isEmpty() && k > 0 && ((stackk.peek() - '0') > (str.charAt(i) - '0')))
            {
                stackk.pop();
                k--;
            }
            stackk.push(str.charAt(i));
        }
        while(k > 0)
        {
            stackk.pop();
            k--;
        }
        if(stackk.isEmpty() == true)
        {
            return "0";
        }
        String result = "";
        while(! stackk.isEmpty())
        {
            result = result + stackk.peek();
            stackk.pop();
        }
        while(result.length() != 0 && result.charAt(result.length() - 1) == '0')
        {
            result = result.substring(0, result.length() - 1);
        }
        result = new StringBuilder(result).reverse().toString();

        if(result.isEmpty())
        {
            return "0";
        }

        return result;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of your String");
        int n = sc.nextInt();
        char [] arr = new char[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the "+i+" element");
            arr[i] = sc.next().charAt(0);
        }
        String str = new String(arr);

        int k;
        System.out.println("Enter how many digits you want to remove.");
        k = sc.nextInt();

        String ans = remove_digits(str,k);
        System.out.println("String after removing "+k+" digits = "+ans);
    }
}