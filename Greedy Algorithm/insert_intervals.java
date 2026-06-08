// In this problem you will be given an array interval containing some intervals;
// You will also be given an array new_interval.
// You have to insert new_interval in interval such that their is no overlapping.
// NOTE: interval array is sorted and non-overlapping.

import java.util.Scanner;
class inter
{
    int start,end;
    inter(int start, int end)
    {
        this.start = start;
        this.end = end;
    }
}
public class insert_intervals
{
    public static inter[] insert(inter[] intervals, inter new_interval, int n)
    {
        inter [] final_intervals = new inter[n+1];
        int i = 0;
        int k = 0;
        while( i < n && intervals[i].end < new_interval.start)
        {
            final_intervals[k++] = intervals[i];
            i++;
        }
        while(i < n && intervals[i].start <= new_interval.end)
        {
            new_interval.start = Math.min(new_interval.start, intervals[i].start);
            new_interval.end = Math.max(new_interval.end, intervals[i].end);
            i++;
        }
        final_intervals[k++] = new_interval;
        while(i < n)
        {
            final_intervals[k++] = intervals[i];
            i++;
        }
        inter[] result = new inter[k];

        for(i = 0; i < k; i++)
        {
            result[i] = final_intervals[i];
        }
        return result;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the number of intervals you have.");
        n = sc.nextInt();
        inter [] intervals = new inter[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the start point of interval "+i);
            int s = sc.nextInt();
            System.out.println("Enter the end point of interval "+i);
            int e = sc.nextInt();
            intervals[i] = new inter(s,e);
        }
        System.out.println("Enter new interval start point you want to insert.");
        int new_s = sc.nextInt();
        System.out.println("Enter new interval end point you want to insert.");
        int new_e = sc.nextInt();

        inter new_interval = new inter(new_s,new_e);
        
        // PRINTING
        System.out.println("Intervals before inserting new interval.");
        for(int i = 0; i < n; i++)
        {
            System.out.println(" ( "+intervals[i].start+","+intervals[i].end+" ) ");
        }
        System.out.println("Interval to be inserted.");
        System.out.println(" ( "+new_interval.start+","+new_interval.end+" ) ");

        inter [] final_intervals = insert(intervals,new_interval,n);
        System.out.println("Intervals after inserting new interval.");
        for(int i = 0; i < final_intervals.length; i++)
        {
            System.out.println(" ( "+final_intervals[i].start+","+final_intervals[i].end+" ) ");
        }
    }
}