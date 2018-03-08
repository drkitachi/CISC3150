//import java.util.concurrent.ThreadLocalRandom;
import it.unimi.dsi.util.XorRShR128PlusRandomGenerator;
public class MonteCarlo2{
	public static void main(String[] args){
		//Random rand = new Random();
		XorRShR128PlusRandomGenerator random = new XorRShR128PlusRandomGenerator();
		
		long total = 40000000000L, hit = 0;
		double x, y, z, pi;
		long before = System.currentTimeMillis();
		for(long i = 1; i < total; i++){
			//x = ThreadLocalRandom.current().nextDouble(1.0);
			//y = ThreadLocalRandom.current().nextDouble(1.0);
			
			x = random.nextDouble();
			y = random.nextDouble();
			z = Math.pow(x,2) + Math.pow(y,2);
			if( z <= 1.0)
				hit++;
		}
		
		pi = (double)(hit << 2) / total;
		
		System.out.println(pi);
		
		System.out.println(System.currentTimeMillis()-before);
		
		/*
		int x = 4;
		
		System.out.println(x << x);
		*/
	}
	
}
		
		
		
		