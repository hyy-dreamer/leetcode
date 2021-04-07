package leetcode;

public class MaximumBinaryTree_654 {
	
	 //Definition for a binary tree node.
	 public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	 }
	 
	
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		return build(nums, 0, nums.length - 1);
    }
	
	public TreeNode build(int[] nums, int lo, int hi)
	{
		//base case
		if(lo > hi) return null;
		else
		{
			//find the biggest value and the index
			int index = -1; int maxValue = Integer.MIN_VALUE;
			for(int i = lo; i <= hi; i ++)
			{
				if(maxValue < nums[i])
				{
					index = i;
					maxValue = nums[i];
				}
			}
			TreeNode root = new TreeNode(maxValue);
			root.left = build(nums, lo, index - 1);
			root.right = build(nums, index + 1, hi);
			return root;
		}
	}
}
/*we should notice in this case, the index and the maxValue should be set to -1 and MIN_VALUE
 * it cannot be 0 and nums[0]. It is true at the very beginning but after several recursion, the default value is wrong
 * we should learn this build function as a normal way to solve this problem
 */
