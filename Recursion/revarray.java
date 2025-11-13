import java.util.Scanner;
public class revarray
{
    public static int [] arr = new int[5];
    // Using two pointers.
    public static void rev(int l, int r)
    {
        if(l >= r)
        {
            return;
        }
        int i;
        i = arr[r];
        arr[r] = arr[l];
        arr[l] = i;
        rev(l+1,r-1);
    }
    // Using Single Pointer
    public static void rev(int l)
    {
        int i,r;
        r = (arr.length)-l-1;
        if(l >= r)
        {
            return;
        }
        i = arr[r];
        arr[r] = arr[l];
        arr[l] = i;
        rev(l+1);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);;
        System.out.println("Enter the elements of array");
        for(int i = 0; i < 5; i++)
        {
            arr[i] = sc.nextInt();
        }
        int l,r;
        l = 0;
        r = arr.length-1;
        rev(l,r);
        System.out.println(" ");
        for(int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }
        rev(l);
        System.out.println(" ");
        for(int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }
    }
}