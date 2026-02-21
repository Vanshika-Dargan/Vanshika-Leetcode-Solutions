class Solution {
    public boolean canCross(int[] stones) {
        Map<String,Boolean> dp = new HashMap<>();
        return fn(stones, 0, 1,dp);
    }

    boolean fn(int[] stones, int i, int k,Map<String, Boolean> dp) {
        if (i == stones[stones.length - 1])
            return true;
            String key = i + "," + k;
            if(dp.containsKey(key)) return dp.get(key);
        for(int jump=k-1;jump<=k+1;jump++){
            if(jump<=0) continue;
            if(i==0 && jump>1) continue;
            int index = bs(stones,i+jump);
            if(index!=-1)
            if(fn(stones,i+jump,jump,dp)) {
            dp.put(key,true);
            return true;
            }
        }
         dp.put(key,false);
        return false;
    }

    int bs(int[] stones, int search) {
        int low = 0;
        int high = stones.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (search == stones[mid])
                return mid;
            else if (search > stones[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}