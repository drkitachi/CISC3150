import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class ABC2{
	public static void main(String[] args){
		ABCgenerator abcgen = new ABCgenerator();
		Print1 pt1 = new Print1(abcgen);
		Print2 pt2 = new Print2(abcgen);
		Print3 pt3 = new Print3(abcgen);
		Print4 pt4 = new Print4(abcgen);
		
		
		//Thread t1 = new Thread(pt1);
		//Thread t2 = new Thread(pt2);
		//Thread t3 = new Thread(pt3);
		//Thread t4 = new Thread(pt4);

		pt1.start();
		pt2.start();
		pt3.start();
		pt4.start();
		
		try{
		pt1.join();
		pt2.join();
		pt3.join();
		pt4.join();
		}catch(Exception e){}
		
		//System.exit(1);
		
		
	}
}

class Print1 extends Thread{
	ABCgenerator abcgn;
	
	Print1(ABCgenerator abcgn){
		this.abcgn = abcgn;
	}
	
	public void run(){
		/*
		while(true){
			abcgn.print1();
		}
		*/
		while(!abcgn.done){
			abcgn.print1();
		}
		try{
		
			interrupt();
		}catch(Exception e){}
	}
}

class Print2 extends Thread{
	ABCgenerator abcgn;
	
	Print2(ABCgenerator abcgn){
		this.abcgn = abcgn;
	}
	
	public void run(){
		/*
		while(true){
			abcgn.print2();
		}
		*/
		while(!abcgn.done){
			abcgn.print2();
		}
		try{
		
			interrupt();
		}catch(Exception e){}
	}
}

class Print3 extends Thread{
	ABCgenerator abcgn;
	
	Print3(ABCgenerator abcgn){
		this.abcgn = abcgn;
	}
	
	public void run(){
		/*while(true){
			abcgn.print3();
		}
		*/
		while(!abcgn.done){
			abcgn.print3();
		}
		try{
		
			interrupt();
		}catch(Exception e){}
	}
}

class Print4 extends Thread{
	ABCgenerator abcgn;
	
	Print4(ABCgenerator abcgn){
		this.abcgn = abcgn;
	}
	
	public void run(){
		/*while(true){
			abcgn.print4();
		}
		*/
		
		while(!abcgn.done){
			abcgn.print4();
		}
		
	}
}

class ABCgenerator{
	int alphabet;
	boolean done;
	Lock L = new ReentrantLock();		

	Condition print1 = L.newCondition();	
	Condition print2 = L.newCondition();
	Condition print3 = L.newCondition();
	Condition print4 = L.newCondition();
	
	ABCgenerator(){
		alphabet = 65;
		done = false;
	}
	
	void print1(){
		L.lock();
		try{
			/*
				if(done){
					print2.signal();
					Thread.currentThread().interrupt();
					System.exit(1);
					//throw new Throwable();
				}
				*/
				System.out.println("t1:" + (char)alphabet);
				alphabet += 1;
				if(alphabet == 91)
					done = true;
				print2.signal();		
				print1.await();	
		}catch(Throwable t){}
		finally{
			//System.out.println("unlocked");
			L.unlock();
		}
	
	}
	
	void print2(){
		L.lock();
		try{
			/*
				if(done){
					print3.signal();
					Thread.currentThread().interrupt();
					System.exit(1);
					//throw new Throwable();
				}
				*/
				System.out.println("t2:" + (char)alphabet);
				alphabet += 1;
				if(alphabet == 91)
					done = true;
				print3.signal();		
				print2.await();
		}catch(Throwable t){}
		finally{
		 ///System.out.println("unlocked");
			L.unlock();
		}
	
	}
	
	void print3(){
		L.lock();
		try{
			/*
				if(done){
					print4.signal();
					Thread.currentThread().interrupt();
					System.exit(1);
					//throw new Throwable();
				}
				*/
				System.out.println("t3:" + (char)alphabet);
				alphabet += 1;
				if(alphabet == 91)
					done = true;
				print4.signal();		
				print3.await();	
		}catch(Throwable t){}
		finally{
			//System.out.println("unlocked");
			L.unlock();
		}
	
	}
	
	void print4(){
		L.lock();
		try{
			/*
				if(done){
					print1.signal();
					Thread.currentThread().interrupt();
					System.exit(1);
				}
				*/
				System.out.println("t4:" + (char)alphabet);
				alphabet += 1;
				if(alphabet == 91)
					done = true;
				
				if(!done){
					print1.signal();		
					print4.await();	
				}
			
		}catch(Throwable t){}
		finally{
			
			L.unlock();
		}
	
	}
	
	
}