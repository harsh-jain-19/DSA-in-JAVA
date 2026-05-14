// In this problem you will be given an two arrays.
// Array 1 greed showing the greed of every child.
// Array 2 s showing the size of each cookie.
// You can assign cookie to children if size of cookie is greter or equal to greed of child.
// You task is to assign maximum cookies to the children.
// You have to return number of children you satisfied.

import java.util.*;
public class assign_cookies
{
    public static int num_of_children_satisfied(int greed[], int s[])
    {
        int n,m;
        n = greed.length;
        m = s.length;
        int l = 0;
        int r = 0;

        Arrays.sort(greed);
        Arrays.sort(s);
        
        while(l < m)
        {
            if(greed[r] <= s[l])
            {
                r = r + 1;
            }
            l = l + 1;
        }
        return r;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n1,n2;
        System.out.println("Enter the number of children you have.");
        n1 = sc.nextInt();
        int [] greed = new int[n1];
        for(int i = 0; i < n1; i++)
        {
            System.out.println("Enter the greed of "+i+" child");
            greed[i] = sc.nextInt();
        }

        System.out.println("Enter the number of cookies you have.");
        n2 = sc.nextInt();
        int [] s = new int[n2];
        for(int i = 0; i < n2; i++)
        {
            System.out.println("Enter the size of "+i+" cookie.");
            s[i] = sc.nextInt();
        }

        int children_satisfied = num_of_children_satisfied(greed,s);
        System.out.println("Number of children satisfied = "+children_satisfied);

        System.out.println("Greed of children.");
        for(int i = 0; i < n1; i++)
        {
            if(i!=0)
            {
                System.out.print(","+greed[i]);
            }
            else
            {
                System.out.print(greed[i]);
            }
        }
        System.out.println("\nSize of cookies.");
        for(int i = 0; i < n2; i++)
        {
            if(i!=0)
            {
                System.out.print(","+s[i]);
            }
            else
            {
                System.out.print(s[i]);
            }
        }
    }
}