// In this problem Row and Column of the element in pascal triangle will be given.
// And we have to find element at that position.
// We can do this by combination.
// nCr = (n!)/(r!*(n-r)!)
// Where n is number of rows and r is number of collumns
import java.util.Scanner;
public class pascal_triangle_find_element
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n,r;
        // Index of row and collumn will be from 0.
        System.out.println("Enter the row");
        n = sc.nextInt();
        System.out.println("Enter the column");
        r = sc.nextInt();
        // Finding Element at Given Position
        long res = 1;
        for(int i = 0; i < r; i++)
        {
            res = res * (n-i);
            res = res/(i+1);
        }
        System.out.println("Element Present at Given Row And Collumn is "+res);
    }
}