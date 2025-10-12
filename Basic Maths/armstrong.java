import java.util.Scanner;
public class armstrong
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n,x,digit,y,z=0;
        System.out.println("Enter the number you want to check Armstrong");
        n = sc.nextInt();
        x = n;
        while(n != 0)
        {
            digit = n % 10;
            n = n / 10;
            y = digit*digit*digit;
            z = z + y;
        }
        if(z == x)
        {
            System.out.println("Yes "+x+" is a Armstrong Number");
        }
        else
        {
            System.out.println("No "+x+" is a Armstrong Number");
        }
    }
}