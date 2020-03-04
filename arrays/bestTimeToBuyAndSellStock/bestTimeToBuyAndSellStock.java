// Cleared some Test cases with this one

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

// Accepted Solution
// Brute Force

public class Solution {
    public int maxProfit(int prices[]) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit)
                    maxprofit = profit;
            }
        }
        return maxprofit;
    }
}
