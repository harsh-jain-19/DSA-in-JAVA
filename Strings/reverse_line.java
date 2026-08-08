import java.util.*;
public class reverse_line
{
    public static String reverse_string(String s)
    {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;

        while(i >= 0)
        {
            while(i >= 0 && s.charAt(i) == ' ')
            {
                i--;
            }
            if(i < 0)
            {
                break;
            }
            int end = i;
            while(i >= 0 && s.charAt(i) != ' ')
            {
                i--;
            }
            String word = s.substring(i+1, end+1);
            if(sb.length() > 0)
            {
                sb.append(" ");
            }
            sb.append(word);
        }
        return sb.toString();
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the line you want to reverse.");
        String str = sc.nextLine();

        System.out.println("Line You Have Entered = "+str);

        String strr = reverse_string(str);
        System.out.println("Line after reversing it = "+strr);
    }
}