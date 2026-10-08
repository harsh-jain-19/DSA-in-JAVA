import java.util.*;
public class m_coloring_problem
{
    public static boolean isSafe(int node, ArrayList<Integer>[] G, int[] color, int n, int col)
    {
        for(int it : G[node])
        {
            if(color[it] == col)
            {
                return false;
            }
        }
        return true;
    }
    public static boolean solve(int node, ArrayList<Integer>[] G, int[] color, int n, int m)
    {
        if(node == n)
        {
            return true;
        }
        for(int i = 1; i <= m; i++)
        {
            if(isSafe(node, G, color, n, i))
            {
                color[node] = i;
                if(solve(node+1, G, color, n ,m) == true)
                {
                    return true;
                }
                color[node] = 0;
            }
        }
        return false;
    }
    public static boolean graphColoring(ArrayList<Integer>[] G, int [] color, int i, int m)
    {
        int n = G.length;
        if(solve(i, G, color, n, m))
        {
            return true;
        }
        return false;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices in graph");
        int n = sc.nextInt();
        ArrayList<Integer>[] gra = new ArrayList[n];
        for(int i = 0; i < n; i++)
        {
            gra[i] = new ArrayList<>();
        }

        System.out.println("Enter the number of edges");
        int e = sc.nextInt();

        for(int i = 0; i < e; i++)
        {
            System.out.println("Enter Edge "+(i+1)+":");

            int u = sc.nextInt();
            int v = sc.nextInt();

            gra[u].add(v);
            gra[v].add(u);
        }

        System.out.println("Enter the number of colors.");
        int m = sc.nextInt();

        int [] color = new int[n];

        // Printing
        System.out.println("\nGraph:");

        for (int i = 0; i < n; i++) {
            System.out.print(i + " -> ");

            for (int neighbour : gra[i]) {
                System.out.print(neighbour + " ");
            }

            System.out.println();
        }

        if (graphColoring(gra,color,0,m)) 
        { 
            System.out.println("\nGraph can be colored using " + m + " colors."); 
            for (int i = 0; i < n; i++) 
            { 
                System.out.println( "Vertex " + i + " -> Color " + color[i] ); 
            } 
        } 
        else 
        { 
            System.out.println( "\nGraph cannot be colored using " + m + " colors." ); 
        }
    }
}