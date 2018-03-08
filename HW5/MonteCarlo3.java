/*
	Question 1: computing PI.
	Some optimization I tried were to change the Random generator being used, SplittableRandom is considerably faster than the Random class
	and a little bit faster than ThreadLocalRandom. I also tried using bitwise shift left for multiplication and avoided the use of the method
	pow from the math class. I separated the generation of points into 4 threads, 1 billion for each thread and then add everything together.
	Resources for optimization:
	https://www.javaworld.com/article/2077647/build-ci-sdlc/make-java-fast--optimize-.html
	https://blog.jooq.org/2015/02/05/top-10-easy-performance-optimisations-in-java/
	https://www.youtube.com/watch?v=VYN-CBtPNiM
*/

import java.util.SplittableRandom;
public class MonteCarlo3{
	public static void main(String[] args){
		long total = 40000000000L;
		double pi;
		FindHitThreading[] h = new FindHitThreading[4];
		/*
		FindHitThreading h1 = new FindHitThreading();
		FindHitThreading h2 = new FindHitThreading();
		FindHitThreading h3 = new FindHitThreading();
		FindHitThreading h4 = new FindHitThreading();
		*/
		long before = System.currentTimeMillis();
		
		/*
		h1.start();
		h2.start();
		h3.start();
		h4.start();
*/
		
		try{
		/*	
		h2.join();
		h3.join();
		h4.join();
		h1.join();
		*/
		for(int i=0; i < h.length; i++){
			h[i] = new FindHitThreading();
			h[i].start();
		}
		
		for(int i=0; i< h.length; i++){
			h[i].join();
			
		}
		} catch(Exception e){}
		
		pi = (double)((h[0].hit + h[1].hit + h[2].hit + h[3].hit) << 2) / total;
		
		System.out.println(pi);
		
		System.out.println(System.currentTimeMillis()-before);
	}
	
}

class FindHitThreading extends Thread{
	public long hit=0;

	@Override
	public void run(){
		double x, y, z;
		
		SplittableRandom random = new SplittableRandom();
		for(long i = 1; i <= 10000000000L; i++){
			
			x = random.nextDouble();
			y = random.nextDouble();
			z = x*x + y*y;
			if(z <= 1.0)
				//if(((int)z & 1) == 0)
				hit++;
		}
		
	}
	
	
}	
		
		