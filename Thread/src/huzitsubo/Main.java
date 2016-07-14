/**
 * 
 */
package huzitsubo;

import java.util.Random;

/**
 * @author Huzitsubo
 *
 */
public class Main {
	public static final int LENGTH = 100000;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//選択ソートスレッド
        ChoiceSortThread choice = new ChoiceSortThread();
        //バブルソートスレッド
        BubbleSortThread bubble = new BubbleSortThread();
        //クイックソートスレッド
        QuickSortThread quick = new QuickSortThread();
 
        //同じ値を持つ配列を作る
        int[] array1 = new int[LENGTH];
        int[] array2 = new int[LENGTH];
        int[] array3 = new int[LENGTH];
        
        for (int i = 0; i < LENGTH; i++) {
            array1[i] = new Random().nextInt(1000); //1000以下のランダムな値を代入
            array2[i] = array1[i]; //同じ値をarray2にも代入
            array3[i] = array1[i];
        }
 
        //配列をセットする
        choice.setArray(array1);
        bubble.setArray(array2);
        quick.setArray(array3);
 
        //よーい、どん！
        bubble.start();
        choice.start();
        quick.start();
    }

}
