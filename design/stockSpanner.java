import java.util.Stack;

class StockSpanner {
    Map<Integer, Integer> map;
    public StockSpanner() {
        map = new HashMap();
    }
    
    public int next(int price) {
        if(map.size() == 0){
            map.put(price, 1);
            return 1;
        }
        else{
            int current = 1;
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                if(entry.getKey() < price){
                    System.out.println(price + " " + entry.getKey() + " " + current);
                    current += 1;
                }
            }
            map.put(price, current);
            return current;
        }
    }
}

class StockSpanner1{
    Stack <Integer> prices, weights;
    public StockSpanner1(){
        prices = new Stack<>();
        weights = new Stack<>();
    }

    public int next(int price){
        int current = 1;
        while(!prices.isEmpty() && prices.peek() <= price){
            prices.pop();
            current += weights.pop();
        }
        prices.push(price);
        weights.push(current);
        return current;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */