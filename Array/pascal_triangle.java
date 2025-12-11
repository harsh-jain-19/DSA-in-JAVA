// In this we will find pascal triangle.
import java.util.Scanner;
public class pascal_triangle
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n;
        // Index of row will be from 0;
        System.out.println("Enter the number of row you want to find.");
        n = sc.nextInt();
        // Finding the nth row
        for(int i = 1; i <= n; i++)
        {
            int ans = 1;
            System.out.print(ans+" ");
            for(int j = 1; j < i; j++)
            {
                ans = ans*(i-j);
                ans = ans/j;
                System.out.print(ans+" ");
            }
            System.out.println(" ");
        }
    }
}