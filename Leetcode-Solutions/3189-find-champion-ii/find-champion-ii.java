class Solution {
    public int findChampion(int n, int[][] edges) {
        
        int indegree[]=new int[n];
        int outdegree[]=new int[n];
        for(int[] e:edges)
        {
        int first=e[0];
        int second=e[1];

        indegree[second]+=1;
        outdegree[first]+=1;
        }
        int countIndegree=0;
        int countOutdegree=0;
        int zeroIndegree=-1;
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                 countIndegree+=1;
                 zeroIndegree=i;
            }
            if(outdegree[i]==0) countOutdegree+=1;
        }

        if(countIndegree == 1) return zeroIndegree;
        return -1;
    }
}