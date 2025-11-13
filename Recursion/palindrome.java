import java.util.Scanner;
public class palindrome
{
    public static String name;
    public static Boolean rev(int l)
    {
        int r;;
        r = (5)-l-1;
        if(l >= r)
        {
            return (true);
        }
        if(name.charAt(l) != name.charAt(r))
        {
            return (false);
        }
        return rev(l+1);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enetr the String you want to check is palindrome or not");
        name = sc.nextLine();
        int l = 0;
        System.out.println(rev(l));
    }
}