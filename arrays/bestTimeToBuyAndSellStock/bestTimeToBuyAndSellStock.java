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

// Accepted Solution
// One pass Solution
// This solution works on the basis of calculating the highest peak and lowest crest

public class Solution {
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}

// Accpeted Solution
// Based on the Kadane's Algorithm
// Can be used for Negative numbers

public class Solution {
    public int maxProfit(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}


