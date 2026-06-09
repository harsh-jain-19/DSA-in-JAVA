// In this problem you will be given an array containing intervals.
// You have to merge all overlapping intervals.

import java.util.*;
public class merge_overlapping_intervals
{
    public static int[][] merge_intervals(int intervals[][])
    {
        List<int[]> res = new ArrayList<>();
        if(intervals.length == 0 || intervals == null)
        {
            return res.toArray(new int[0][]);
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int[] i : intervals)
        {
            if(i[0] <= end)
            {
                end = Math.max(end,i[1]);
            }
            else
            {
                res.add(new int[]{start, end});
                start = i[0];
                end = i[1];
            }
        }
        res.add(new int[]{start, end});
        return res.toArray(new int[0][]);
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of intervals you have.");
        int n = sc.nextInt();
        int [][] intervals = new int[n][2];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter Starting point of "+i+" interval.");
            intervals[i][0] = sc.nextInt();
            System.out.println("Enter Ending point of "+i+" interval.");
            intervals[i][1] = sc.nextInt();
        }

        // PRINTING
        System.out.println("Intervals before merging overlapping intervals.");
        for(int i = 0; i < n; i++)
        {
            System.out.println("[ "+intervals[i][0]+" , "+intervals[i][1]+" ]");
        }

        int [][] result = merge_intervals(intervals);
        System.out.println("Intervals after merging overlapping intervals.");
        for(int i = 0; i < result.length; i++)
        {
            System.out.println("[ "+result[i][0]+" , "+result[i][1]+" ]");
        }
    }
}