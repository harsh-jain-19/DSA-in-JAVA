// JOB SEQUENCING PROBLEM
// In this problem you will be given an array jobs.
// Jobs will be containing job_id, job_deadline, job_profit.
// You can perforn one job every day.
// You have only N days, N = maximum_deadline.
// You have to return maximum profit.

import java.util.*;
class Jobs
{
    int id,profit,deadline;
    Jobs(int id, int profit, int deadline)
    {
        this.id = id;
        this.profit = profit;
        this.deadline = deadline;
    }
}
public class job_sequencing
{
    public static boolean comparison(Jobs a, Jobs b) {
        // Return true if a's profit is greater than b's
        return a.profit > b.profit; 
    }
    public static int[] find_max_profit(Jobs arr[], int n)
    {
        // Sort the jobs by profit in descending order
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);

        int total_profit, cnt, maximum_deadline;
        total_profit = cnt = 0;
        maximum_deadline = 0;
        for(int i = 0; i < n; i++)
        {
            maximum_deadline = Math.max(maximum_deadline,arr[i].deadline);
        }

        // Create an array to store the slots for the jobs
        int[] slot = new int[maximum_deadline + 1];
        // Initialize all slots as unoccupied
        Arrays.fill(slot, -1);  

        for(int i = 0; i < n; i++)
        {
            for(int j = arr[i].deadline; j >= 0; j--)
            {
                if(slot[j] == -1)
                {
                    cnt++;
                    slot[j] = arr[i].id;
                    total_profit += arr[i].profit;
                    break;
                }
            }
        }
        return new int[]{cnt,total_profit};
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Jobs you have.");
        int n = sc.nextInt();
        Jobs [] arr = new Jobs[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter Job_Id");
            int id = sc.nextInt();
            System.out.println("Enter Job_Profit");
            int p = sc.nextInt();
            System.out.println("Enter Job_Deadline");
            int d = sc.nextInt();
            arr[i] = new Jobs(id,p,d);
        }

        int [] ans = find_max_profit(arr,n);
        System.out.println("Maximum Profit = "+ans[0]+" , "+ans[1]);

        for(int i = 0; i < n; i++)
        {
            System.out.println(arr[i].id+" , "+arr[i].profit+" , "+arr[i].deadline);
        }
    }
}
