import java.util.*;
public class word_search
{
    public static boolean solve(int curr, int i, int j, char[][] board, String word, boolean[][] visited)
    {
        if(curr == word.length() - 1)
        {
            return true;
        }

        if(i-1 >= 0 && board[i-1][j] == word.charAt(curr+1) && !visited[i-1][j])
        {
            visited[i-1][j] = true;
            boolean ans = solve(curr+1, i-1, j, board, word, visited);
            if(ans)
            {
                return true;
                
            }
            visited[i-1][j] = false;
        }

        if(j-1 >= 0 && board[i][j-1] == word.charAt(curr+1) && !visited[i][j-1])
        {
            visited[i][j-1] = true;
            boolean ans = solve(curr+1, i, j-1, board, word, visited);
            if(ans)
            {
                return true;
                
            }
            visited[i][j-1] = false;
        }

        if(i+1 < board.length && board[i+1][j] == word.charAt(curr+1) && !visited[i+1][j])
        {
            visited[i+1][j] = true;
            boolean ans = solve(curr+1, i+1, j, board, word, visited);
            if(ans)
            {
                return true;
                
            }
            visited[i+1][j] = false;
        }

        if(j+1 < board[0].length && board[i][j+1] == word.charAt(curr+1) && !visited[i][j+1])
        {
            visited[i][j+1] = true;
            boolean ans = solve(curr+1, i, j+1, board, word, visited);
            if(ans)
            {
                return true;
                
            }
            visited[i][j+1] = false;
        }

        return false;
    }
    public static boolean exist(char [][] board, String word)
    {
        boolean [][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                visited[i][j] = true;
                if(board[i][j] == word.charAt(0) && solve(0, i, j, board, word, visited))
                {
                    return true;
                }
                visited[i][j] = false;
            }
        }
        return false;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int m,n;
        System.out.println("Enter the number of rows in array");
        m = sc.nextInt();
        System.out.println("Enter the numbers of collumm in array");
        n = sc.nextInt();
        char [][] arr = new char[m][n];
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                System.out.println("Enter the "+i+j+" element");
                arr[i][j] = sc.next().charAt(0);
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

        System.out.println("Enter the word you have to find.");
        String word = sc.next();

        boolean xyz = exist(arr,word);

        if(xyz)
        {
            System.out.println("Word exist in the board.");
        }
        else
        {
            System.out.println("Word does not exist in the board.");
        }
    }
}