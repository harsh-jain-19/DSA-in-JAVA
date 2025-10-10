import java.util.Scanner;
public class pattern4
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int a;
        System.out.println("Enter Rows");
        a = sc.nextInt();
        // FORWARD PATTERN
        for(int i = 1; i <= a; i++)
        {
            for(int j = 1; j <= i; j++)
            {
                System.out.print(i+" ");
            }
            System.out.println("");
        }
        // REVERSE PATTERN
        for(int i = a; i > 0; i--)
        {
            for(int j = 1; j <= i; j++)
            {
                System.out.print(i+" ");
            }
            System.out.println("");
        }
    }
}