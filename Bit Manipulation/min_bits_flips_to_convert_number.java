// In this we will be given a start and goal.
// We have to tell minimum number of bits to convert start to goal.
import java.util.Scanner;
public class min_bits_flips_to_convert_number
{
    public static int count(int x)
    {
        int cnt = 0;
        while(x != 0)
        {
            x = x & (x - 1);
            cnt++;
        }
        return cnt;
    }
    
    public static int flips(int start, int goal)
    {
        int ans = start^goal;
        int cnt = count(ans);
        return cnt;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int start,goal;
        System.out.println("Enter the start number.");
        start = sc.nextInt();
        System.out.println("Enter the goal number.");
        goal = sc.nextInt();
        int x = flips(start,goal);
        System.out.println("Minimum number of bits flip to convert start into goal = "+x);
    }
}