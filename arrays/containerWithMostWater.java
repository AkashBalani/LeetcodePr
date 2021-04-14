class Solution{
    public int maxArea(int[] height) {
        int area = 0, maxArea = 0;
        for(int i = 0; i < height.length - 1; i++){
            for(int j = i + 1; j < height.length; j++){
                area = Math.min(height[i], height[j]) * (j - i);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
}
// O(n^2)

class Solution1 {
    public int maxArea(int[] height) {
        int maxArea = 0, l = 0, r = height.length - 1;
        while(l < r){
            maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l));
            if(height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxArea;
    }
}

