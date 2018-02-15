/*
	Question 3: Check wether a word is a palindrome.
	Resources: Old notes from CISC3130 Data Structures on how to use a Stack.
*/

import java.util.*;

public class Palindrome{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String word;
		Stack<Character> s = new Stack<Character>();
		
		System.out.print("Enter a word to check if it is a palindrome: ");
		word = scan.next();
		
		for(int i = 0; i < word.length(); i++){
			s.push(word.charAt(i));
		}
		
		if(isPalindrome(s,word))
			System.out.printf("%n%s is a palindrome", word);
		else 
			System.out.printf("%n%s is not a palindrome", word);
	}
		
	public static boolean isPalindrome(Stack<Character> s, String word){
			
		int i = 0;
		while(!s.empty()){
			if(word.charAt(i) != s.peek())
				return false;
			s.pop();
			i++;
		}
		return true;
	}
}
				