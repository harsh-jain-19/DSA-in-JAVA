// GCD = Greatest Common Devisor
//              OR
// HCF = Highest Common Factor
import java.util.Scanner;
public class gcd_hcf
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n1,n2,a;
        System.out.println("Enter two numbers of which you want to find HCF");
        n1 = sc.nextInt();
        n2 = sc.nextInt();
        a = Math.min(n1,n2);
        // for(int i = a; i >= 1; i--)
        // {
        //     if(n1 % i == 0 && n2 % i ==0)
        //     {
        //         System.out.println("HCF of "+n1+","+n2+" is "+i);
        //         break;
        //     }
        // }

        while(n1 > 0 && n2 > 0)
        {
            if(n1 > n2)
            {
                n1 = n1 % n2;
            }
            else
            {
                n2 = n2 % n1;
            }
        }
        if( n1 == 0)
        {
            System.out.println("HCF is "+n2);
        }
        else
        {
            System.out.println("HCF is "+n1);
        }
    }
}