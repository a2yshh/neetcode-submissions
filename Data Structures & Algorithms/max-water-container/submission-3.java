class Solution {
    public int maxArea(int[] heights) {
        int l=0, area=0, maxarea=0;
        int r=heights.length-1;
        while(l<r){
            int heightMin=Math.min(heights[l],heights[r]);
            area=heightMin*(r-l);
            maxarea=Math.max(maxarea,area);
            if(heights[l]<heights[r]){
                l++;
            }else{
                r--;
            }
            
        }
        return maxarea;
    }
}
