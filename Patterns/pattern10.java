import java.util.Scanner;
public class pattern10
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int a;
        
        System.out.println("Enter Rows");
        a = sc.nextInt();
        // FORWARD PATTERN
        char b='A';
        for(int i = 0; i < a; i++)
        {
            for(int j = 0; j <= i; j++)
            {
                System.out.print(b+" ");
            }
            System.out.println("");
            b++;
        }
        // REVERSE PATTERN
        for(int i = a; i > 0; i--)
        {
            b--;
            for(int j = i; j > 0; j--)
            {
                System.out.print(b+" ");
            }
            System.out.println("");
        }   
    }
}