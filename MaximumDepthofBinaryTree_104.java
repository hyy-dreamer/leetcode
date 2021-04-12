package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthofBinaryTree_104 {
	  public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	
	public int maxDepth(TreeNode root) {
        int max = 0;
        if(root == null) return max;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
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
            res.add(temp);
        }
        return res.size();
    }
}
