import java.util.*;
public class ToBinary{
	public static void main(String[] args){
		/*
		Scanner scan = new Scanner(System.in);
		
		int x = (int)((1.0/0)-(1.0/0)); //infinity - infinity = not a number.
		System.out.println(x);
		System.out.println(Integer.MAX_VALUE+1); //if just infinity, x = max int.
		
		//String x = "Hello";
		
		//System.out.println(x.substring(2,4));
		//int x = 21;
		/*
		boolean b1, b2, b3, b4, b5, b6;
		
		b1 = b2 = b3 = true;
		
		if(b1)
			System.out.println(b1);
		
		if(b2)
			System.out.println(b2);
		
		if(b3)
			System.out.println(b3);
		
		*/
		
		//B myB = new B();
		
		//System.out.println(myB.n);
		
		//myB.print();
		
		//myB.n = "hahaha changed!";
		
		//System.out.println(myB.n);
		//A myA2 = new A();
		//B someB = (B) myA2;
		//System.out.println(someB);
		
		
		//System.out.println(myA2);
		/*
		A myA = new A(5, 2, 8);
		
		System.out.println(Long.parseLong("85555"));
		/*
		
		char[] b = new char[5];
		System.arraycopy(myA.x, 0, b, 0, 5);
		
		System.out.println(b);
		
		A wow = myA;
		
		wow.print();
		
		wow = new A();
		
		//((B)myA).print();
		*/
		
		
		//System.out.println(2.6/3);
		
		//System.out.println(hi.equals(h));
		
		
	//System.out.println((x+5+8+6) >>>1);
		//System.out.printf("%32s%n",Integer.toBinaryString(v << 1));
		//System.out.printf("%32s", Integer.toBinaryString(t >> 1));
		/*
		try{
			A myA = new A();
		}catch(Throwable e){}
		*/
		
		//B myB = (B)myA;
		//v = swap(t, t = v);
		
		/*
		Date d = new Date(234293247);

		MyClass<Integer> mc = new MyClass<>(d);	
		*/
		
		Meh my_meh = null;
		
		try{
			my_meh = new Meh();
		}catch(Throwable ex){
			System.out.println(ex.getMessage());
		}
		
		try{
		System.gc();
		}catch(Exception ex){
			System.out.println("hahahah");
		}

	}
	/*
	static int swap(int a, int b){
		System.out.println(b);
		return a;
	}
	*/

}

	
class Blah{
		String my_str;
	Blah() throws Exception{
		my_str = "Hello!";
		throw new Exception("Blah constructor failing!");
	}
	
	public void sayBlah(){
		System.out.println("BLAH!");
	}
}

class Meh extends Blah{
	Meh() throws Exception{
	}
	
	@Override
	public void finalize() throws Exception{
		//throw new Exception();		//can't throw new exceptions
		int t = 9/0;
		Object y = new Object();
		//Blah x = (Blah)y;			//this statement fails and finalize thread dies silently cuz it doesn't do exceptions. You need it cuz the compiler complains about potentially uninitialized variables.
		try{
			Blah x = new Blah();
		}
		catch(Exception ex){
			System.out.println("Exception caught!");
		}
		System.out.println("Saying blah now");
		//x.sayBlah();		
	}
}

class A extends B{
		char[] x = new char[5];
		
		static{
			System.out.println("oooops something happened in A");
		}
		
		{
			//throw new ArithmeticException();
			System.out.println("YIIIIISSSSS from A");
		}

		A(){
			
			System.out.println("A");
			for(int i = 0; i < 5; i++){
				x[i] = 'A';
			}
			//y = 2;
		}
		
		A(int... hi){
			//this();
			System.out.println(Arrays.toString(hi));
		}
		
		@Override
		void print(){
			//super.again();
			System.out.println("Called print from A");
			System.out.println(x);
		}
		
		
		String hi(){
			return "hi";
		}
}

class B{
	
	private int y;
	String n = "yessss A";
		
		static{
			System.out.println("oooops something happened");
		}
		
		{
			System.out.println("YIIIIISSSSS from B");
		}
	B(){
		System.out.println("B");
	}
	
	void print(){
		System.out.println("Called print B");
	}
	
	Object hi(){
		return new Object();
	}
	
	private void again(){
		System.out.println("whattttt");
	}
	
}

class MyClass<X> {		//class has the X type.
  <T> MyClass(T t) {		//constructor has the T type.
    System.out.println(t instanceof Date);
  }
}
	