import java.util.Scanner;
public class pattern7
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int a,space;
        System.out.println("Enter Rows");
        a = sc.nextInt();
        space = (2*a)-1;
        // FORWARD PATTERN
        for(int i = 0; i < a; i++)
        {
            // NUMBER
            for(int j = 0; j <= i; j++)
            {
                System.out.print(j+1);
            }
            // SPACE
            for(int k = 1; k < space; k++)
            {
                System.out.print(" ");
            }
            // NUMBER
            for(int j = 0; j <= i; j++)
            {
                System.out.print(j+1);
            }
            System.out.println("");
            space = space - 2;
        }
        // REVERSE PATTERN
        for(int i = 0; i < a; i++)
        {
            // NUMBER
            for(int j = 0; j <= a-1-i; j++)
            {
                System.out.print(j+1);
            }
            // SPACE
            for(int k = 1; k < i*2+1; k++)
            {
                System.out.print(" ");
            }
            // NUMBER
            for(int j = 0; j <= a-1-i; j++)
            {
                System.out.print(j+1);
            }
            System.out.println("");
        }
    }
}