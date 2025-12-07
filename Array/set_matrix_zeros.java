import java.util.Scanner;
public class set_matrix_zeros
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

        int col0 = 1;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(arr[i][j] == 0)
                {
                    arr[i][0] = 0;
                    if(j != 0)
                    {
                        arr[0][j] = 0;
                    }
                    else
                    {
                        col0 = 0;
                    }
                }
            }
        }
        for(int i = 1; i < m; i++)
        {
            for(int j = 1; j < n; j++)
            {
                if(arr[i][j] != 0)
                {
                    if(arr[0][j] == 0 || arr[i][0] == 0)
                    {
                        arr[i][j] = 0; 
                    }
                }
            }
        }
        if(arr[0][0] == 0)
        {
            for(int j = 0; j < n; j++)
            {
                arr[0][j] = 0;
            }
        }
        if(col0 == 0)
        {
            for(int i = 0; i < m; i++)
            {
                arr[i][0] = 0;
            }
        }
        // PRINTING
        System.out.println("Matrix After Setting Zeros");
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