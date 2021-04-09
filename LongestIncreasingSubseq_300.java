package leetcode;

public class LongestIncreasingSubseq_300 {
	 public int lengthOfLIS(int[] nums) {
	        int res = 0;
			int len = nums.length;
			
			//base case: initializing dp to 1
			int[] dp = new int[len];
			Arrays.fill(dp, 1);
			
			//state transition
			for(int i = 1; i < len;i ++)
			{
				for(int j = 0; j < i;j ++)
				{
					if(nums[i] > nums[j])
					{
						dp[i] = Math.max(dp[i], dp[j] + 1);
					}
				}
			}
			
			//find the biggest res
			for(int i = 0; i < len; i ++)
			{
				res = Math.max(res, dp[i]);
			}
			return res;
	    }
}
