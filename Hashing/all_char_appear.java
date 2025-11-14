import java.util.Scanner;
public class all_char_appear
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String name;
        int x = 1;
        char p;
        int [] hasharr = new int[256];
        System.out.println("Enter the name");
        name = sc.nextLine();
        for(int i = 0; i < name.length(); i++)
        {
            hasharr[name.charAt(i)]++;
        }
        while(x == 1)
        {
            System.out.println("Enter the alphabet of which you want to check Frequency in array");
            p = sc.next().charAt(0);
            System.out.println(p+" occurs "+hasharr[p]+" times in array");
            System.out.println("If you again want to check the ferquency of any alphabet then press 1");
            x = sc.nextInt();
        }
    }
}