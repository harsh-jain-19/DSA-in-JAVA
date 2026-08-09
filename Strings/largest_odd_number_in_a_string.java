import java.util.*;
public class largest_odd_number_in_a_string
{
    public static String find_largest_odd_number(String s)
    {
        int i;
        int ind = -1;
        for(i = s.length() - 1; i >= 0; i--)
        {
            if((s.charAt(i) - '0') % 2 == 1)
            {
                ind = i;
                break;
            }
        }
        if(i < 0)
        {
            return "";
        }
        i = 0;
        while(i <= ind && s.charAt(i) == '0')
        {
            i++;
        }
        return s.substring(i, ind + 1);
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number from which you want largest odd number.");
        String str = sc.nextLine();

        System.out.println("Number You Have Entered = "+str);

        String strr = find_largest_odd_number(str);
        System.out.println("Largest odd number from the given number = "+strr);
    }
}