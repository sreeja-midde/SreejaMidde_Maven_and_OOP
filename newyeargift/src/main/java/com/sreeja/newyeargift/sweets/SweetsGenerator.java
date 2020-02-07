package com.sreeja.newyeargift.sweets;

import java.util.Iterator;
import java.util.Random;

public class SweetsGenerator implements Generator<Sweet>, Iterable<Sweet> {
	private static Random rand = new Random();

    private static final int SUGARMIN = 10;

    private static final int SUGARMAX = 50;

    private static final int WEIGHTMIN = 40;

    private static final int WEIGHTMAX = 180;
    
    private int size = 0;
    
    private Sweet[] instances = {new Laddu(), new Mysorepak(),
            new Jaggery(), new Rasagulla()   };
    public Sweet next() {
    	try {
    		Sweet current = (Sweet)instances[rand.nextInt(instances.length)].clone();
    		double sugarParam = randomSugarLevel();
            double weightParam = randomWeight();
            current.setSweetness(sugarParam);
            current.setWeight(weightParam);
            System.out.println(sugarParam+"  "+weightParam);
            return  current;
    	}catch(CloneNotSupportedException c){}  
    	return null;
    }
	private double randomWeight() {
		// TODO Auto-generated method stub
		return WEIGHTMIN + (Math.random() * ((WEIGHTMAX - WEIGHTMIN) + 1));
	}
	private double randomSugarLevel() {
		// TODO Auto-generated method stub
		return SUGARMIN + (Math.random() * ((SUGARMAX - SUGARMIN) + 1));
	}

	class SweetIterator implements Iterator<Sweet> {
		int count = size;

		public boolean hasNext() {
			// TODO Auto-generated method stub
			return count>0;
		}

		public Sweet next() {
			// TODO Auto-generated method stub
			count--;
			return SweetsGenerator.this.next();
		}
		
	}
	public Iterator<Sweet> iterator() {
		// TODO Auto-generated method stub
		return new SweetIterator();
	}
}
