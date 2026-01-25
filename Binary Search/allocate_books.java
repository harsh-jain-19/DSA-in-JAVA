// ALLOCATE BOOKS
// In this problem we will be given an array arr.
// arr will be containing the number of pages each book have.
// You will also be given an number of students as m.
// We have to distribute these books among the students In Such A Way That :-
// 1. Each Should Get Atleast One Book.
// 2. One Book Can Be Allocated To One Student Only.
// 3. Book Distribution Should Be Done In Contigious Manner.

// THE MAXIMUM NUMBER OF PAGES ASSINGNED TO ANY STUDENT IS MINIMUM.


import java.util.*;
public class allocate_books
{
    public static int max_element(int [] arr, int n)
    {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++)
        {
            if(arr[i] > max)
            {
                max = arr[i];
            }
        }
        return max;
    }
    public static int sum_array(int [] arr, int n)
    {
        int ans = 0;
        for(int i = 0; i < n; i++)
        {
            ans += arr[i];
        }
        return ans;
    }

    public static int count_student(int [] arr, int pages_allowed, int n)
    {
        int student = 1;
        int pagesST = 0;
        for(int i = 0; i < n; i++)
        {
            if((pagesST + arr[i]) <= pages_allowed)
            {
                pagesST += arr[i];
            }
            else
            {
                student++;
                pagesST = arr[i];
            }
        }
        return student;
    }

    public static int search(int [] arr, int n, int m)
    {
        if(m > n)
        {
            System.out.println("Number of students are then number of books.");
            return 0;
        }
        int low,high,mid;
        low = max_element(arr,n);
        high = sum_array(arr,n);
        while(low <= high)
        {
            mid = (low + high)/2;
            int cnt_student;
            cnt_student = count_student(arr,mid,n);
            if(cnt_student <= m)
            {
                high = mid-1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args)
    {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of books you have.");
        n = sc.nextInt();

        int [] arr = new int [n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the  number of pages "+i+" book have.");
            arr[i] = sc.nextInt();
        }

        // BINARY SEARCH
        int m;
        System.out.println("Enter the number of students.");
        m = sc.nextInt();
        int ans = search(arr,n,m);
        System.out.println("The Maximum Number Of Pages Assigned to Any Student Is Minimum = "+ans);

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
    }
}
