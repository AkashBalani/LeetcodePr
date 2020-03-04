class Solution {
    public int maxProfit(int[] prices) {
        int[] maxPrices = new int[prices.length];
        int min = 99;
        int max = -1; 
        int minIndex = 0;
        int maxIndex = 0;
        for(int i = 0; i < prices.length; i++){
            if(min > prices[i]){
                min = prices[i];
                minIndex = i;
                System.out.println("Min: " + min + " " + minIndex);
            }
            if(max < prices[i]){
                max = prices[i];
                maxIndex = i;
                System.out.println("Max: " + max + " " + maxIndex);
            }
            if(minIndex > maxIndex){
                max = -1;
                maxIndex = 0;
            }
        }
        if(minIndex < maxIndex){
            return max - min;
        }
        return 0;
    }
}
