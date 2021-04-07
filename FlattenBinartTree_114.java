package leetcode;
/*In this case, we should not focus on the recursion itself
 * we just imagine the flatten is used to convert a tree into a single list
*/
public class FlattenBinartTree_114 {
	//the definition of TreeNode
	 public static class TreeNode {
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
	 
	 public void flatten(TreeNode root)
	 {
		 //base case
		 if(root == null) return;
		 
		 //recursion
		 flatten(root.left);
		 flatten(root.right);
		 
		 //update the left subtree and the right subtree
		 TreeNode left = root.left;
		 TreeNode right = root.right;
		 
		 //turn the left tree into right tree and the left tree to null
		 root.right = left;
		 root.left = null;
		 
		 //go through and make combinations
		 TreeNode p = root;
		 while(p.right != null)
		 {
			 p = p.right;
		 }
		 p.right = right;
	 }
	 
}
