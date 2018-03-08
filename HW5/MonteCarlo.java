import java.util.concurrent.ThreadLocalRandom;

public class MonteCarlo{
	public static void main(String[] args){
		//Random rand = new Random();
		long before = System.currentTimeMillis();
		long total = 40000000000L, hit = 0;
		double x, y, pi;
		
		for(long i = 1; i < total; i++){
			x = ThreadLocalRandom.current().nextDouble(1.0);
			y = ThreadLocalRandom.current().nextDouble(1.0);
			
			if(Math.pow(x,2) + Math.pow(y,2) <= 1.0)
				hit++;
		}
		
		pi = (double)(4 * hit) / total;
		
		System.out.println(pi);
		
		System.out.println(System.currentTimeMillis()-before);
		
	}
	
}
		
		
		
		