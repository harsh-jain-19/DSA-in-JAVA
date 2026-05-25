// In this problem you have given an one meeting room which means you can only do one meeting at a time.
// You will also be given an N meetings with starting and ending times,
// Represented by two array start and end.
// You have to return maximum number of meetings you can do in single meeting room.

import java.util.*;
class data
{
    int start,end,pos;
    data(int startt, int endd, int poss)
    {
        this.start = startt;
        this.end = endd;
        this.pos = poss;
    }
}
public class n_meetings_in_one_room
{
    public static List<Integer> find_psbl_meetings(int start[], int end[])
    {
        int n = start.length;
        data[] arr = new data[n];
        for(int i = 0; i < n; i++)
        {
            arr[i] = new data(start[i], end[i], i+1);
        }

        // Sort according to ending time
        Arrays.sort(arr, (a, b) -> a.end - b.end);

        int cnt = 1;
        int freeTime = arr[0].end;
        List <Integer> ds = new ArrayList<>();
        ds.add(arr[0].pos);

        for(int i = 1; i < n; i++)
        {
            if(arr[i].start > freeTime)
            {
                cnt = cnt + 1;
                freeTime = arr[i].end;
                ds.add(arr[i].pos);
            }
        }

        return ds;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the number of meetings you have.");
        n = sc.nextInt();

        int [] start = new int[n];
        int [] end = new int[n];

        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the start and end time of "+i+" meeting");
            start[i] = sc.nextInt();
            end[i] = sc.nextInt();
        }

        List <Integer> psbl_meetings = new ArrayList<>();
        psbl_meetings = find_psbl_meetings(start,end);
        System.out.println("Position of Meetings you can do in single room = "+psbl_meetings);

        System.out.println("Meeting Starting Time");
        for(int i = 0; i < n; i++)
        {
            if(i!=0)
            {
                System.out.print(","+start[i]);
            }
            else
            {
                System.out.print(start[i]);
            }
        }
        System.out.println("\nMeeting Ending Time");
        for(int i = 0; i < n; i++)
        {
            if(i!=0)
            {
                System.out.print(","+end[i]);
            }
            else
            {
                System.out.print(end[i]);
            }
        }
    }
}