// Brute Force
// Accepted Answer Using Set
// Space --> O(n) and Time --> O(n)
// Weird But beautiful

class Solution {
    public boolean containsDuplicate(int[] nums) {
        final Set<Integer> distinct = new HashSet<Integer>();
        for(int num : nums) {
            if(distinct.contains(num)) {
                return true;
            }
            distinct.add(num);
        }
        return false;
    }
}