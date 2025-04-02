package Day10;

public class MooreVoting {
	 public static int findMajorityElement(int[] nums) {
	        int candidate = 0, count = 0;

	        // Phase 1: Find a candidate
	        for (int num : nums) {
	            if (count == 0) {
	                candidate = num;
	            }
	            count += (num == candidate) ? 1 : -1;
	        }

	        // Phase 2: Verify the candidate
	        count = 0;
	        for (int num : nums) {
	            if (num == candidate) {
	                count++;
	            }
	        }

	        return (count > nums.length / 2) ? candidate : -1; // Return -1 if no majority element
	    }

	    public static void main(String[] args) {
	        int[] nums = {3, 3, 4, 2, 3, 3, 3, 2, 3};
	        int result = findMajorityElement(nums);
	        System.out.println("Majority Element: " + (result != -1 ? result : "None"));
	    }

}
