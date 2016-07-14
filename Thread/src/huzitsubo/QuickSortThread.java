package huzitsubo;

public class QuickSortThread extends Thread{

	private int[] array = new int[Main.LENGTH];
	 
    public void run() {
        System.out.println("クイックソート開始");
        long start = System.currentTimeMillis();
        sort(array);
        long end = System.currentTimeMillis();
        System.out.println("クイックソート終了" + (end - start)  + "ms");
    }
 
    public void setArray(int[] array) {
        this.array = array;
    }
    
    int partition(int[] a,int i,int j,int x){
        int l=i,r=j;

        // 検索が交差するまで繰り返します
        while(l<=r){

          // 軸要素以上のデータを探します
          while(l<=j && a[l]<x)  l++;

          // 軸要素未満のデータを探します
          while(r>=i && a[r]>=x) r--;

          if(l>r) break;
          int t=a[l];
          a[l]=a[r];
          a[r]=t;
          l++; r--;
        }
        return l;
      }
    
    int pivot(int[] a,int i,int j){
        int k=i+1;
        while(k<=j && a[i]==a[k]) k++;
        if(k>j) return -1;
        if(a[i]>=a[k]) return i;
        return k;
      }
    
    /*
     * クイックソート（再帰用）
     * 配列aの、a[i]からa[j]を並べ替えます。
     */
    public void quickSort(int[] a,int i,int j){
      if(i==j) return;
      int p=pivot(a,i,j);
      if(p!=-1){
        int k=partition(a,i,j,a[p]);
        quickSort(a,i,k-1);
        quickSort(a,k,j);
      }
    }
    /*
     * ソート
     */
    public void sort(int[] a){
      quickSort(a,0,a.length-1);
    }
}
