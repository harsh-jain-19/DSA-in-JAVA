import java.util.Scanner;
public class count
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        long n;
        long lastdigit;
        System.out.println("Enter the number you want to count");
        n = sc.nextInt();
        int count = 0;
        while(n != 0)
        {
            lastdigit = n % 10;
            n = n / 10;
            count++;
        }
        System.out.println("Number of digits in given Number are : "+count);
    }
}