import java.util.Stack;

// Accepted Solution
class backspaceStringCompare{
    public boolean backspaceCompare(String S, String T){
        return build(S).equals(build(T));
    }

    public String build(String str){
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()){
            if(c != '#')
                stack.push(c);
            else if(!stack.isEmpty())
                stack.pop();
        }
        return String.valueOf(stack);
    }
}