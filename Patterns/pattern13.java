import java.util.Scanner;
public class pattern13
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int a;
        System.out.println("Enter Rows");
        a = sc.nextInt();
        
        // REVERSE PATTERN
        for(int i = 0; i < a; i++)
        {
            // SPACE
            for(int j = 0; j <= i; j++)
            {
                System.out.print("*");
            }
            // STAR
            for(int k = 0; k < (2*a)-((2*i)+1); k++)
            {
                System.out.print(" ");
            }
            // SPACE
            for(int j = 0; j <= i; j++)
            {
                System.out.print("*");
            }
            System.out.println("");
        }
        // FORWARD PATTERN
        for(int i = 1; i < a; i++)
        {
            // STAR
            for(int j = 0; j < a-i; j++)
            {
                System.out.print("*");
            }
            // SPACE
            for(int k = 0; k < i*2+1; k++)
            {
                System.out.print(" ");
            }
            // STAR
            for(int j = 0; j < a-i; j++)
            {
                System.out.print("*");
            }
            System.out.println("");
        }
        
    }
}