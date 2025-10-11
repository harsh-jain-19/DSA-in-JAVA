import java.util.Scanner;
public class pattern14
{
    public static void main(String[] arsg)
    {
        Scanner sc = new Scanner(System.in);
        int a;
        System.out.println("Enter number of rows.");
        a = sc.nextInt();
        for(int i = 0; i < a; i++)
        {
            for(int j = 0; j < a; j++)
            {
                if(i != 0 && i != a-1 && j != 0 && j != a-1)
                {
                    System.out.print("  ");
                }
                else
                {
                    System.out.print("* ");
                }
            }
            System.out.println(" ");
        }
    }
}