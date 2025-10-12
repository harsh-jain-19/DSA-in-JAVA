import java.util.Scanner;
public class reverse
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n,lastdigit,rev=0;
        System.out.println("Enter the number you want to extract");
        n = sc.nextInt();
        while(n != 0)
        {
            lastdigit = n % 10;
            n = n / 10;
            rev = (rev*10)+lastdigit;
        }
        System.out.println(rev);
    }
}