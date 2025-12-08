import java.util.Scanner;
public class rotate_matrix_90_optimal
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

        // Transpose
        for(int i = 0; i < m-1; i++)
        {
            for(int j = i+1; j < n; j++)
            {
                int temp;
                temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        // Reverse Rows
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n/2; j++)
            {
                int temp;
                temp = arr[i][j];
                arr[i][j] = arr[i][n-1-j];
                arr[i][n-1-j] = temp;
            }
        }
        // PRINTING
        System.out.println("Matrix After 90 Degree Rotation");
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
}