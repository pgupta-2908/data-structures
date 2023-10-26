package ds;

import java.util.ArrayList;
import java.util.List;

public class FX {
	public static void race() {
		System.out.println("Hell");
	}
	
	public static void main(String args[]) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(3);
		list.add(4);
		list.add(2);
		list.add(5);
		list.add(7);
		list.add(1);
		list.add(3);
		
		List<Integer> list2 = new ArrayList<Integer>();
		
		
		
		
		for(int i = 0 ; i<list.size(); i++) {
			boolean present = false;
			for(int j = 0; j<list.size(); j++) {
				if(list.get(i) == list.get(j) && i != j) {
				present = true;
				break;
			}
			if(present == false) {
				list2.add(list.get(i));
			}
		}
		}
		
		System.out.println(list2);
}
}
