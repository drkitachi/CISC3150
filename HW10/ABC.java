import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class ABC{
	public static void main(String[] args){
		ABCgenerator abcgen = new ABCgenerator();
		Print1 pt1 = new Print1(abcgen);
		Print2 pt2 = new Print2(abcgen);
		Print3 pt3 = new Print3(abcgen);
		Print4 pt4 = new Print4(abcgen);
		
		
		Thread t1 = new Thread(pt1);
		Thread t2 = new Thread(pt2);
		Thread t3 = new Thread(pt3);
		Thread t4 = new Thread(pt4);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		try{
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		}catch(Exception e){}
		
		System.out.println("\n" + abcgen.st.toString());
		
	}
}

class Print1 implements Runnable{
	ABCgenerator abcgn;
	
	Print1(ABCgenerator abcgn){
		this.abcgn = abcgn;
	}
	
	public void run(){
		while(true){
			abcgn.print1();
			if(abcgn.done)
				break;
		}	
	}
}

class Print2 implements Runnable{
	ABCgenerator abcgn;
	
	Print2(ABCgenerator abcgn){
		this.abcgn = abcgn;
	}
	
	public void run(){
		while(true){
			abcgn.print2();
			if(abcgn.done)
				break;
		}
	}
}

class Print3 implements Runnable{
	ABCgenerator abcgn;
	
	Print3(ABCgenerator abcgn){
		this.abcgn = abcgn;
	}
	
	public void run(){
		while(true){
			abcgn.print3();
			if(abcgn.done)
				break;
		}
	}
}

class Print4 implements Runnable{
	ABCgenerator abcgn;
	
	Print4(ABCgenerator abcgn){
		this.abcgn = abcgn;
	}
	
	public void run(){
		while(true){
			abcgn.print4();
			if(abcgn.done)
				break;
		}
	}
}

class ABCgenerator{
	int alphabet;
	boolean done;
	int thread;
	StringBuilder st;
	Lock L = new ReentrantLock();		

	Condition now = L.newCondition();
	Condition next = L.newCondition();
	
	ABCgenerator(){
		alphabet = 65;
		done = false;
		thread = 1;
		st = new StringBuilder("");
	}
	
	void print1(){
		L.lock();
		try{
				while(thread != 1){
					next.signal();
					now.wait();
				}
				if(done){
					throw new Exception();
				}
				System.out.println("t1:" + (char)alphabet);
				st.append((char)alphabet);
				alphabet += 1;
				if(alphabet == 91)
					done = true;
				thread = 2;
				
		}catch(Throwable t){}
		finally{
			L.unlock();
		}
	
	}
	
	void print2(){
		L.lock();
		try{
			
				while(thread !=2){
					next.signal();
					now.wait();
				}
				if(done){
					throw new Exception();
				}
				System.out.println("t2:" + (char)alphabet);
				st.append((char)alphabet);
				alphabet += 1;
				if(alphabet == 91)
					done = true;
				
				thread = 3;
		}catch(Throwable t){}
		finally{
			L.unlock();
		}
	
	}
	
	void print3(){
		L.lock();
		try{
				while(thread !=3){
					next.signal();
					now.wait();					
				}
				if(done){
					throw new Exception();
				}
				System.out.println("t3:" + (char)alphabet);
				st.append((char)alphabet);
				alphabet += 1;
				if(alphabet == 91)
					done = true;
				thread = 4;
		}catch(Throwable t){}
		finally{
			L.unlock();
		}
	
	}
	
	void print4(){
		L.lock();
		try{
				while(thread !=4){
					next.signal();
					now.wait();					
				}
				if(done){
					throw new Exception();
				}
				System.out.println("t4:" + (char)alphabet);
				st.append((char)alphabet);
				alphabet += 1;
				if(alphabet == 91)
					done = true;
				thread = 1;
		}catch(Throwable t){}
		finally{
			L.unlock();
		}
	
	}
	
	
}