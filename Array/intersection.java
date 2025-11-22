import java.util.*;
public class intersection
{
    public static void main(String[] args)
    {
        // FOR DOING THE INTERSECTION OF TWO ARRAY BOTH ARRAYS SHOULD BE SORTED.
        // SO, WE WILL BE TAKING ONLY SORTED ARRAY.
        Scanner sc = new Scanner(System.in);
        int n1,n2,x=0,y=0;

        System.out.println("Enter the size of an Array1");
        n1 = sc.nextInt();
        System.out.println("Enter the size of an Array2");
        n2 = sc.nextInt();

        int [] arr1 = new int[n1];
        int [] arr2 = new int[n2];
        ArrayList<Integer> intersec = new ArrayList<>(n1+n2);

        for(int i = 0; i < n1; i++)
        {
            System.out.println("Enter the "+i+" element");
            arr1[i] = sc.nextInt();
        }
        for(int i = 0; i < n2; i++)
        {
            System.out.println("Enter the "+i+" element");
            arr2[i] = sc.nextInt();
        }

        for(int i = 0; i < n1; i++)
        {
            if(i!=0)
            {
                System.out.print(","+arr1[i]);
            }
            else
            {
                System.out.print(arr1[i]);
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
        while(x < n1 && y < n2)
        {
            if(arr1[x] == arr2[y])
            {
                intersec.add(arr1[x]);
                x++;
                y++;
            }
            else if(arr1[x] < arr2[y])
            {
                x++;
            }
            else if(arr2[y] < arr1[x])
            {
                y++;
            }
        }
        System.out.println("\nIntersection of Array1 And Array2 is");
        for(int element:intersec)
        {
            System.out.println(element);
        }
    }
}