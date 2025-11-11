import java.util.Scanner;
public class backtracking_sum
{
    // METHOD 1
    public static void count(int i, int sum)
    {
        if(i < 1)
        {
            System.out.println(sum);
            return ;
        }
        count(i-1,sum+i);
    }
    // METHOD 2
    public static int countt(int n)
    {
        if(n == 0)
        {
            return(0);
        }
        return (n+countt(n-1));
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n,sum = 0;
        System.out.println("Enter the number till which you want Sum");
        n = sc.nextInt();
        count(n,sum); 
        System.out.println(countt(n));   
    }
}