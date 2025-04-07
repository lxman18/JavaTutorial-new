package ListSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<String> set = new HashSet<String>();
//		Set<String> set = new TreeSet<String>();
//		Set<String> set = new LinkedHashSet<String>();
		
		
		set.add("Apple");
		set.add("Orange");
		set.add("pine");
		set.add("grape");
		set.add("Apple");
		
		for (String sett : set) {
			System.out.println(sett);
		}
		
		boolean se= set.contains("Apple");
		System.out.println(se);
		
		boolean ee = set.isEmpty();
		System.out.println(ee);     
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
