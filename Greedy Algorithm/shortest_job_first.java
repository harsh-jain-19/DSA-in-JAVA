// In this problem you will be given an n processes.
// Duration of each process will be given to you.
// You have to return average waiting time of processes.

import java.util.*;
public class shortest_job_first
{
    public static int find(int arr[])
    {
        Arrays.sort(arr);
        int t,wt;
        t = wt = 0;
        for(int i = 0; j < arr.length; i++)
        {
            wt += t;
            t += arr[i];
        }
        
        return wt / arr.length;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the number of processes you have.");
        n = sc.nextInt();
        int [] arr = new int [n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the duration of "+i+" process.");
            arr[i] = sc.nextInt();
        }

        int avg_waiting_time = find(arr);
        System.out.println("Average waiting time of processes = "+avg_waiting_time);
        

        // PRINTING
        for(int i = 0; i < n; i++)
        {
            if(i!=0)
            {
                System.out.print(","+arr[i]);
            }
            else
            {
                System.out.print(arr[i]);
            }
        }
    }
}
