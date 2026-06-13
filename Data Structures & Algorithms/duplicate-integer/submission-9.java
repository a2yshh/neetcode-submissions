public class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> uniqueNumbers = new HashSet<>();
    
            for(int num : nums){
              if(uniqueNumbers.contains(num)){
                return true;
              }else{
                uniqueNumbers.add(num);
                
              }
        }
        return false;
    }
}