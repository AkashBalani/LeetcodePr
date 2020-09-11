class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> indexesToRemove = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }
            if(s.charAt(i) == ')'){
                if(stack.isEmpty()){
                    indexesToRemove.add(i);
                }
                else{
                    stack.pop();
                }
            }
        }
        while(!stack.isEmpty()) indexesToRemove.add(stack.pop());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(!indexesToRemove.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}

class Solution1 {
    private StringBuilder removeInvalidCharacters(CharSequence s, char open, char close){
        StringBuilder sb = new StringBuilder();
        int balance = 0;
        for(int i= 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == open){
                balance++;
            }
            else if(c == close){
                if(balance == 0) continue;
                balance--;
            }
            sb.append(c);
        }
        return sb;
    }
    public String minRemoveToMakeValid(String s) {
        StringBuilder result = removeInvalidCharacters(s, '(', ')');
        result = removeInvalidCharacters(result.reverse(), ')', '(');
        return result.reverse().toString();
    }
}