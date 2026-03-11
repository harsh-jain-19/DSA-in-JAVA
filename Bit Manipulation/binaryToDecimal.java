import java.util.Scanner;
public class binaryToDecimal
{
    public static int convert(String x)
    {
        int len = x.length();
        int power2 = 1;
        int num = 0;
        for(int i = len - 1; i >= 0; i--)
        {
            if(x.charAt(i) == '1')
            {
                num = num + power2;
            }
            power2 = power2 * 2;
        }
        return num;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number you want to convert to binary.");
        String x = sc.next();
        int result = convert(x);
        System.out.println(x+" = "+result);
    }
}