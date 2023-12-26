public class Solution {
    public int RemoveDuplicates(int[] nums) {
        if (nums.Length <= 2)
        {
            return nums.Length;
        }

        int slow = 2;
        for (int fast = 2; fast < nums.Length; fast++)
        {
            if (nums[slow - 2] != nums[fast])
            {
                nums[slow] = nums[fast];
                slow++;
            }
        }

        return slow;
    }
}