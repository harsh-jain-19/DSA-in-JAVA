import java.util.*;
public class merge_overlapping_intervals
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n; 
        System.out.println("Enter the size of an array");
        n = sc.nextInt();
        int [][] arr = new int[n][2];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < 2; j++)
            {
                System.out.println("Enter the "+i+","+j+" element");
                arr[i][j] = sc.nextInt();
            }
        }
        // PRINTING
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < 2; j++)
            {
                if(j == 0)
                {
                    System.out.print(arr[i][j]);
                }
                else
                {
                    System.out.print(","+arr[i][j]);
                }
            }
            System.out.println("");
        }
        // MERGE OVERLAPPING INTERVALS
        Arrays.sort(arr,(a,b) -> a[0]-b[0]);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n-1; i++)
        {
            ArrayList <Integer> abc = new ArrayList<>();
            
            if(ans == null)
            {
                ArrayList<Integer> xyz = new ArrayList<>();
                xyz.add(arr[0][0]);
                xyz.add(arr[0][1]);
                ans.add(xyz);
            }
            else if( arr[i][1] > abc.get(0) )
            {
                ArrayList<Integer> xyz = new ArrayList<>();
                xyz.add(arr[i][0]);
                xyz.add(arr[i][1]);
                ans.add(xyz);
            }
            else
            {
                if(arr[i][1] > arr[i+1][1])
                {
                    ArrayList<Integer> xyz = new ArrayList<>();
                    xyz.add(arr[i][0]);
                    xyz.add(arr[i][1]);
                    ans.add(xyz);
                }
                else
                {
                    ArrayList<Integer> xyz = new ArrayList<>();
                    xyz.add(arr[i+1][0]);
                    xyz.add(arr[i+1][1]);
                    ans.add(xyz);
                }
            }
            abc = ans.get(ans.size() - 1);
        }
        System.out.println(ans);
    }
}