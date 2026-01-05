// MINIMUM DAYS TO FORM M BOUQUETS
// According to this problem we will be given an array Bloom.
// Bloom describes number of days taken by flower to bloom.
// We will be given a number of bouquets we have to made as m.
// We will be given a number of flower sholud be their in bouquet as k.
// TIME COMPLEXITY = O(log n)
import java.util.Scanner;
public class minimum_days_to_form_m_bouquets
{
    public static int max_element(int [] arr, int n)
    {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++)
        {
            if(arr[i] > max)
            {
                max = arr[i];
            }
        }
        return max;
    }
    public static int min_element(int [] arr, int n)
    {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++)
        {
            if(arr[i] < min)
            {
                min = arr[i];
            }
        }
        return min;
    }
    public static int search(int [] blooms, int n, int m, int k)
    {
        if((m*k) > n)
        {
            return -1;
        }

        int low,high,mid=0,ans=0;
        low = min_element(blooms,n);
        high = max_element(blooms,n);

        while(low <= high)
        {
            mid = (low + high)/2;
            int number_of_bouqets = 0;
            int flower = 0;
            for(int i = 0; i < n; i++)
            {
                if(blooms[i] <= mid)
                {
                    flower++;
                    if(flower == k)
                    {
                        number_of_bouqets = number_of_bouqets + 1;
                        flower = 0;
                    }
                }
                else
                {
                    flower = 0;
                }
            }
            if(number_of_bouqets == m)
            {
                ans = mid;
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }

        return ans;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n; // Size of array.
        System.out.println("Enter the number of flower you have.");
        n = sc.nextInt();

        int [] blooms = new int [n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the number of days flower at "+i+" will take to bloom");
            blooms[i] = sc.nextInt();
        }

        int m;
        System.out.println("Enter the number of bouquets you want to form.");
        m = sc.nextInt();

        int k;
        System.out.println("Enter the number of consective flowers each bouqet should have.");
        k = sc.nextInt();

        // BINARY SEARCH

        int ans = search(blooms,n,m,k);
        if(ans == -1)
        {
            System.out.println("You Don't Have Enough Flowers.");
        }
        else
        {
            System.out.println("Minimum number of days to make m banquets = "+ans);
        }

        // PRINTING
        for(int i = 0; i < n; i++)
        {
            if(i!=0)
            {
                System.out.print(","+blooms[i]);
            }
            else
            {
                System.out.print(blooms[i]);
            }
        }
    }
}