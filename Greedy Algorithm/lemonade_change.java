// In this problem you have to assume that you are selling lemonades.
// You are selling one lemonade of 5$ and each customer is buying exactly one lemonade.
// Now you will be given an array bills containing demonstration(note) every coustomer have.
// Customer can have 5,10,20 $ demonstration, initially you have 0 demonstration.
// Now you have to return true if you can sell lemonade to every customer otherwise return false.

import java.util.Scanner;
public class lemonade_change
{
    public static boolean change_possible(int bills[])
    {
        int five,ten;
        five = ten = 0;
        for(int i = 0; i < bills.length; i++)
        {
            if(bills[i] == 5)
            {
                five++;
            }
            else if(bills[i] == 10)
            {
                if(five != 0)
                {
                    ten++;
                    five--;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                if(ten != 0 && five != 0)
                {
                    ten--;
                    five--;
                }
                else if(five >= 3)
                {
                    five = five - 3;
                }
                else 
                {
                    return false;
                }
            }
            
        }
        return true;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the number of customers you have.");
        n = sc.nextInt();
        int [] arr = new int [n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the demonstration of "+i+" customer.");
            arr[i] = sc.nextInt();
        }

        boolean change = change_possible(arr);
        if(change)
        {
            System.out.println("Yes you can sell lemonade to everyone.");
        }
        else
        {
            System.out.println("No you can not sell lemonade to everyone.");
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