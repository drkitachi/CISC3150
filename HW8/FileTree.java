/* 
	Resource: 
	https://www.rapidtables.com/code/text/unicode-characters.html
	Used to look at the Unicode escape characters for the formatting
	
	https://docs.oracle.com/javase/8/docs/api/java/io/File.html#listFiles--
	https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html
	
	https://stackoverflow.com/questions/33437166/print-directory-like-tree-command
	Use this resources to help me with unicode formatting and also to fix this error:
	
│   ├──Question5
│   │   ├──outputRealTriangle.txt
│   │   └──RealTriangle
│   │   │   ├──RealTriangle.java
│   │   │   ├──RealTriangleApp.java
│   │   │   └──TwoDPoint.java
│   └──Question6
│   │   ├──outputTwoCircles.txt
│   │   └──TwoCircles
│   │   │   ├──Circle.java
│   │   │   ├──TwoCircles.java
│   │   │   └──TwoCirclesApp.java
├──HW2
	
	Use the idea of a list of booleans to eliminate the extra branches out of space, change to:

│   ├──Question5
│   │   ├──outputRealTriangle.txt
│   │   └──RealTriangle
│   │       ├──RealTriangle.java
│   │       ├──RealTriangleApp.java
│   │       └──TwoDPoint.java
│   └──Question6
│       ├──outputTwoCircles.txt
│       └──TwoCircles
│           ├──Circle.java
│           ├──TwoCircles.java
│           └──TwoCirclesApp.java
├──HW2

*/

import java.util.*;
import java.io.*;
public class FileTree{
	public static void main(String[] args)throws IOException{
		File fs = new File(".");
		StringBuilder st = new StringBuilder("");
		ArrayList<Boolean> ar = new ArrayList<>();

		builder(st, 0, fs, false, ar);
		
		System.out.print(st.toString());
	
		try(BufferedWriter bfw = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream("output.txt"),"UTF-8"))) {
		
			bfw.write(st.toString());

		} catch (Exception e) {
			System.out.println(e.toString());
		} 
	}
	
	static void builder(StringBuilder str, int depth, File fs, boolean last, ArrayList<Boolean> boolList){
		if(fs == null) 
			return;
		
		String charac = last ? "\u2514" : "\u251c";
		
		if(depth == 0)
			str.append(fs.getName() + "\r\n");
		else if(depth == 1){
			str.append(charac + "\u2500\u2500" + fs.getName() + "\r\n");
		} else if(depth > 1){
			for(int i = 0; i < depth-1; i++){
				if(boolList.get(i))	
					str.append("    ");
				else
					str.append("\u2502   ");
			}
			str.append(charac + "\u2500\u2500" + fs.getName() + "\r\n");
		}
		
        if(fs.listFiles() == null){
            return;
        }
		
        for(int i = 0; i < fs.listFiles().length; i++){
			if(i == fs.listFiles().length-1)
				last = true;
			else
				last = false;
			
			boolList.add(i == fs.listFiles().length-1);
			
			builder(str, depth+1, fs.listFiles()[i], last, boolList); 
			
			boolList.remove(boolList.size()-1);
		}
			
	}		
}
