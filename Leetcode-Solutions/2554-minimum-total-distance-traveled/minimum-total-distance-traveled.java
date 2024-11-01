class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        
        Collections.sort(robot);
        List<Integer> factories = new ArrayList<>();
        for(int[] f: factory){
            for(int i=0;i<f[1];i++){
                factories.add(f[0]);
            }
        }
        Collections.sort(factories);
        long[][] dp = new long[robot.size()][factories.size()];
        for(long[] row: dp){
            Arrays.fill(row,-1);
        }
        return helper(robot,factories,0,0,dp);
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