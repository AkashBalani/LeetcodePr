class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i+1);
            tempList.remove(tempList.size() - 1);
        }
    }
}

/*
    nums = [1, 2, 3]
    tempList -> [1, 2]
    start = 1
    list -> [ [] , [1] , [1, 2]]
    backtrack(list, tempList, nums, start)
        for(int i = 0; i < 3; i++)
            tempList.add(nums[i]) -> tempList.add(1)
            backtrack(list, tempList, nums, 1)
                list.add(tempList)
                for(int i = 1; i < 3; i++)
                    tempList.add(nums[i]) -> tempList.add(2)
                    backtrack(list, tempList, nums, 2)
*/