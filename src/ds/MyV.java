package ds;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MyV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "hello";
		String s2 = "hello1";
		String s3 = "hello2";
		List<String> str = new ArrayList<>();
		str.add(s1);
		str.add(s2);
		str.add(s3);
		Cms c = new Cms();
		c.setStrings(str);
		
		XMLEncoder x;
		try {
			x = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("myFile.xml")));
			x.writeObject(c);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Line 46 crossed");
		
		

	}

}
