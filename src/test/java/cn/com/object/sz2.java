package cn.com.object;

import org.apache.velocity.anakia.Escape;


class Myarrar{
	int [] arr;
	int elems;
	int length;
	public Myarrar(int le) {
		length=le;
		elems=0;
		arr=new int[le];
	}
	
	//add
	public void add(int value){
		if(elems==length){
			System.err.println("满了");
		}else {
			arr[elems]=value;
			elems++;
		}
	}
	
	//findall
	public void findall(){
		for (int i = 0; i < elems; i++) {
			System.err.print(arr[i]+",");
		}
		System.err.println("");
	}
	
	
	//find
	public int find(int value){
		for (int i = 0; i <elems; i++) {
			if(arr[i]==value){
				System.err.println("找到了："+value);
				return i;
			}
		}
		System.err.println("没有");
		return -1;
	}
	
	//udpate
	
	public void udpate(int index ,int value){
		if(index<0||index>elems){System.err.println("越界了");}
		else  {
			arr[index]=value;
		}
		
	}
	
	//delete
	
	public void delete(int value){
		int a=find(value);
		if(a==elems-1){
			elems--;
		}else {
			for (int i = a; i < elems-1; i++) {
				arr[i]=arr[i+1];
			}
			elems--;
		}
		
		
	}
	
	
	
	
}


public class sz2 {
	
	public static void main(String[] args) {
		Myarrar ma=new Myarrar(6);
		ma.add(111);
		ma.add(112);
		ma.add(113);
		ma.add(114);
		ma.findall();
		ma.delete(111);
		ma.findall();
		
		ma.udpate(0, 5000);
		ma.findall();
		ma.find(114);
		
		
	}
	
	
	
	

}
