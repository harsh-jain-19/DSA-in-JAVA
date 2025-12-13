import java.util.Scanner;
public class majority_n3
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
        // FINDING MAJORITY ELEMENT BIGGER THEN N/3
        int count1 = 0, el1 = 0, count3 = 0;
        int count2 = 0, el2 = 0, count4 = 0;

        for(int i = 0; i < n; i++)
        {
            if(count1 == 0 && arr[i] != el2)
            {
                count1++;
                el1 = arr[i];
            }
            else if(count2 == 0 && arr[i] != el1)
            {
                count2++;
                el2 = arr[i];
            }
            else if(arr[i] == el1)
            {
                count1++;
            }
            else if(arr[i] == el2)
            {
                count2++;
            }
            else
            {
                count1--;
                count2--;
            }
        }
        for(int i = 0; i < n; i++)
        {
            if(arr[i] == el1)
            {
                count3++;
            }
            else if(arr[i] == el2)
            {
                count4++;
            }
        }
        if(count3 > n/3)
        {
            System.out.println(el1+" appears more then the size of one-third array.");
        }
        if(count4 > n/3)
        {
            System.out.println(el2+" appears more then the size of one-third array.");
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