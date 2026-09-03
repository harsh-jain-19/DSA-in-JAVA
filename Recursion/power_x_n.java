import java.util.*;

public class power_x_n
{
    public static double find_pow(double x, int n)
    {
        double ans = 1.0;
        long nn = n;
        if(nn < 0)
        {
            nn = -1*nn;
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
            ans = (double)(1.0) / (double)(ans);
        }
        return ans;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number whose power you want.");
        double x = sc.nextFloat();
        System.out.println("Enter the how much power you want.");
        int n = sc.nextInt();

        double pow = find_pow(x,n);
        System.out.println(x+" ^ "+n+" = "+pow);
    }
}