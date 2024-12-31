class Solution {
    
  
    public int mincostTickets(int[] days, int[] costs) {

       int dp[] = new int[days.length+1];
       Arrays.fill(dp,-1);
       return helper(days,costs,0,dp);
    }


    int helper(int[] days,int[] costs,int i,int[] dp){
    
    if(i==days.length) return 0;
    if (dp[i]!=-1) return dp[i];
    int next = i;
    next=nextIndex(days,i,0);
    int cost_1=costs[0] + helper(days,costs,next,dp);
     next=nextIndex(days,i,6);
    int cost_7=costs[1] + helper(days,costs,next,dp);
     next=nextIndex(days,i,29);
    int cost_8= costs[2] + helper(days,costs,next,dp);
    dp[i]=Math.min(cost_1,Math.min(cost_7,cost_8));
    return dp[i];
    }

    int nextIndex(int days[],int i,int day){
        
        int j=i;
        while(j<days.length && days[j]<=(days[i]+day)){
        j++;
        }
        return j;
    }
}