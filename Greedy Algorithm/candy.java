// In this problem you will be given an array containg children rating.
// You have to distribte candies to the children.
// NOTE
// Each children should have atleast one candy.
// Child with higher rating should have more candies then its nebhiour child.
// You have to return total number of candies required.

import java.util.*;
public class candy
{
    public static int candy_req(int ratings[])
    {
        int sum = 1, i = 1;
        while(i < ratings.length)
        {
            if(ratings[i] == ratings[i-1])
            {
                sum += 1;
                i++;
                continue;
            }
            int peak = 1;
            while(i < ratings.length && (ratings[i] > ratings[i-1]))
            {
                peak += 1;
                sum = sum + peak;
                i++;
            }
            int down = 1;
            while(i < ratings.length && ratings[i] < ratings[i-1])
            {
                sum += down;
                i++;
                down++;
            }
            if(down > peak)
            {
                sum += down - peak;
            }
        }
        return sum;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the number of children you have.");
        n = sc.nextInt();
        int [] arr = new int [n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the rating of "+i+" child.");
            arr[i] = sc.nextInt();
        }

        int min_candy = candy_req(arr);
        System.out.println("Minimum Candies Required = "+min_candy);
        

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
