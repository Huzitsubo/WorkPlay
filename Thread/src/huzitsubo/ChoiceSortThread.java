package huzitsubo;

public class ChoiceSortThread extends Thread {

	private int[] array = new int[Main.LENGTH];

	public void run() {
		System.out.println("選択ソート開始");
		long start = System.currentTimeMillis();
		for (int i = 0; i < array.length; i++) {
			int min = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[min] > array[j]) {
					min = j;
				}
			}
			if (min != i) {
				int tmp = array[i];
				array[i] = array[min];
				array[min] = tmp;
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("選択ソート終了" + (end - start)  + "ms");
	}

	public void setArray(int[] array) {
		this.array = array;
	}
}
