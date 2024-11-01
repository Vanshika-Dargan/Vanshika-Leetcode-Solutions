class Solution {
    public long minimumTotalDistance(List<Integer> robots, int[][] factorys) {
        
        Collections.sort(robots);
        List<Integer> factories = new ArrayList<>();
        for(int[] f: factorys){
            for(int i=0;i<f[1];i++){
                factories.add(f[0]);
            }
        }
        Collections.sort(factories);
        long[][] dp = new long[robots.size()+1][factories.size()+1];
        for(int i=0;i<robots.size();i++){
            dp[i][factories.size()] = (long) 1e12;
        }
        for(int i=robots.size()-1;i>=0;i--){
            for(int j=factories.size()-1;j>=0;j--){
                int robot = robots.get(i);
        int factory = factories.get(j);
        

        long min1 = dp[i+1][j+1] + Math.abs(robot-factory);
        
        long min2 = dp[i][j+1];
        
        dp[i][j]=Math.min(min1,min2);
            }
        }
        return dp[0][0];
    }
     
    
    long helper(List<Integer> robots, List<Integer> factories, int i,int j,long[][] dp){

        if(i==robots.size()) return 0;

        if(j==factories.size()) return (long)1e12;

        if(dp[i][j] !=-1){
            return dp[i][j];
        }

        int robot = robots.get(i);
        int factory = factories.get(j);
        

        long min1 = helper(robots,factories,i+1,j+1,dp) + Math.abs(robot-factory);
        
        long min2 = helper(robots,factories,i,j+1,dp);
        
        dp[i][j]=Math.min(min1,min2);

        return dp[i][j];
        
    }


}