class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> output_arr = new ArrayList<>();
        backtrack(output_arr, "", 0, 0, n);
        return output_arr;
    }
    public void backtrack(List<String> output_arr, String curr_string, int open, int close, int max){
        if(curr_string.length() == max * 2){
            output_arr.add(curr_string);
            return;
        }
        if(open < max) backtrack(output_arr, curr_string + "(", open + 1, close, max);
        if(close < open) backtrack(output_arr, curr_string + ")", open, close + 1, max);
    }
}

class Solution1 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }
    
    public void backtrack(List<String> list, String str, int open, int close, int max){
        
        if(str.length() == max*2){
            list.add(str);
            return;
        }
        
        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }
}