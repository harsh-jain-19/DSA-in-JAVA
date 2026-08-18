// In this question you will be given an string s and string goal.
// You have to return true if string s can be converted into goal after some shifts.

import java.util.*;
public class rotate_string
{
    public static boolean rotate(String s, String goal)
    {
        if(s.length() != goal.length())
        {
            return false;
        }
        String doubleS = s + s;

        return doubleS.contains(goal);
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string s.");;
        String s = sc.nextLine();

        System.out.println("Enter the string goal.");;
        String goal = sc.nextLine();

        boolean check = rotate(s,goal);
        if(check)
        {
            System.out.println("s can be converted into goal by some rotation.");
        }       
        else
        {
            System.out.println("s can not be converted into goal by some rotation.");
        } 
    }
}