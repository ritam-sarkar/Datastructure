/**
 * 
 */
package pkg.binary;

/**
 * @author Ritam
 *
 */
public class BinarySearchTreeDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int a[] = {23,11,27,9,30};
      BinaryArray binArr = new BinaryArray(a);
      System.out.println(" is bst "+binArr.isBST());
      if(binArr.search(9) >=0){
    	  System.out.println(" exist at "+ binArr.search(9));
      }else{
    	  System.out.println("not exist");
      }
	}	

}
class BinaryArray{
	
	int[] a;
	
	public BinaryArray(int[] a) {
		super();
		this.a = a;
	}
	
	boolean isBST(){
		return isBST(0);		
	}
	int search(int x){
		return search(x,0);
	}
	public void insert(int x){
		
	}
	private int search(int x, int head) {
		int n = a.length;
		if(a[head] == x){
			return head;
		}else{
			int left = head*2+1;
			int right = head*2+2;
			if(x<a[head] && left<n){
				return search(x,left);
			}else if(x > a[head] && right<n){
				return search(x,right);
			}else{
				return -1;
			}
		}
	}

	private boolean isBST(int head) {
		int n = a.length;
		int left = head*2+1;
		int right = head*2+2;
		boolean result = true;
		//left sub tree
		if(left< n){
			if(a[left] >= a[head]){
				return false;
			}else{
				result = isBST(left);
			}
		}
		//right sub tree
		if(right< n){
			if(a[right] <= a[head]){
				return false;
			}else{
				result = result & isBST(right);
			}
		}
		return result;
	}
	
	
	
}

