/*
	MyStringApp for testing MyString Class.
*/

package MyStringClass;

import MyStringClass.MyString;

public class MyStringApp{
	public static void main(String[] args){
		MyString s = new MyString("Hello all youuu5".toCharArray());
		MyString u = new MyString("Hello".toCharArray());
		int f = 250, j = -500;
		MyString e = MyString.valueOf(f);
		MyString t = MyString.valueOf(j);
		
		System.out.printf("MyString s after calling s.toString(): %s%nCalling length(): %d%n", s.toString(), s.length());
		System.out.println("After calling s.toLowerCase(): " + s.toLowerCase().toString());
		System.out.println("After calling s.toUpperCase(): " + s.toUpperCase().toString());
		
		System.out.printf("MyString u: %s%n", u.toString());
		
		if(s.compareTo(u) == 0)
			System.out.println("Calling s.compare(u) we get that they are equal");
		else
			System.out.println("Calling s.compare(u) we get that they are not equal");
		
		if(s.compareTo(s) == 0)
			System.out.println("Calling s.compare(s) we get that they are equal");
		else
			System.out.println("Calling s.compare(s) we get that they are not equal");
		
		System.out.println("Calling s.charAt(2): " + s.charAt(2));
		System.out.println("Calling s.getMyString(): " + s.getMyString().toString());
		System.out.printf("Calling s.substring(1, 3): %s%n", s.substring(1, 3).toString());
		
		System.out.printf("Calling MyString.valueOf(250) and MyString.valueOf(-500): %s & %s", e.toString(), t.toString());
		
	}
}