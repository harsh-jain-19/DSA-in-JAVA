import java.util.*;
public class sudoko_solver
{
    public static boolean isValid(char [][] board, int row, int col, char c)
    {
        int n = board.length;
        for(int i = 0; i < n; i++)
        {
            if(board[i][col] == c)
            {
                return false;
            }
            if(board[row][i] == c)
            {
                return false;
            }
            if(board[3 * (row/3) + (i/3)] [3 * (col/3) + (i%3)] == c)
            {
                return false;
            }
        }
        return true;
    }
    public static boolean solve(char [][] board)
    {
        int n = board.length;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(board[i][j] == '.')
                {
                    for(char c = '1'; c <= '9'; c++)
                    {
                        if(isValid(board,i,j,c))
                        {
                            board[i][j] = c;
                            if(solve(board) == true)
                            {
                                return true;
                            }
                            else
                            {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of your Sudoko Board");
        int n = sc.nextInt();
        char [][] sudoko_board = new char[n][n];

        System.out.println("Enter the values in your Sudoko Board.");
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                System.out.println("Enter the value of "+i+j+" element.");
                sudoko_board[i][j] = sc.next().charAt(0);
            }
        }

        System.out.println("Sudoko Board You Have Given.");
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                System.out.print(sudoko_board[i][j]+" ");
            }
            System.out.println(" ");
        }

        boolean sol = solve(sudoko_board);

        if(sol)
        {
            System.out.println("Sudoko Board After Solving.");
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                {
                    System.out.print(sudoko_board[i][j]+" ");
                }
                System.out.println(" ");
            }
        }
        else
        {
            System.out.println("No Solution Exist.");
        }
    }
}