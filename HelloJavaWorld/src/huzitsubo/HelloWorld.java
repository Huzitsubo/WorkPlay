/**
 * 
 */
package huzitsubo;

/**
 * @author Huzitsubo
 *
 */
public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("Hello JAVA World！");

		CountDownThread t1 = new CountDownThread("thread 1");
		CountDownThread t2 = new CountDownThread("thread 2");
		t1.start();
		t2.start();
	}

}

class CountDownThread extends Thread {

	private String name;

	public CountDownThread(String name) {
		this.name = name;
	}

	public void run() {
		for (int i = 3; i >= 0; i--) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
			}
			System.out.println(name + " : " + i);
		}
	}
}
