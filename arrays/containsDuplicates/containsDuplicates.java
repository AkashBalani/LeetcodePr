import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Given an array of integers find if it contains any duplicates

// INPUT: [1,2,3,1]
// OUTPUT: true

// Accepted Answer Using Set
// Space --> O(n) and Time --> O(n)
// Weird But beautiful

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        return Arrays.stream(nums).anyMatch(num -> !seen.add(num));
        // .stream method would convert the array to a continuous stream to be used by other number
        // It would sort of make the whole input into a string
        // anyMatch() would check the input stream against the given predicate condition
        // Additional Note: This is a short-circuiting operation meaning that it can give output even if the input is infinite
    }
}

// Accepted easier solution
class Solution1 {
    public boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>(nums.length);
    for (int x: nums) {
        if (set.contains(x)) return true;
        set.add(x);
        }
    return false;
    }
}

// Accepted Solution
// Not as elegant as the ones before it
class Solution2 {
    public boolean containsDuplicate(int[] nums){
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i]  == nums[i+1]) return true;
        }
        return false;
    }
}
