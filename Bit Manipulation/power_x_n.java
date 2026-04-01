// In this Problem We will be given two integers x and n.
// We have to return x^n.
import java.util.Scanner;
public class power_x_n
{
    public static double power(double x, double n)
    {
        double ans = 1;
        double nn = n;
        if(nn < 0)
        {
            nn = nn * -1;
        }
        while(nn > 0)
        {
            if(nn % 2 == 1)
            {
                ans = ans * x;
                nn = nn - 1;
            }
            else
            {
                x = x * x;
                nn = nn / 2;
            }
        }
        if(n < 0)
        {
            ans = 1 / ans;
        }
        return ans;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        double x,n;
        System.out.println("Enter the value of x.");
        x = sc.nextInt();
        System.out.println("Enter the value of n.");
        n = sc.nextInt();
        double ans = power(x,n);
        System.out.println(x+" ^ "+n+" = "+ans);
    }
}