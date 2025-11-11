import java.util.Scanner;
public class revcounting
{
    public static long n = 1;
    public static int count(int a)
    {
        
        if(n<=a)
        {
            System.out.println(a);
            a--;
            count(a);
        }
        return 0;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int a;
        System.out.println("Enter the number from which you want reverse counting");
        a = sc.nextInt();
        count(a);
    }
}