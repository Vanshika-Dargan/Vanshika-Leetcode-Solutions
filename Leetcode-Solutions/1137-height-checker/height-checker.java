class Solution {
    public int heightChecker(int[] heights) {
        
        int original[]=Arrays.copyOf(heights,heights.length);
        Arrays.sort(heights);
        int count=0;
        for(int i=0;i<heights.length;i++){
            System.out.println(heights[i]);
            System.out.println(original[i]);
            if(original[i]!=heights[i]) 
            count++;
        }
        return count;

    }
}