import java.util.Scanner;
public class pattern2
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int a;
        System.out.println("Enter Rows");
        a = sc.nextInt();
        // FORWARD PATTERN
        for(int i = 0; i < a; i++)
        {
            for(int j = 0; j <= i; j++)
            {
                System.out.print("* ");
            }
            System.out.println("");
        }
        // REVERSE PATTERN
        for(int i = a; i > 0; i--)
        {
            for(int j = i; j > 0; j--)
            {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }
}