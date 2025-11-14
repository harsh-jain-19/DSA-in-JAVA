// Here a = 97 and z = 122 According to ASCII VALUE.
import java.util.Scanner;
public class small_char_appear
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int xyz = 'a';
        int xyzz = 'z';
        System.out.println(xyz);
        System.out.println(xyzz);
        // So, by this we can say that index of any small letter in array = Char-'a'
        // EXAMPLE
        System.out.println(xyzz-xyz+" is the index of z");
        String name;
        int x = 1;
        char p;
        int [] hasharr = new int[26];
        System.out.println("Enter the name in Lower Case");
        name = sc.nextLine();
        for(int i = 0; i < name.length(); i++)
        {
            hasharr[name.charAt(i)-'a']++;
        }
        while(x == 1)
        {
            System.out.println("Enter the alphabet of which you want to check Frequency in array");
            p = sc.next().charAt(0);
            System.out.println(p+" occurs "+hasharr[p-97]+" times in array");
            System.out.println("If you again want to check the ferquency of any alphabet then press 1");
            x = sc.nextInt();
        }
    }
}