import java.util.*;
public class rat_in_a_maze
{
    public static void solve(int i, int j, int [][] a, int n, List<String> ans, String move, int [][] vis)
    {
        if(i == n-1 && j == n-1)
        {
            ans.add(move);
            return;
        }

        // DOWNWARD
        if(i+1 < n && vis[i+1][j] == 0 && a[i+1][j] == 1)
        {
            vis[i][j] = 1;
            solve(i+1, j, a, n, ans, move + 'D', vis);
            vis[i][j] = 0;
        }

        // LEFT
        if(j-1 >= 0 && vis[i][j-1] == 0 && a[i][j-1] == 1)
        {
            vis[i][j] = 1;
            solve(i, j-1, a, n, ans, move + 'L', vis);
            vis[i][j] = 0;
        }

        // RIGHT
        if(j+1 < n && vis[i][j+1] == 0 && a[i][j+1] == 1)
        {
            vis[i][j] = 1;
            solve(i, j+1, a, n, ans, move + 'R', vis);
            vis[i][j] = 0;
        }

        // UPWARD
        if(i-1 >= 0 && vis[i-1][j] == 0 && a[i-1][j] == 1)
        {
            vis[i][j] = 1;
            solve(i-1, j, a, n, ans, move + 'U', vis);
            vis[i][j] = 0;
        }
    }
    public static List<String> find_path(int [][] matrix, int n)
    {
        List<String> ans = new ArrayList<>();
        int [][] vis = new int[n][n];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                vis[i][j] = 0;
            }
        }
        if(matrix[0][0] == 1)
        {
            solve(0,0,matrix,n,ans,"",vis);
        }
        return ans;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the size of n x n matrix");
        n = sc.nextInt();
        int [][] matrix = new int[n][n];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                System.out.println("Enter the "+i+j+" element");
                matrix[i][j] = sc.nextInt();
            }
        }

        // PRINTING
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println(" ");
        }

        List<String> ans = new ArrayList<>();
        ans = find_path(matrix, n);
        System.out.println("Number of Solutions = "+ans.size());
        for (String solution : ans) {
            System.out.println(solution);
            System.out.println();
        }
    }
}