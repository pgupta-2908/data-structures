package ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyClassDemo {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
//		int len = list.size();
//		for(Integer i : list) {
//			list.add(10);
//		}
		System.out.println("First List = " +list);
		
		List<Integer> list2 = list.stream().filter(i -> i<2).map(i -> i*2).collect(Collectors.toList());
		
		System.out.println("Second list = " + list2);

	}
	

}
