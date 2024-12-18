class Solution {
    public int[] finalPrices(int[] prices) {
        int n= prices.length;
        Stack<Integer> stack = new Stack<>();

       
        int ans[]=new int[n];

        for(int i=n-1;i>=0;i--){
        while(!stack.isEmpty() && stack.peek() > prices[i]){
         stack.pop();
        }
        if(stack.isEmpty()) {
            ans[i]=prices[i];
        }
        else{
        ans[i]=prices[i]-stack.peek();
        }
         stack.push(prices[i]);
        
        }
        return ans;

    }
}