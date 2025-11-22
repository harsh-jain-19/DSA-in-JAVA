// Time Complexity = O(n1 + n2)
import java.util.*;
public class union
{
    public static void main(String[] args)
    {
        // FOR DOING THE UNION OF TWO ARRAY BOTH ARRAYS SHOULD BE SORTED.
        // SO, WE WILL BE TAKING ONLY SORTED ARRAY.
        Scanner sc = new Scanner(System.in);
        int n,n2,i1=0,j=0,k=0;
        System.out.println("Enter the size of an Array");
        n = sc.nextInt();
        System.out.println("Enter the size of an Array2");
        n2 = sc.nextInt();
        int [] arr = new int[n];
        int [] arr2 = new int[n2];
        ArrayList<Integer> unionn = new ArrayList<>(n+n2);
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the "+i+" element");
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i < n2; i++)
        {
            System.out.println("Enter the "+i+" element");
            arr2[i] = sc.nextInt();
        }
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
        for(int i = 0; i < n2; i++)
        {
            if(i!=0)
            {
                System.out.print(","+arr2[i]);
            }
            else
            {
                System.out.print("\n"+arr2[i]);
            }
        }
        while(i1 < n && j < n2)
        {
            if(arr[i1] <= arr2[j])
            {
                if(unionn.size() == 0 || unionn.getLast() != arr[i1])
                {
                    unionn.add(arr[i1]);
                }
                i1++;
            }
            else
            {
                if(unionn.size() == 0 || unionn.getLast() != arr2[j])
                {
                    unionn.add(arr2[j]);
                }
                j++;
            }
        }
        while(i1 < n)
        {
            if(unionn.size() == 0 || unionn.getLast() != arr[i1])
            {
                unionn.add(arr[i1]);
            }
            i1++;
            
        }
        while(j < n2)
        {
            if(unionn.size() == 0 || unionn.getLast() != arr2[j])
            {
                unionn.add(arr2[j]);
            }
            j++;
        }
        System.out.println("Union of Arr And Arr2 is ");
        for(int element : unionn)
        {
            System.out.println(element);
        }
    }
}