// In this problem We will find the Nth Pascal Triangle row.
import java.util.Scanner;
public class pascal_triangle_find_row
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n;
        // Index of row will be from 0;
        System.out.println("Enter the number of row you want to find.");
        n = sc.nextInt();
        // Finding the nth row
        int ans = 1;
        System.out.print(ans+" ");
        for(int i = 1; i < n; i++)
        {
            ans = ans*(n-i);
            ans = ans/(i);
            System.out.print(ans+" ");
        }
    }
}