class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<Integer>(), k, n, 1);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int k, int remain, int start) {
        if(tempList.size() > k) return; /** no solution */
        else if(tempList.size() == k && remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for (int i = start; i <= 9; i++) {
                tempList.add(i);
                backtrack(list, tempList, k, remain-i, i+1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}

/*
    1. k = 3 and n = 7
    tempList -> [1, 2, 4]
    list -> [1, 2, 4]
    public List<List<Integer>> combinationSum3(3, 7)
        backtrack(list, new ArrayList<Integer>(), 3, 7, 1);
            if(tempList.size() > k) -> if(0 > 3) -> if(F)
            else if(tempList.size() == k && remain == 0) -> else if(0 == 3 && remain == 0) -> else if(F)
            else
                for(int i = 1; i<=9; i++)
                    tempList.add(1)
                    backtrack(list, tempList, k, remain-i, i+1) -> backtrack(list, [1], 3, 7-1, 1+1)
                    if(tempList.size() > k) -> if(1 > 3) -> if(F)
                    else if(1 == 3 && remain == 0) -> else if(F)
                    else
                        for(int i = 2; i<=9; i++)
                            tempList.add(2)
                            backtrack(list, tempList, k, remain-i, i+1) -> backtrack(list, tempList, 3, 6-2, 2+1)
                                if(tempList.size() > k) -> if(2 > 3) -> if(F)
                                else if(tempList.size() == k && remain == 0) -> else if(2 == 3 && ...) -> else if(F)
                                else
                                    for(int i = 4; i <= 9; i++)
                                        tempList.add(4)
                                        backtrack(list, tempList, k, remain-i, i+1) -> backtrack(list, tempList, 3, 4-4, 4+1)
                                            if(tempList.size() > k) -> if(3 > 3) -> if(F)
                                            else if(tempList.size() == k && remain == 0) -> else if(3 == 3 && 0 == 0) -> else if(T)
                                                list.add(new ArrayList<>(tempList))
                                        tempList.remove(tempList.size() - 1)
*/