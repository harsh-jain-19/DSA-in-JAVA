import java.util.*;
public class n_queens
{
    public static boolean isSafe(int row, int col, List<String> board, int n)
    {
        int duprow = row;
        int dupcol = col;

        while(duprow >= 0 && dupcol >= 0)
        {
            if (board.get(duprow).charAt(dupcol) == 'Q') {
                return false;
            }
            duprow--;
            dupcol--;
        }

        dupcol = col;
        duprow = row;
        while(dupcol >= 0)
        {
            if (board.get(duprow).charAt(dupcol) == 'Q') {
                return false;
            }
            dupcol--;
        }

        dupcol = col;
        duprow = row;
        while(duprow < n && dupcol >= 0)
        {
            if (board.get(duprow).charAt(dupcol) == 'Q') {
                return false;
            }
            duprow++;
            dupcol--;
        }
        return true;
    }
    public static void solve(int col, List<String> board, List<List<String>> ans, int n)
    {
        if(col == n)
        {
            ans.add(new ArrayList<>(board));
            return;
        }
        for(int row = 0; row < n; row++)
        {
            if(isSafe(row, col, board, n))
            {
                // Place queen
                StringBuilder sb = new StringBuilder(board.get(row));
                sb.setCharAt(col, 'Q');
                board.set(row, sb.toString());

                // Move to next column
                solve(col + 1, board, ans, n);

                // Backtrack: remove queen
                sb.setCharAt(col, '.');
                board.set(row, sb.toString());
            }
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of your n x n board.");
        int n = sc.nextInt();

        List<List<String>> ans = new ArrayList<>();
        List<String> board = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            board.add(".".repeat(n));
        }

        solve(0,board,ans,n);
        System.out.println("Number of Solutions = "+ans.size());
        for (List<String> solution : ans) {
            System.out.println(solution);
            System.out.println();
        }
    }
}