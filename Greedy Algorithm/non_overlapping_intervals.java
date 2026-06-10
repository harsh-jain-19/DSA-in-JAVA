// In this problem you will be given an array intervals.
// You have to return minimum number of intervals removed so, that their is no overlapping.

import java.util.*;
public class non_overlapping_intervals
{
    public static int remove_intervals(int intervals[][])
    {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int cnt = 1;
        int lastEndTime = intervals[0][1];
        for(int i = 0; i < intervals.length; i++)
        {
            if(intervals[i][0] >= lastEndTime)
            {
                cnt = cnt + 1;
                lastEndTime = intervals[i][1];
            }
        }
        return intervals.length - cnt;
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

        int result = remove_intervals(intervals);
        System.out.println("Minimum number of intervals removed to avoid overlapping = "+result);

        // PRINTING
        for(int i = 0; i < n; i++)
        {
            System.out.println("[ "+intervals[i][0]+" , "+intervals[i][1]+" ]");
        }
    }
}