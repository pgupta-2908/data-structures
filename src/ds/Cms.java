package ds;

import java.util.List;

public class Cms {

	List<String> strings;

	public List<String> getStrings() {
		return strings;
	}

	public void setStrings(List<String> strings) {
		this.strings = strings;
	}
	
	private void show() {
		System.out.println("in show private method");
	}
}
