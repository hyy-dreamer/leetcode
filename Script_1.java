package leetcode;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * This script aims at searching the whole directory to find all the files instead of directories.
 * We use recursion as the searching method, because not all the directories are of the same structure
 * We get all the files and then using a list to denote the directories(package) which contain those files
 */
public class Script_1 {
	public static HashMap<String, List> Search(String path, HashMap<String, List> hashmap)
	{
		File file = new File(path);
		File[] files = file.listFiles();
		if(files == null) return null;
		
		for(File f : files)
		{
			if(f.isFile())
			{
				String fileName = f.getName();
				String packageName = f.getAbsolutePath().substring(0,1);//change each time
				List l = new ArrayList();
				l.add(packageName);
				if(!hashmap.containsKey(fileName))
				{
					hashmap.put(fileName, l);
				}
				else
				{
					hashmap.get(fileName).add(packageName);
				}
				
			}
			else if(f.isDirectory())
			{
				Search(f.getAbsolutePath(),hashmap);
			}
		}
		return hashmap;
 	}
	
	public static void main(String args[])
	{
		HashMap<String, List> hashmap = new HashMap();
		hashmap = Search("C:\\Users\\hyy\\Desktop",hashmap);
		for(String key : hashmap.keySet()) System.out.println("File : " + key + " Package : " + hashmap.get(key));
	}
}
