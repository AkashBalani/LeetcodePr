class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        for(int i : nums) {
            if(i > lower) res.add(lower+((i-1 > lower)?"->"+(i-1):""));
            if(i == upper) return res; // Avoid overflow
            lower = i+1;
        }
        if(lower <= upper) res.add(lower + ((upper > lower)?"->"+(upper):""));
        return res;
    }
}

// nums[] = [0, 1, 3, 50, 75]
// lower = 0
// upper = 99
// res = {"2", "4->49", "51->74", "76->99"}
// for( 75 : nums)
//   if(75 > 51)
//     res.add("51->74")
//       74 > 51 ? "->74"
//   if(1 == 99) (F)
//   lower = 76
// if(76 <= 99)
//   res.add("76->99")
//     99 > 76 ? "->99"
// return res