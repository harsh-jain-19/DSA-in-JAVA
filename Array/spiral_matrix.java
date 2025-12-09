import java.util.*;
public class spiral_matrix
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
        System.out.println("Given Matrix");
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println(" ");
        }

        // PRINTING IN SPIRAL FORM

        int left = 0, right = n-1;
        int top = 0, bottom = m-1;
        ArrayList<Integer> ans = new ArrayList<>();

        while(top <= bottom && left <= right)
        {
            for(int i = left; i <= right; i++)
            {
                ans.add(arr[top][i]);
            }
            top++;

            for(int i = top; i <= bottom; i++)
            {
                ans.add(arr[i][right]);
            }
            right--;

            if(top <= bottom)
            {
                for(int i = right; i >= left; i--)
                {
                    ans.add(arr[bottom][i]);
                }
                bottom--;
            }

            if(left <= right)
            {
                for(int i = bottom; i >= top; i--)
                {
                    ans.add(arr[i][left]);
                }
                left++;
            }
        }

        // PRINTING
        System.out.println("Spiral Matrix");
        for(int element: ans)
        {
            System.out.println(element);
        }
    }
}