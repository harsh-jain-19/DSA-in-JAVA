import java.util.Scanner;
public class stock_buy_sell
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the size of an Array");
        n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the "+i+" element");
            arr[i] = sc.nextInt();
        }
        // DECIDING WHEN TO BUY AND SELL
        int min = arr[0],profit = 0,cost,buy=0,sell=0;
        for(int i = 1; i < n; i++)
        {
            cost = arr[i]-min;
            if(cost > profit)
            {
                profit = cost;
                sell = i+1;
            }
            if(arr[i] < min)
            {
                min = arr[i];
                buy = i+1;
            }
        }
        System.out.println("Maximum Profit Will be if we buy on "+buy+" and sell it on "+sell);
        System.out.println("Maximum Profit Will Be "+profit);
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