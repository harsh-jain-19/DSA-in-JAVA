import java.util.*;
public class all_divisor
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> l1 = new ArrayList<>();
        int n,a=0;
        System.out.println("Enter the number which you want to find all divisors");
        n = sc.nextInt();

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