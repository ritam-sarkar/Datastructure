package sort.application;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://www.youtube.com/watch?v=VmogG01IjYc
 */
public class ContinuousMedian {
    public static void main(String[] args) {

      int[] arr1 = {5,1,13,9,7};
        System.out.println(getMedians(arr1));
    }
    public static double getMedians(int[] arr){
        int n = arr.length;
        //max heap
        PriorityQueue<Integer> lowers = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return -1*a.compareTo(b);
            }
        });
        //min heap
        PriorityQueue<Integer> highers = new PriorityQueue<Integer>();
        for(int i=0;i<n;i++){
          int number = arr[i];
          addNumber(lowers,highers,number);
          rebalance(lowers,highers);
        }
        return getMedian(lowers,highers);
    }

    /**
     * median is always the root from lowers or the maxHeap if their size is not equal
     * If they are equal the then they have two median so median should be the average of the two roots
     *
     * @param lowers
     * @param highers
     * @return
     */
    private static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;
        if(smallerHeap.size() != biggerHeap.size()){
            return biggerHeap.peek();
        } else{
            return (smallerHeap.peek() + biggerHeap.peek())/2;
        }
    }

    /**
     * If the lower and higher heap has different size then poll from the heap whcih is bigger in size
     * and add it in the heap which is smaller in size
     * if they are of same size then balancing not required
     * @param lowers
     * @param highers
     */
    private static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;
        while(biggerHeap.size() - smallerHeap.size() >=2){
            smallerHeap.add(biggerHeap.poll());
        }
    }

    private static void addNumber(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers, int number) {

        /**
         * if lowers is empty or the number is less than the root element then
         * add to lowers or maxHeap otherwise in highers or minHeap
         */
        if(lowers.size() ==0 || number < lowers.peek()){
            lowers.add(number);
        } else{
            highers.add(number);
        }
    }

}
