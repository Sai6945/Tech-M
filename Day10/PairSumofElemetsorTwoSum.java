package Day10;
import java.util.HashSet;
public class PairSumofElemetsorTwoSum {
	public static void main(String[] args) {
        int arr[] = {1, 4, 9, 8, 25, 5, 12};
        int n = 13;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            int target = n - arr[i];
            if (set.contains(target)) {
                System.out.println(arr[i] + " " + target);
            }
            set.add(arr[i]);
        }
    }

}
