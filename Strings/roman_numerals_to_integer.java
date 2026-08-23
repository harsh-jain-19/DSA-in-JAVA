import java.util.*;
public class roman_numerals_to_integer
{
    public static int roman_to_int(String s)
    {
        int sum = 0;
        Map<Character,Integer> roman = new HashMap<>();
        roman.put('I',1);
        roman.put('V',5);
        roman.put('X',10);
        roman.put('L',50);
        roman.put('C',100);
        roman.put('D',500);
        roman.put('M',1000);
        for(int i = 0; i < s.length() - 1; i++)
        {
            if(roman.get(s.charAt(i)) < roman.get(s.charAt(i+1)))
            {
                sum -= roman.get(s.charAt(i));
            }
            else
            {
                sum += roman.get(s.charAt(i));
            }
        }
        return sum + roman.get(s.charAt(s.length() - 1));
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Roman Numeral which you want to convert into integer.");
        String str = sc.nextLine();

        System.out.println("Roman Numeral You Have Entered = "+str);

        int roman_int = roman_to_int(str);
        System.out.println("Roman Numeral "+str+" = "+roman_int);
    }
}