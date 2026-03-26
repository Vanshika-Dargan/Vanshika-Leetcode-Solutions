class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {


    int n = nums.length;
    int dp[] = new int[n];
    int hash[] = new int[n];
    Arrays.sort(nums);
    Arrays.fill(dp,1);
    int last = 0;
    int max = 1;
    for(int i=1;i<n;i++){
        hash[i]=i;
        for(int j=0;j<i;j++){

            if(nums[i]%nums[j]==0 && dp[i]<1+dp[j]){
                dp[i]=1+dp[j];
                hash[i]=j;
            }
        }
        if(max<dp[i]){
            max = dp[i];
            last = i;
        }
    }
    List<Integer> temp = new ArrayList<>();

    while(last!=hash[last])
    {
        temp.add(nums[last]);
        last = hash[last];
    }
    temp.add(nums[last]);
    return temp;
    }
}