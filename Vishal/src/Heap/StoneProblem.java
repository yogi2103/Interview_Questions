package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class StoneProblem {
	 static class MaxComparator implements Comparator<Integer>{
	        @Override
	        public int compare(Integer o1,Integer o2)
	        {
	            if(o1>o2)
	                return -1;
	            else if(o1<o2)
	                return 1;
	            else
	                return 0;
	        }
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> pq=new PriorityQueue<>(new MaxComparator());
		int stones[]= {2,2};
		for(int i=0;i<stones.length;i++)
			pq.add(stones[i]);
		System.out.println(pq);
		
		while(pq.size()>1)
		{
			int a=pq.remove();
			int b=pq.remove();
			
			if(b<a)
				pq.add(a-b);
		}
		
//		System.out.println(pq.remove());
				
		

	}

}
