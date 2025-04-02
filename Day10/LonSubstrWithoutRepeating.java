package Day10;
import java.util.HashSet;

public class LonSubstrWithoutRepeating {
	public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        
        // Iterate over all possible substrings
        for (int i = 0; i < s.length(); i++) {
            HashSet<Character> seen = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (seen.contains(s.charAt(j))) {
                    break; // Stop if duplicate is found
                }
                seen.add(s.charAt(j));
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }
        
        return maxLength;
    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s1)); // Output: 3
        System.out.println(lengthOfLongestSubstring(s2)); // Output: 1
        System.out.println(lengthOfLongestSubstring(s3)); // Output: 3
    }
}
