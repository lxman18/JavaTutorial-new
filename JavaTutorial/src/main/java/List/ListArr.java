package List;

import java.util.ArrayList;
import java.util.List;

public class ListArr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> list = new ArrayList<String>();
		list.add("Apple");
		list.add("grape");
		list.add("Aplle");
		list.add("Pine");
		//before
		for (String elefruit : list) {
			
			System.out.println(elefruit);
		}
		list.remove("apple");
		//enhance for loop
		
		for (String fruit : list) {
			
			System.out.println(fruit);
		}
		// contain use for check values into the list:
		boolean h = list.contains("NA");
		System.out.println(h);
		
		boolean is = list.isEmpty();
		System.out.println(is);
		list.clear();	
		
//		int size = list.size();
//		System.out.println(size);
	
		

	}

}
