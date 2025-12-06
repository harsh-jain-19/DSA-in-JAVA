import java.util.*;
public class longest_consective
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
        // FINDING LONGEST CONSECTIVE SEQUENCE
        HashSet<Integer> mySet = new HashSet<>();
        int longest = 1, count = 0, x, y;
        for(int i = 0; i < n; i++)
        {
            mySet.add(arr[i]);
        }
        for(int i = 0; i < n; i++)
        {
            if(mySet.contains(arr[i]-1) == false)
            {
                count = 1;
                x = arr[i];
                while(mySet.contains(x+1))
                {
                    count++;
                    x = x+1;
                }
                if(longest < count )
                {
                    longest = count;
                }
            }
        }
        System.out.println("Longest Consective Sequence in Array is of Length "+longest);
        // PRINTIG
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