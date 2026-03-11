import java.util.Scanner;
public class decimalToBinary
{
    public static String convert(int x)
    {
        String result = "";
        while(x > 0)
        {
            if(x % 2 == 1)
            {
                result += '1';
            }
            else
            {
                result += '0';
            }
            x = x / 2;
        }
        result = new StringBuilder(result).reverse().toString();   // To revrese a string
        return result;                                             // this is used.
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number you want to convert to binary.");
        int x = sc.nextInt();
        String result = convert(x);
        System.out.println(x+" = "+result);
    }
}