// In this we will be given an devidend and divisor.
// We have to devide a integer without using devide operator.
import java.util.*;
public class devide
{
    public static int devidee(int devidend, int devisor)
    {
        if(devidend == devisor)
        {
            return 1;
        }
        boolean sign = true;
        if(devidend >= 0 && devisor < 0)
        {
            sign = false;
        }
        if(devidend < 0 && devisor > 0)
        {
            sign = false;
        }
        int n = Math.abs(devidend);
        int d = Math.abs(devisor);
        int ans = 0;
        while(n >= d)
        {
            int cnt = 0;
            while(n >= (d << (cnt+1)))
            {
                cnt++;
            }
            ans += (1 << cnt);
            n = n - (d * (1 << cnt));
        }
        return sign? ans:(-1*ans);
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int devidend,devisor;
        System.out.println("Enter the devidend.");
        devidend = sc.nextInt();
        System.out.println("Enter the devisor.");
        devisor = sc.nextInt();

        int ans = devidee(devidend,devisor);
        System.out.println(devidend+" / "+devisor+" = "+ans);
    }
}