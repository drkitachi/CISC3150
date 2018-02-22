/*
	MyString class.
	Resources: JAVA String class API to base my methods on.
				JAVA Character class API to convert integers into characters.
				https://stackoverflow.com/questions/12192805/convert-an-integer-to-an-array-of-characters-java for writing my ValueOf methods
				ASCII table
*/

package MyStringClass;

import java.util.*;

public class MyString{
	private char[] chars;
	
	public MyString(char[] chars){
		this.chars = new char[chars.length];
		int length = 0;
		
		for(char c: chars){
			this.chars[length++] = c;
		}
	}
	
	public int length(){
			return chars.length;
	}
	
	public char charAt(int index){
		return chars[index];
	}
	
	public MyString getMyString(){
		MyString s = new MyString(chars);
		
		return s;
	}
	
	public MyString substring(int begin, int end){
		char[] substr = new char[end-begin];
		int j =0;
		
		for(int i = begin; i < end; i++){
			substr[j] = chars[i];
			j++;
		}
		
		return new MyString(substr);
	}
	
	public MyString toLowerCase(){
		char[] downChars = new char[length()];
		int i = 0;
		
		for(char c:chars){
			if(c > 64 && c < 91)
				downChars[i] = (char)(c + 32);
			else
				downChars[i] = c;
			i++;
		}
		
		return new MyString(downChars);
	}
	
	public MyString toUpperCase(){
		char[] upChars = new char[length()];
		int i = 0;
		
		for(char c:this.chars){
			if(c > 96 && c < 123)
				upChars[i] = (char)(c - 32);
			else
				upChars[i] = c;
			i++;
		}
		
		return new MyString(upChars);
	}
	
	public int compareTo(MyString s){
		for(int i = 0; i < length() && i < s.length(); i++){
			if(chars[i] != s.charAt(i))
				return chars[i] - s.charAt(i);
		}
		
		if(length() != s.length())
			return length() - s.length();
		
		return 0;
	}
		
	public String toString(){
		return new String(this.chars);
	}
		
	
	public static MyString valueOf(int i){
		ArrayList<Integer> singDigit = new ArrayList<Integer>();
		int j = 0, size;
		boolean isNeg = i < 0 ? true:false;
		i = Math.abs(i);
		
		for(; i != 0; i = i/10)
			singDigit.add(i % 10);
		
		if(isNeg)
			size = singDigit.size()+1;
		else 
			size = singDigit.size();
		
		char[] c = new char[size];
		
		if(isNeg){
			c[j++] = '-';
		}

		for(int k = singDigit.size()-1; k >=0; k--){
			c[j] = Character.forDigit(singDigit.get(k),10);
			j++;
		}
		
		return new MyString(c);
	}
}