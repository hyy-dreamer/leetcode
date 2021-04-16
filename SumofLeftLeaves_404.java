package leetcode;

public class SumofLeftLeaves_404 {
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
	 int sum = 0;
	    public int sumOfLeftLeaves(TreeNode root) {
	        cal(root);
	        return sum;
	    }
	    public void cal(TreeNode root)
	    {
	        if(root == null) return;
	        if(root.left != null && root.left.left == null && root.left.right == null) sum += root.left.val;
	        cal(root.left);
	        cal(root.right);
	    }
}
