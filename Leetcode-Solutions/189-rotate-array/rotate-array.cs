public class Solution {
	public void Rotate(int[] nums, int k) {
		if (k == 0 || nums.Length == 1 || nums.Length == k)
			return;

		int s = 0;
		int p = 0;
		int e = nums[p];

		for (int c = 1; c <= nums.Length; c++)
		{
			p = (p + k) % nums.Length;
			(e, nums[p]) = (nums[p], e);

			if (p == s)
			{
				s++;
				p++;
				e = nums[p];
			}
		}
	}
}