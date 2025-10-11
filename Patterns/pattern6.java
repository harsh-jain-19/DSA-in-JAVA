import java.util.Scanner;
public class pattern6
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int a;
        int start = 1;
        System.out.println("Enter the number of rows.");
        a = sc.nextInt();
        for(int i = 0; i < a; i++)
        {
            if(i % 2 == 0)
            {
                start = 1;
            }
            else
            {
                start = 0;
            }
            for(int j = 0; j <= i; j++)
            {
                System.out.print(start+" ");
                start = 1 - start;
            }
            System.out.println("");
        }
    }
}