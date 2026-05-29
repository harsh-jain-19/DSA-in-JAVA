// In this problem you will be given two arrays arrival and departure.
// Arrival will be representing arrival time of train.
// Departure will be representing departing time of train.
// You have to return minimum number of platforms requires for successful arrival and departure of trains.

import java.util.*;
public class min_num_of_platforms
{
    public static int min_platforms_required(int arrival[], int departure[])
    {
        Arrays.sort(arrival);
        Arrays.sort(departure);
        int i = 0;
        int j = 0;
        int cnt = 0;
        int max_cnt = 0;
        while(i < arrival.length)
        {
            if(arrival[i] <= departure[j])
            {
                cnt = cnt + 1;
                i++;
            }
            else
            {
                cnt = cnt - 1;
                j++;
            }
            max_cnt = Math.max(max_cnt,cnt);
        }
        return max_cnt;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the number of trains you have.");
        n = sc.nextInt();

        int [] arrival = new int[n];
        int [] departure = new int[n];

        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the arrival and departure time of "+i+" train");
            arrival[i] = sc.nextInt();
            departure[i] = sc.nextInt();
        }

        int min_platforms = min_platforms_required(arrival,departure);
        System.out.println("Minimum Number of Platforms Required = "+min_platforms);

        System.out.println("Train arrival Time");
        for(int i = 0; i < n; i++)
        {
            if(i!=0)
            {
                System.out.print(","+arrival[i]);
            }
            else
            {
                System.out.print(arrival[i]);
            }
        }
        System.out.println("\nTrain departing Time");
        for(int i = 0; i < n; i++)
        {
            if(i!=0)
            {
                System.out.print(","+departure[i]);
            }
            else
            {
                System.out.print(departure[i]);
            }
        }
    }
}