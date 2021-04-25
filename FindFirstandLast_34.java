package leetcode;

public class FindFirstandLast_34 {
	public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        int res[] = new int[]{-1,-1};
        while(l < r)
        {
        	int mid = (l + r) / 2;
        	if(nums[mid] >= target) r = mid;
        	else l = mid + 1;
        }
        if(nums[l] != target) return res;
        res[0] = l;
        r = len;
        while(l < r)
        {
        	int m = (r + l) / 2;
        	if(nums[m] <= target) l = m + 1;
        	else r = m;
        }
        res[1] = l - 1;
        return res;
    }
}
