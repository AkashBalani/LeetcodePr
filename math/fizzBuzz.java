import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Accepted Solution
class Solution{
    public List<String> fizzBuzz(int n){
        List<String> res = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(i%3 == 0 && i%5 == 0) res.add("FizzBuzz");
            else if(i%3 == 0) res.add("Fizz");
            else if(i%5 == 0) res.add("Buzz");
            else{
                String str = Integer.toString(i);
                res.add(str);
            }
        }
        return res;
    }
}

// Accepted Solution
class Solution1{
    public List<String> fizzBuzz(int n){
        List<String> ans = new ArrayList<>();
        HashMap<Integer, String> map = new HashMap<>(){
            {
                put(3, "Fizz");
                put(5, "Buzz");
            }
        };

        for(int i = 1; i <= n; i++){
            String str = "";
            for(Integer key : map.keySet())
                if(i % key == 0) str += map.get(key);
            
            if(str.equals("")) str += Integer.toString(i);

            ans.add(str);
        }
        return ans;
    }
}