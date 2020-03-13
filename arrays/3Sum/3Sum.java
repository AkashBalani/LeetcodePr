// Accepted Solution

class Solution {
	public List<List<Integer>> threeSum(int[] nums){
		Set<List<Integer>> ans = new HashSet<>(); // We use Set here so that we don't need to remove duplicates
		if(nums.length==0) return new ArrayList<>(ans);
		Arrays.sort(nums);
		for(int i = 0; i < nums.length-2; i++){
			int j = i + 1;
			int k = nums.length - 1;
			while(j < k){
				int sum = nums[i] + nums[j] + nums[k];
				if(sum == 0){
					ans.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
				}
				else if (sum>0) k--;
				else if (sum<0) j++;
			}
		}
		return new ArrayList<>(ans);
	}
}
