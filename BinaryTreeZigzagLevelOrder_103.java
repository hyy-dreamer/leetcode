package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrder_103 {
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
	  public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
	        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	        if(root == null) return res;
	        Queue<TreeNode> q = new LinkedList<TreeNode>();
	        q.add(root);
	        int count = 0;
	        while(!q.isEmpty())
	        {
	            int size = q.size();
	            ArrayList<Integer> temp = new ArrayList<>();
	            for(int i = 0; i < size; i ++)
	            {
	                TreeNode current = q.poll();
	                temp.add(current.val);
	                if(current.left != null) q.add(current.left);
	                if(current.right != null) q.add(current.right);
	            }
	            if(count % 2 == 0) res.add(temp);
	            else 
	            {
	                Collections.reverse(temp);
	                res.add(temp);
	            }
	            count ++;
	        }
	        return res;
	    }
}
