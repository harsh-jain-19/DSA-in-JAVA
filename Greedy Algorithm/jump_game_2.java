// In this problem you will be given an array.
// Each Element is representing it's jumping length.
// You have to tell the minimum jumps required to reach end.
import java.util.Scanner;
public class jump_game_2
{
    public static int reach_jumps(int nums[])
    {
        int n = nums.length;
        int jumps,l,r;
        jumps = l = r = 0;
        while(r < n-1)
        {
            int farthest = 0;
            for(int i = l; i <= r; i++)
            {
                farthest = Math.max(farthest,nums[i]+i);
            }
            l = r + 1;
            r = farthest;
            jumps = jumps + 1;
        }
        return jumps;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the number of elements you have.");
        n = sc.nextInt();
        int [] arr = new int [n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the jump length of "+i+" element.");
            arr[i] = sc.nextInt();
        }

        int min_jumps = reach_jumps(arr);
        System.out.println("Minimum Jumps Required To Reach End = "+min_jumps);
        

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
