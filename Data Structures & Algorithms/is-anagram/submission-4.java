class Solution {
    public boolean isAnagram(String s, String t) {
      if(s.length() != t.length()){
        return false;
      }
      HashMap<Character, Integer> countS = new HashMap<>();
      HashMap<Character, Integer> countT = new HashMap<>();
      for(int i=0; i<s.length() ; i++){
        char charS = s.charAt(i);
        char charT = t.charAt(i);
        if(countS.containsKey(charS)){
            countS.put(charS,countS.get(charS)+1);
        }else{
            countS.put(charS,1);
        }
        if(countT.containsKey(charT)){
            countT.put(charT,countT.get(charT)+1);
        }else{
            countT.put(charT,1);
        }
        
      }
      return countS.equals(countT);
    }
}
