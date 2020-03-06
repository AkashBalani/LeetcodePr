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
    }
}
