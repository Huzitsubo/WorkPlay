/**
 * 
 */
package huzitsubo;

/**
 * @author Huzitsubo
 *
 */
public class BubbleSortThread extends Thread {
	
	private int[] array = new int[Main.LENGTH];
	 
    public void run() {
        System.out.println("バブルソート開始");
        long start = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("バブルソート終了" + (end - start)  + "ms");
        
    }
 
    public void setArray(int[] array) {
        this.array = array;
    }

}
