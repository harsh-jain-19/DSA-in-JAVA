// In this problem you will be given an string containing only (,*,).
// You can change * -> ( and * -> ) and * -> _ to make string valid.
// You have to tell that given string is valid or not.

import java.util.Scanner;
public class valid_paranthesis_string
{
    public static boolean string_valid(String s)
    {
        int min, max;
        min = max = 0;
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '(')
            {
                min++;
                max++;
            }
            else if(s.charAt(i) == ')')
            {
                min--;
                max--;
            }
            else
            {
                min--;
                max++;
            }

            if(min < 0)
            {
                min = 0;
            }
            if(max < 0)
            {
                return false;
            }
        }
        return min == 0;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String of (, ) and * to check it is valid or not.");
        String str = sc.nextLine();

        boolean str_valid = string_valid(str);
        if(str_valid)
        {
            System.out.println("You have entered the valid string.");
        }
        else
        {
            System.out.println("You have entered the invalid string.");
        }
        System.out.println(str);
    }
}