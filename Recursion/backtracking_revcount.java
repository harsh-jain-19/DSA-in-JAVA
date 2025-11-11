import java.util.Scanner;
public class backtracking_revcount
{
    public static void count(int i,int n)
    {
        if(i > n)
        {
            return ;
        }
        count(i+1,n);
        System.out.println(i);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n,i = 1;
        System.out.println("Enter the number from which you want reverse counting");
        n = sc.nextInt();
        count(i,n);    
    }
}