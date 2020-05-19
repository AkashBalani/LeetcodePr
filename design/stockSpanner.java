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

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */