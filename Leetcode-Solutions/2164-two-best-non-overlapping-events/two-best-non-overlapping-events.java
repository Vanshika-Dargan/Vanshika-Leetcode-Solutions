class Solution {

    public int maxTwoEvents(int[][] events) {
         Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
         Integer dp[][]=new Integer[events.length][3];
       return helper(events,0,0,dp);
        
    }

    int helper(int[][] events,int i,int count,Integer[][] dp){
    
    if(count==2 || i==events.length){
       
        return 0;
    }
    int[] event=events[i];
    int start=event[0];
    int end=event[1];
    int val=event[2];
    if(dp[i][count]!=null){
        return dp[i][count];
    }
    int choose=0;
    int not=0;
    //choose
    
     int low=i+1;
     int high=events.length-1;

     while(low<high){
        int mid=(low+high)/2;
        if(events[mid][0]>=end+1){
            high=mid;
        }
        else{
            low=mid+1;
        }
     }

     if(low<events.length && events[low][0]>=end+1){
     choose=helper(events,low,count+1,dp)+val;
     }
     else{
        choose=val+0;
     }
    
    //skip
     not=helper(events,i+1,count,dp);
    dp[i][count]= Math.max(choose,not);
    return dp[i][count];
    }
}