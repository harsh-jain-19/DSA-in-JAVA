import java.util.Scanner;
public class rotate_matrix_90_brute
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int m,n;
        System.out.println("Enter the number of rows in array");
        m = sc.nextInt();
        System.out.println("Enter the numbers of collumm in array");
        n = sc.nextInt();
        int [][] arr = new int[m][n];
        int [][] ans = new int[n][m];
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                System.out.println("Enter the "+i+j+" element");
                arr[i][j] = sc.nextInt();
            }
        }

        // PRINTING
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println(" ");
        }

        // SETTING ZEROS IN MATRIX
        // Here we will only input square matrix
        // TIME COMPLEXITY = O(n*n)
        // SPACE COMPLEXITY = O(n*n)

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                ans[j][(n-1)-i] = arr[i][j];
            }
        }
        // PRINTING
        System.out.println("Matrix After 90 Degree Rotation");
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
}