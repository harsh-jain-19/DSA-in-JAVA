import java.util.Scanner;
public class extraction
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n,lastdigit;
        System.out.println("Enter the number you want to extract");
        n = sc.nextInt();
        while(n != 0)
        {
            lastdigit = n % 10;
            System.out.println(lastdigit);
            n = n / 10;
        }
    }
}