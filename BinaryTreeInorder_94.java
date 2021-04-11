package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class BinaryTreeInorder_94 {
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
	  //recursion method
      List<Integer> res = new ArrayList();
	  public List<Integer> inorderTraversal(TreeNode root) {
	        if(root == null) return res;
	        inorderTraversal(root.left);
	        res.add(root.val);
	        inorderTraversal(root.right);
	        return res;
	   }
	 //iteration method
	  public List<Integer> inorderTravel(TreeNode root)
	  {
		  List<Integer> res_2 = new ArrayList();
		  Deque<TreeNode> stk = new LinkedList<TreeNode>(); 
		  if(root == null) return res_2;
		  while (root != null || !stk.isEmpty()) {
	            while (root != null) {
	                stk.push(root);
	                root = root.left;
	            }
	            root = stk.pop();
	            res_2.add(root.val);
	            root = root.right;
	        }
		  return res_2;
	  }
	  
}
