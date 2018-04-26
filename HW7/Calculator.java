/* 
	Command Line Calculator that can perform simple operations like addition, subtraction, multiplication, and division.
	It allows the use of paranthesis and operators have to be separated by a space.
	For multiplication it uses "x" instead of a "*" because the asterisk acts as a wildcard in command line and this will give me problems.
	It throws exceptions AlgebraFailException, QuitMashingOnYourKeyboardException, UserIsADumbassException, and NoParenthesis (added to deal with open and close paranthesis)
	
	Resources:
		Evaluate PostFix: https://www.geeksforgeeks.org/stack-set-4-evaluation-postfix-expression/
		Infix to PostFix: https://en.wikipedia.org/wiki/Shunting-yard_algorithm
		Method isNumber: https://www.geeksforgeeks.org/check-if-a-given-string-is-a-valid-number-integer-or-floating-point-in-java/
		
*/

import java.util.*;

public class Calculator{
	public static void main(String[] args){
		if(args.length < 1){
			System.out.println("No command argument provided");
			System.exit(0);
		}
		
		try{
			test(args);
		} catch(AlgebraFailException e){
			System.out.println("Algebra fail, you are missing a number where a number should be or it isn't an actual number or you are missing an operator");
			System.exit(0);
		} catch(QuitMashingOnYourKeyboardException e){
			System.out.println("You enter an unsupported operation");
			System.exit(0);
		} catch(UserIsADumbassException e){
			System.out.println("Seems like you forgot to enter a number");
			System.exit(0);
		} catch(NoParenthesis e){
			System.out.println("There is something wrong with your usage of paranthesis");
			System.exit(0);
		}
		
		ArrayList<String> expression = infixToPostfix(args);
		
		try{
			System.out.printf("%n%f%n", calculate(expression));
		} catch(ArithmeticException e){
			System.out.println("You divided by 0");
		}
	
	}
	
	public static void test(String[] args){
		String operators = "+-x/()";
		String opera = "+-x/"; 
		boolean paranthesis = false;
		
		for(String s:args){
			if(operators.indexOf(s) == -1){
				if(Character.isDigit(s.charAt(0))){
					if(!isNumber(s))
						throw new AlgebraFailException();
				}else
					throw new QuitMashingOnYourKeyboardException();
			}
			
			if(s.compareTo(")") == 0 && !paranthesis)
				throw new AlgebraFailException();
			
			if(s.compareTo("(") == 0)
				paranthesis = true;
			
			if(s.compareTo(")") == 0)
				paranthesis = false;
				
		}
		
		if(opera.indexOf(args[0]) != -1 || opera.indexOf(args[args.length-1]) != -1)
			throw new AlgebraFailException();
		
		if(paranthesis)
			throw new NoParenthesis();
		
		for(int i = 0; i < args.length-1; i++){
			
			if(isNumber(args[i]) && isNumber(args[i+1]))
				throw new AlgebraFailException();
				
			if(opera.indexOf(args[i]) != -1 && (opera.indexOf(args[i+1]) != -1 || args[i+1].compareTo(")") == 0)) 
				throw new UserIsADumbassException();
		}
	}
			
			
	private static boolean isNumber(String s){
		 try{
	
            Double.parseDouble(s);
        } 
        catch (NumberFormatException e)
        {
            return false;
        }
		
		return true;
	}
		
			
	public static ArrayList<String> infixToPostfix(String[] args){
		String operators = "+-x/(";
		Stack<String> opStack = new Stack<>();
		ArrayList<String> infixList = new ArrayList<>();
		
		for(String s:args){
			if(isNumber(s))
				infixList.add(s);
			else{
				if(opStack.empty())
					opStack.push(s);
				else if(operators.indexOf(s) / 2 > operators.indexOf(opStack.peek()) / 2 && s.compareTo(")") != 0)
						opStack.push(s);
				else if(s.compareTo(")") == 0){
					while(!opStack.empty() && opStack.peek().compareTo("(") != 0){
						infixList.add(opStack.pop());
					}
					
					if(!opStack.empty())
						opStack.pop();
				} else {
					while(!opStack.empty() && operators.indexOf(s) / 2 <= operators.indexOf(opStack.peek()) / 2 && opStack.peek().compareTo("(") != 0){
						infixList.add(opStack.pop());
					}	
					opStack.push(s);
				}
			}
		}
		
		while(!opStack.empty())
			infixList.add(opStack.pop());
		
		return infixList;
	}
	
	public static double calculate(ArrayList<String> exp){
		Stack<Double> result = new Stack<>();
		double a, b;
		for(String s:exp){
			if(isNumber(s))
				result.push(Double.parseDouble(s));
			else{
				b = result.pop();
				a = result.pop();
				
				switch(s.charAt(0))
                {
                    case '+':
                    result.push(a+b);
                    break;
                     
                    case '-':
                    result.push(a-b);
                    break;
                     
                    case '/':
					if(b == 0) throw new ArithmeticException();
                    result.push(a/b);
                    break;
                     
                    case 'x':
                    result.push(a*b);
                    break;
              }
			}
		}
		
		return result.peek();
	}
					
}

class AlgebraFailException extends IllegalArgumentException{

}

class QuitMashingOnYourKeyboardException extends IllegalArgumentException{

}

class UserIsADumbassException extends IllegalArgumentException{
  
}

class NoParenthesis extends IllegalArgumentException{
	
}
