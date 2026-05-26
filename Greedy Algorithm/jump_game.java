// In this problem you will be given an array.
// Each Element is representing it's jumping length.
// You have to tell that first element can reach last element by jumping or not.

import java.util.Scanner;
public class jump_game
{
    public static boolean reach_possible(int jump[])
    {
        int n = jump.length;
        int max_index = 0;
        for(int i = 0; i < n; i++)
        {
            if(i > max_index)
            {
                return false;
            }
            max_index = Math.max(max_index, jump[i]+i);
        }
        if(max_index >= n - 1)
        {
            return true;
        }
        else
        {
            return false;
        }
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

        boolean reach_or_not = reach_possible(arr);
        if(reach_or_not)
        {
            System.out.println("Yes you can reach to last element.");
        }
        else
        {
            System.out.println("No you can not reach to last element.");
        }

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