package cn.com.object;

public class MaoPao {
	
	public static int[] sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			boolean fa=true;
			for (int j = 0; j < arr.length-1; j++) {
				if(arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					fa=false;
				}
			}
			if(fa){
				break;
			}
			System.out.println("第"+i+"轮结束");
			show(arr);
			
		}
		return arr;
	}
	public static void show(int[] args) {
		for (int i : args) {
			System.out.print(i+",");
		}
		System.out.println("--------------------");
	}
	
public static void main(String[] args) {
	int [] a={4,6,9,5,1};
	//show(a);
	
	sort(a);
	
	show(a);
	
}
}
