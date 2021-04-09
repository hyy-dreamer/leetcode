package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateSubtree_652 {
	
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
	 	List<TreeNode> res = new ArrayList();;
		HashMap<String, Integer> hashmap = new HashMap<>();
	    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
	    	String ans = getSerial(root);
			return res;
	    }
	    //序列化二叉树，每个二叉树的序列化结果唯一
		public String getSerial(TreeNode root)
		{
			if(root == null) return "#";
			String serial = root.val + "," + getSerial(root.left) + "," + getSerial(root.right);
			hashmap.put(serial, hashmap.getOrDefault(serial, 0) + 1);
			if(hashmap.get(serial)== 2) res.add(root);
			return serial;
		}
}
