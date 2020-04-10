import java.util.ArrayList;
import java.util.List;

class Solution2{
    List<Integer> list;
    public Solution2(){
         list = new ArrayList<>();
    }
    public void push(int x){
        list.add(x);
    }
    public void pop(){
        int index = list.size() - 1;
        list.remove(index);
    }
    public int top(){
        int index = list.size() - 1;
        return list.get(index);
    }
    public int getMin(){
        int index = list.size() - 1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < index; i++){
            if(list.get(i) < min) min = list.get(i);
        }
        return min;
    }    
}