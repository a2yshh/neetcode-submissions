public class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int n : nums){
            set.add(n);
        }
        int longest=0,res=0;
        for(int num : set){
            if(!set.contains(num-1)){
                res=1;
                while(set.contains(num+res)){
                    res++;
                }
                
            }
           longest=Math.max(longest,res); 
        }
        return longest;
    }
}