import java.util.*;
public class merge_overlapping_intervals
{
    public static void main(String[] args)
    {
        Vector<Vector<Integer>> arr = new Vector<>();
        Vector<Integer> row1 = new Vector<>(Arrays.asList(1, 2, 3));
        Vector<Integer> row2 = new Vector<>(Arrays.asList(4, 5, 6));
        Vector<Integer> row3 = new Vector<>(Arrays.asList(7, 8, 9));
        arr.add(row1);       
        arr.add(row2);
        arr.add(row3);
    }
}