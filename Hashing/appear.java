import java.util.Scanner;
public class appear
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n,a,x=1,y;
        System.out.println("Enter the size of Array");
        n = sc.nextInt();
        int [] arr = new int [n];
        System.out.println("Enter the Biggest Element of your Array");
        y = sc.nextInt();
        int [] hasharr = new int [y+1];
        System.out.println("Enter the elements of an Array");
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the "+i+" element");
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++)
        {
            hasharr[arr[i]]++;
        }
        while(x == 1)
        {
            System.out.println("Enter the number of which you want to check Frequency in array");
            a = sc.nextInt();
            System.out.println(a+" occurs "+hasharr[a]+" times in array");
            System.out.println("If you again want to check the ferquency of any number then press 1");
            x = sc.nextInt();

        }
    }
}