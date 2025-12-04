import java.util.Scanner;
public class next_permutation
{
    public static void rev(int [] arr, int l)
    {
        int temp,r;
        r = (arr.length)-l-1;
        if(l > r)
        {
            return;
        }
        temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        rev(arr,l+1);
    }
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
        // Printing
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

        // Finding Next Permutation
        int index=-1,temp;
        for(int i = n-2; i >= 0; i--)
        {
            if(arr[i] < arr[i+1])
            {
                index = i;
                break;
            }
        }
        if(index == -1)
        {
            rev(arr,0);
        }
        else
        {
            for(int i = n-1; i >= index; i--)
            {
                if(arr[i] > arr[index])
                {
                    temp = arr[i];
                    arr[i] = arr[index];
                    arr[index] = temp;
                    break;
                }
            }
            rev(arr,index+1);
        }

        // Printing
        System.out.println("\nNext Permutation");
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