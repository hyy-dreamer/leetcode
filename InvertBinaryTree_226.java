package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree_226 {
	
	//definition of this tree
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(){}
		TreeNode(int val){this.val = val;}
		TreeNode(int val, TreeNode left, TreeNode right)
		{
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}


	//create tree
    public static TreeNode createTree(int[] nums, int index) {
    	 TreeNode root = null;
    	 if (index < nums.length) {
    		 root = new TreeNode(nums[index]);
    		 root.left = createTree(nums, 2 * index + 1);
    		 root.right = createTree(nums, 2 * index + 2);
    	 }
    	  return root;
    }

	
	//print tree
    public static void printTree(TreeNode root) {
    	if(root == null) return;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode current = null;
        queue.add(root);//�����ڵ����
        while(!queue.isEmpty())
        {
            current = queue.poll();//���Ӷ�ͷԪ�ز�����
            System.out.println(current.val);
            if(current.left != null)//�����ǰ�ڵ����ڵ㲻Ϊ�����
            {
                queue.add(current.left);
            }
            if(current.right != null)//�����ǰ�ڵ���ҽڵ㲻Ϊ�գ����ҽڵ����
            {
                queue.add(current.right);
            }
        }
    }

	//invert method
	public static TreeNode invertTree(TreeNode root)
	{
		if(root == null) return null;
		TreeNode tmp;
		tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}
	
	public static void main(String args[])
	{
		int[] nums = {4,2,7,1,3,6,9};
		TreeNode root = createTree(nums, 0);
		invertTree(root);
		printTree(root);
	}

}

