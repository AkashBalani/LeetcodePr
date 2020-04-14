// Passed some testcases

class Solution2 {
    public String stringShift(String s, int[][] shift) {
        int totalShift = 0;
        for(int i = 0; i < shift.length; i++){
            int direction = shift[i][0];
            int amount = shift[i][1];
            if(direction == 0){
                totalShift += amount;
            }
            else{
                totalShift -= amount;
            }
        }
        if(totalShift < 0){
            totalShift %= s.length();
            String ans = s.substring(totalShift) + s.substring(0,totalShift);
            return ans;
        }
        else if(totalShift > 0){
            totalShift = Math.abs(totalShift) % s.length();
            String ans = s.substring(s.length() - totalShift) + s.substring(0,s.length() - totalShift);
            return ans;
        }
        return s;
    }
}