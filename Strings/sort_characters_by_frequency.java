import java.util.*;
public class sort_characters_by_frequency
{
    public static String sort_characters(String s)
    {
        StringBuilder sb = new StringBuilder();
        List<Character> [] arr = new ArrayList[s.length()+1];

        Map<Character,Integer> mpp = new HashMap<>();
        for(char c : s.toCharArray())
        {
            mpp.put(c,mpp.getOrDefault(c,0) + 1);
        }
        mpp.keySet().forEach(
            c -> {
                if(arr[mpp.get(c)] == null)
                {
                    arr[mpp.get(c)] = new ArrayList();
                }
                arr[mpp.get(c)].add(c);
            }
        );

        for(int i = arr.length - 1; i > 0; i--)
        {
            if(arr[i] != null)
            {
                for(Character c : arr[i])
                {
                    for(int j = 0; j < i; j++)
                    {
                        sb.append(c);
                    }
                    
                }
            }
        }
        return sb.toString();
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string which you want to sort.");
        String str = sc.nextLine();

        System.out.println("String You Have Entered = "+str);

        String strr = sort_characters(str);
        System.out.println("String after sorting it by character frequency = "+strr);
    }
}