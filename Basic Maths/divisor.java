import java.util.*;
public class divisor
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> l1 = new ArrayList<>();
        int n,a=0;
        System.out.println("Enter the number which you want to find all divisors");
        n = sc.nextInt();
        // for(int i = 1; i <= n; i++)
        // {
        //     if(n % i == 0)
        //     {
        //         System.out.println(i+" devides "+n);
        //         a++;
        //     }
        // }
        // System.out.println("Total "+a+" numbers devides "+n);
        // WE WILL NOT USE THIS METHOD
        // Because its time complexity is of O(n).

        // HERE i*i is a way of representing square root of n.

        for(int i = 1; i*i <= n; i++)
        {
            if(n%i==0)
            {
                l1.add(i);
                if(n/i!=i)
                {
                    l1.add(n/i);
                }
            }
        }
        Collections.sort(l1);
        System.out.println("All the devisor of "+n+" are given below:-");
        System.out.println(l1);
    }
}