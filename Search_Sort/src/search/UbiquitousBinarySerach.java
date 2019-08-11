package search;

public class UbiquitousBinarySerach {

	public static void main(String[] args) {

		int arr[] = {2, 5, 6, 8, 10, 12};
		System.out.println(findFloorIndex(arr, 9));
		System.out.println(findCeilIndex(arr, 9));
	}
	
	static int findFloorIndex(int arr[], int key){
		
		int l =0;
		int r = arr.length-1;
		int m =0;
		while( r > l ) 
	    { 
	        m = (l+r)/2;	  
	        if(arr[m] <= key ) 
	         	l =m;
	        else
	        	r=m-1;
	    } 
		
		return l;
	}
	
	static int findCeilIndex(int arr[], int key) {
		int l =0;
		int r = arr.length-1;
		int m =0;
		while(r > l) {
			
			m = (l+r)/2;
			if(arr[m] >= key) {
				r = m;
			}else {
				l = m+1;
			}
		}
		return r;
	}
	

}

