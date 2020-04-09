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

    public boolean backspaceCompare1(String S, String T){
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;
        while( i >= 0 || j >= 0){
            while( i >= 0){
                if(S.charAt(i) == '#'){skipS++; i--;}
                else if(skipS > 0){skipS--; i--;}
                else break;
            }
            while( j >= 0){
                if(S.charAt(j) == '#'){skipT++; j--;}
                else if(skipT > 0){skipT--; j--;}
                else break;
            }
            if(( i >= 0) && ( j >= 0) && S.charAt(i) != T.charAt(j))
                return false;
            if((i >= 0) != (j >= 0))
                return false;
            i--;
            j--;
        }
        return true;
    }
}