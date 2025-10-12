import java.util.Scanner;
public class palindrome
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n,lastdigit,rev=0;
        System.out.println("Enter the number you want to extract");
        n = sc.nextInt();
        int x = n;
        while(n != 0)
        {
            lastdigit = n % 10;
            n = n / 10;
            rev = (rev*10)+lastdigit;
        }
        if(rev == x)
        {
            System.out.println("Yes "+x+" is a Palindrome Number.");
        }
        else
        {
            System.out.println("No "+x+" is not a Palindrome Number");
        }
    }
}