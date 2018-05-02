public class Hello{
	
	public static void main(String[] args){
		blah ok = new blah();
		ok.someMethod();
		
	
		
		
	}
	
	
}

class blah{
	public void someMethod(){
		try{
			throw new NullPointerException();
		}
		catch(Throwable t){
			System.out.println("Caught!");
			if (t instanceof NullPointerException) {
				System.out.println("Caught a NullPointerException object");
			}
			throw t;
		}
	}
}

/*








*/