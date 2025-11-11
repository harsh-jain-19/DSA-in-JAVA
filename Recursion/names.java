import java.util.Scanner;
public class names
{
    public static int i = 1;
    public static void printn(String name, int n)
    {
        if(i <= n)
        {
            System.out.println(name);
            i++;
            printn(name,n);
        }
    }
    public static void main(String[] arsg)
    {
        Scanner sc = new Scanner(System.in);
        int n;
        String name;
        System.out.println("Enter your name");
        name = sc.nextLine();
        System.out.println("Enter how many times you want to print name.");
        n = sc.nextInt();
        printn(name,n);
    }
}