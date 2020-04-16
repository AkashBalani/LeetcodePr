import java.util.Stack;


// Passed a few test cases
class Solution{
    public boolean checkValidString(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') stack.push(s.charAt(i));
            else if(s.charAt(i) == ')'){
                if(stack.search('(') == -1) return false;
                else stack.pop();
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}