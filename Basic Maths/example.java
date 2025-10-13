import java.util.*;
public class example
{
    public static ArrayList<Integer> devisor(int n)
    {
        ArrayList<Integer> l1 = new ArrayList<>();
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
        return l1;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        int n1,n2,a=0;
        System.out.println("Enter the numbers you want to find HCF");
        n1 = sc.nextInt();
        n2 = sc.nextInt();
        l1 = devisor(n1);
        l2 = devisor(n2);
        System.out.println("All the devisor of "+n1+" are given below:-");
        System.out.println(l1);
        System.out.println("All the devisor of "+n2+" are given below:-");
        System.out.println(l2);
    }
}