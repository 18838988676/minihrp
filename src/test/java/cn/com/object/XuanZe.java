package cn.com.object;




public class XuanZe {
	
	public static void xuan(int[] args) {
		for (int i = 0; i < args.length-1; i++) {
			int min=i;
			
			for (int j = 1+i; j < args.length; j++) {
				if(args[j]<args[min]){
					min=j;
				}
			}
			if(i!=min){
			int temp=args[min];
			args[min] =args[i];
			args[i]=temp;
			System.out.println("第"+i+1);
		}
		
		}
	}
	
	
	
	public static void show(int[] args) {
		for (int i : args) {
			System.out.print(i+",");
		}
		System.out.println("--------------------");
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		int [] a={4,9989678,6,8,9,5,1,3,0};
		xuan(a);
		show(a);
		
	}

}
