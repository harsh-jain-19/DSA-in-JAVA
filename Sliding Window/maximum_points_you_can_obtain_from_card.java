// In this problem you will be given an array showing points of each card.
// You will also be given an integer k telling number of cards you can pick.
// You have to return the maximum points you can make by selecting k cards.
// But their is a condition, that you can select cards either from starting or from
// ending or from starting and ending both but not from middle.
// Also you can select the consective cards either from begining or from ending.

import java.util.Scanner;
public class maximum_points_you_can_obtain_from_card
{
    public static int max_score(int nums[], int k)
    {
        int lsum,rsum,tsum;
        lsum = rsum = tsum = 0;
        for(int i = 0; i < k; i++)
        {
            lsum = lsum + nums[i];
        }
        tsum = lsum;
        for(int i = k-1, rindex = nums.length - 1; i >= 0; i--,rindex--)
        {
            lsum = lsum - nums[i];
            rsum = rsum + nums[rindex];
            tsum = Math.max(tsum, (lsum+rsum));
        }
        return tsum;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the number of cards you have.");
        n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the point of "+i+" card.");
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the number of cards you can select.");
        int k = sc.nextInt();

        int maxScore= max_score(arr,k);
        System.out.println("Maximum points you can have by selecting "+k+" cards = "+maxScore);

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