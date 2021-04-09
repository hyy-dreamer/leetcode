package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes_354 {
	 static int maxEnvelopes(int[][] envelopes)
		{
			int res = 0;
			int len = envelopes.length;
			Arrays.sort(envelopes, new Comparator<int[]>()
					{
						public int compare(int a[], int b[])
						{
							return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
						}
					}
			);
			int[] height = new int[len];
			for(int i = 0; i < len;i ++) height[i] = envelopes[i][1];
			res = LengthOfLIS(height);
			return res;
		}
		
		static int LengthOfLIS(int[] nums)
		{
			int res_2 = 0;
			int len_2 = nums.length;
			int[] dp = new int[len_2];
			Arrays.fill(dp,1);
			for(int j = 1; j < len_2;j ++)
			{
				for(int i = 0; i < j; i ++)
				{
					if(nums[j] > nums[i]) dp[j] = Math.max(dp[i] + 1, dp[j]);
				}
			}
			for(int i = 0; i < len_2;i ++)
			{
				res_2 = Math.max(res_2, dp[i]);
			}
			return res_2;	
		}
}
