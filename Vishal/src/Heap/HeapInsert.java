package Heap;

import java.util.ArrayList;

public class HeapInsert {
	
	static private ArrayList<Integer> data;
	
	public HeapInsert()
	{
		data=new ArrayList<>();
	}

	
	public static void insert(int no)
	{
		data.add(no);
		int CI=data.size()-1;
		int PI=(CI-1)/2;
		
		while(CI>0)
		{
			if(data.get(CI)<data.get(PI))
			{
				int temp=data.get(CI);
				data.set(CI, data.get(PI));
				data.set(PI, temp);
				CI=PI;
				PI=(CI-1)/2;
			}
			else
			{
				break;
			}
		}
	}
	
	public static int remove()
	{
		
		
		if(data.size()>0)
		{
			int CI=data.size()-1;
			int elemt=data.get(0);
			data.set(0, data.get(CI));
			data.remove(CI);
			int PI=0;
			while(true)
			{
				int LC=2*PI+1;
				int RC=2*PI+2;
				
//				if( data.get(PI)<data.get(LC)&& data.get(PI)<data.get(RC))
//					break;
				 if(LC<data.size() && data.get(PI)>data.get(LC))
				{
					int temp=data.get(PI);
					data.set(PI,data.get(LC));
					data.set(LC, temp);
					PI=LC;
				}
				else if(RC<data.size()&& data.get(PI)>data.get(RC))
				{
					int temp=data.get(PI);
					data.set(PI,data.get(RC));
					data.set(RC, temp);
					PI=RC;
				}
				else 
				{
					break;
				}   
				
			}
			                                                                                                               
 			return elemt;
			
		}
		else 
			return -1;
		
	}
	
	public static void print()
	{
		System.out.println(data);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HeapInsert heap=new HeapInsert();
//		heap.insert(10);
//		heap.insert(5);
//		heap.insert(15);
//		heap.insert(2);
//		heap.insert(4);
//		heap.insert(20);
//		heap.print();
//		heap.remove();
//		heap.print();
		heap.insert(5);
		heap.insert(1);heap.insert(9);
		heap.insert(2); 
		heap.insert(0);
		heap.print();
		System.out.println(heap.remove());
		heap.remove();heap.print();
		
		

	}

}
