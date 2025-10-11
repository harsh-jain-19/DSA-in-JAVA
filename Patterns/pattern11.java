import java.util.Scanner;
public class pattern11
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int a;
        System.out.println("Enter the number of rows");
        a = sc.nextInt();
        for(int i = 0; i < a; i++)
        {
            // SPACE
            for(int j = 0; j < a-i-1; j++)
            {
                System.out.print(" ");
            }
            // ALPAHBET
            char c = 'A';
            int breakpoint = (2*i+1)/2;
            for(int k = 1; k <= (i*2+1); k++)
            {
                System.out.print(c);
                if(k <= breakpoint)
                {
                    c++;
                }
                else
                {
                    c--;
                }
            }
            // SPACE
            for(int j = 0; j < a-i-1; j++)
            {
                System.out.print(" ");
            }
            System.out.println(" ");
        }
    }
}