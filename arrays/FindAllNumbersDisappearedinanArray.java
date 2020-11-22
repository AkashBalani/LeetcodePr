class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set set = new HashSet();
        int noOfElements = 0;
        for(int i : nums){
            if(!set.contains(i)){ //set -> {4,3,2,7,8,1}
                set.add(i);
            }
            noOfElements++;
            // System.out.println(noOfElements);
        }
        List<Integer> output = new ArrayList<>();
        for(int i = 1; i <= noOfElements; i++){
            if(!set.contains(i)){
                output.add(i);
            }
        }
        return output;
    }
}
