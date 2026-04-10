// Monotonic Stack
// When we stores element in stack in some specific order then it is konwn as monotonic stack.

// Next Greater Element
// In this problem we will be given an array.
// We have to tell next greater element of all elements in array.
// If their is not a greater element in array return -1.

import java.util.*;
public class next_greater_element
{
    public static List<Integer> find_nge(int [] arr)
    {
        int n = arr.length;
        List<Integer> nge = new ArrayList<>();

        Stack<Integer> st = new Stack<>();
        for(int i = n-1; i >= 0; i--)
        {
            while(! st.isEmpty() && st.peek() <= arr[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                nge.add(-1);
            }
            else
            {
                nge.add(st.peek());
            }
            st.push(arr[i]);
        }
        nge = nge.reversed();
        return nge;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the size of your array.");
        n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the "+i+" element");
            arr[i] = sc.nextInt();
        }


        List<Integer> nge = new ArrayList<>();
        nge = find_nge(arr);

        // PRINTING
        for(int i = 0; i < n; i++)
        {
            if(i!=0)
            {
                System.out.print(","+arr[i]);
            }
            else
            {
                System.out.print(arr[i]);
            }
        }

        System.out.println("\n Next Greater Element of each element is given below:-");
        System.out.println(nge);
    }
}