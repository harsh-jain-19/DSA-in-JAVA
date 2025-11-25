import java.util.Scanner;
public class missing_num
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n,temp;
        System.out.println("Enter the Size Of An Array");
        n = sc.nextInt();
        int [] arr = new int[n];
        // TAKING INPUT
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the "+i+" element");
            arr[i] = sc.nextInt();
        }
        // FINDING MISSING ELEMENT WE WILL BE USING XOR FOR OPTIMAL SOLUTION
        int XOR1 = 0,XOR2 = 0;
        for(int i = 1; i <= n; i++)
        {
            XOR1 = XOR1^i;
        }
        for(int i = 0; i < n; i++)
        {
            XOR2 = XOR2^arr[i];
        }
        temp = XOR1 ^ XOR2;
        System.out.println("Missing elements are "+temp);
        // PRINTING ARRAY
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