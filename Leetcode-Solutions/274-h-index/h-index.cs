public class Solution {
    public int HIndex(int[] citations) {
        int res = 0;
        Array.Sort(citations);

        for(int i = citations.Length -1; i>-1; i--)
        {
            if (res < citations[i])
            {
                res++;
            }
            else
            {
                return res;
            }
        }
        
        return res;
    }
}