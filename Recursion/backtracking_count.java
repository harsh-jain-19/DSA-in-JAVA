import java.util.Scanner;
public class backtracking_count
{
    public static void count(int i)
    {
        if(i < 1)
        {
            return ;
        }
        count(i-1);
        System.out.println(i);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the number till which you want counting");
        n = sc.nextInt();
        count(n);    
    }
}