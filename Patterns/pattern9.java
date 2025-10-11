import java.util.Scanner;
public class pattern9
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
            char b='A';
            for(int j = 0; j <= i; j++)
            {
                System.out.print(b+" ");
                b++;
            }
            System.out.println("");
        }
        // REVERSE PATTERN
        for(int i = a; i > 0; i--)
        {
            char b = 'A';
            for(int j = i; j > 0; j--)
            {
                System.out.print(b+" ");
                b++;
            }
            System.out.println("");
        }   
    }
}