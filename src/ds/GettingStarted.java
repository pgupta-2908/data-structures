package ds;

import java.util.HashMap;
import java.util.Map;

//class Student implements Comparable<Student>{
//	
//	private String id;
//	private String name;
//	public Student(String id, String name) {
//		super();
//		this.id = id;
//		this.name = name;
//	}
//	public String getId() {
//		return id;
//	}
//	public void setId(String id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	
//	@Override
//	compareTo(Student student) {
//		if(this.getId().compareTo(student.getId()))
//	}
//	
//	
//	
//}

public class GettingStarted {

//	B b = new B() {
//		public void show() {
//			System.out.println("Show me this")
//			}
//		};
//	b.show();

	public static void main(String[] args) {

//		String str = "abracadabra";
//		int len = str.length();
//		
//		Map<String, Integer> map = new HashMap<>();
//		for(int i = 0; i < len; i++) {
//			map.put(str.charAt(i), );
//		}
//		}

		int[] arr = { 8, 9, 5, 4, 3, 6, 7 };

		int len = arr.length;

		int start = 0;
		int max = arr[start];
		int[] ans = new int[len];
		
		while (start < len - 1) {
			for (int i = start + 1; i < len; i++) {
				if (arr[i] > max) {
					
					max = arr[i + 1];
				}
			}
			if (max > arr[start]) {
				System.out.println(max);
			} else {
				System.out.println("-1");
			}
			start++;
		}

//		String s1 = "this is Pratyush";
//		String s2 = "this is Sampurna";
//
//		String[] str1 = s1.split(" ");
//		String[] str2 = s2.split(" ");
//		String[] ans = new String[str1.length + str2.length];
//
//		for (int i = 0; i < ans.length; i++) {
//			for (int j = 0; j < str1.length; j++) {
//				ans[i] = str1[j];
//			}
//			for (int j = 0; j < str2.length; j++) {
//				ans[i] = str2[j];
//			}
//		}
//
//		Set<String> set = new HashSet<>();
//
//		for (int i = 0; i < ans.length; i++) {
//			for (int j = i + 1; j < ans.length; j++) {
//				if (ans[i].equalsIgnoreCase(ans[j])) {
//					set.add(ans[i]);
//					break;
//				}
//			}
//		}
//		System.out.println("repeated String count= " + set.size());

//		int i=20+ +9- -12+ +4- -13+ +19;  
//		System.out.println(i);

//	 String s1 = "Java";  
//	 String s2 = "Java";  
//	 StringBuilder sb1 = new StringBuilder(s2);  
//	 sb1.append("Ja").append("va");  
//	 System.out.println(s1 == s2);  
//	 System.out.println(s1.equals(s2));  
//	 System.out.println(sb1.toString() == s1);  
//	 System.out.println(sb1.toString().equals(s1));  
//	 | 
//	 | 1. true is printed out exactly once.
//	 | 2. true is printed out exactly twice.
//	 | 3. true is printed out exactly three times.
//	 | 4. true is printed out exactly four times.
//	 | 5. The code does not compile.
//	 | 
//		HashMap<String, Integer> map = new HashMap<>();
//		map.put("one", 1);
//		map.put("two", 2);
//		map.put("three", 3);
//		map.put("four", 4);
//		
//		HashMap<String, Integer> map2 = new HashMap<>();

//		List<Student> list = new ArrayList<>();
//		Collections.sort(list);

//		int[] arr = {12,15,9,18,5,28,22,26,2};
//		Stack<Integer> stack = new Stack<>();
//		for(Integer i : arr) {
//			stack.push(i);
//		}
//		
//		Stack<Integer> stack2 = new Stack<>();
//		stack2.push(stack.lastElement());
//		stack.pop();
//		
//		for(Integer i : stack) {
//			Stack<Integer> temp = new Stack<>();
//			while(i < stack2.lastElement()) {
//				temp.push(stack2.lastElement());
//				stack2.pop();
//			}
//			for(Integer j : temp) {
//				stack2.push(temp.lastElement());
//				temp.pop();
//			}
//			if(i > stack2.lastElement() ) {
//				stack2.push(i);
//				stack.pop();
//				break;
//			}
//		}
//		return stack2;

//		Scanner scn = new Scanner(System.in);
//
//		String str = "4/16/2022 12:00:00 AM";
//		java.util.Date date = new java.util.Date(str);
//		System.out.println(date.toString());
//		
//		String str = "4/16/2022 12:00:00 AM";
//		ObjectMapper mapper = new ObjectMapper();
//		java.util.Date responsejson;
//		mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
//		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//		
//		responsejson = mapper.readValue(str, java.util.Date.class);

//		LocalDateTime time = LocalDateTime.
		/*
		 * String str = "4/16/2022 12:00:00 AM"; DateTimeFormatter formatter =
		 * DateTimeFormatter.ofPattern("M/dd/yyyy HH:mm aa"); LocalDateTime dateTime =
		 * LocalDateTime.parse(str, formatter); System.out.println("-------" +
		 * dateTime.toString());
		 */

//		int n = scn.nextInt();
		// int m = scn.nextInt();
		// int right = scn.nextInt();

		// benjaminBulbs(n);
		// gcdAndLcm(n, m);
		// lcm(n, m);
		// primeFact(n);

		// printAllPrimes(n);
		// System.out.println(reverseNumber(n));
		// System.out.println(inverseNumber(n));
		// System.out.println(rotateNumber(n, right));

//		scn.close();
	}

	public static void benjaminBulbs(int n) {
		for (int i = 1; i * i <= n; i++) {
			System.out.println(i * i);
		}
	}

	public static void gcdAndLcm(int n, int m) {
		int divisor = m;
		int dividend = n;
		int rem = 1;
		while (rem != 0) {
			rem = dividend % divisor;
			dividend = divisor;
			divisor = rem;
		}
		int lcm = (n * m) / dividend;
		int gcd = dividend;
		System.out.println("lcm = " + lcm + " gcd = " + gcd);
	}

	public static void lcm(int n, int m) {
		int lcm = 1;
		int i = 2;
		while (i <= n && i <= m) {
			while (n % i == 0 && m % i == 0) {
				n /= i;
				m /= i;
				lcm *= i;
			}
			i++;
		}
		lcm *= n * m;
		System.out.println("lcm = " + lcm);
	}

	public static void primeFact(int n) {
		int i = 2;
		while (i * i <= n) {
			while (n % i == 0) {
				n /= i;
				System.out.print(i + " x ");
			}
			i++;
		}
		if (n != 1) {
			System.out.print(n);
		}
	}

	public static void printAllPrimes(int n) {
		if (n == 1) {
			System.out.println("");
		} else {
			for (int i = 2; i <= n; i++) {
				if (checkPrime(i)) {
					System.out.println(i);
				}
			}
		}
	}

	public static boolean checkPrime(int n) {
		if (n == 1) {
			return false;
		} else {
			int sqrt = (int) Math.sqrt(n);
			for (int i = 2; i <= sqrt; i++) {
				if (n % i == 0) {
					return false;
				}
			}
			return true;
		}
	}

	public static void printFibbonacci(int n) {
		int a = 0;
		int b = 1;
		if (n == 1) {
			System.out.println(a);
		} else if (n == 2) {
			System.out.println(a);
			System.out.println(b);
		} else {
			System.out.println(a);
			System.out.println(b);
			for (int i = 1; i <= n - 2; i++) {
				int c = a + b;
				System.out.println(c);
				b = c;
				a = b;
			}
		}
	}

	public static int reverseNumber(int n) {
		int nn = 0;
		while (n > 0) {
			int rem = n % 10;
			nn = (nn * 10) + rem;
			n /= 10;
		}
		return nn;
	}

	public static int inverseNumber(int n) {
		int inv = 0;
		int count = 1;
		while (n > 0) {
			int rem = n % 10;
			inv = inv + (count * (int) Math.pow(10, rem - 1));
			n /= 10;
			count++;
		}
		return inv;
	}

	public static int rotateNumber(int n, int right) {
		int rot = 0;
		int num = n;
		int digits = 0;
		while (num > 0) {
			num /= 10;
			digits++;
		}
		right = right % digits;
		if (right < 0) {
			right += digits;
		}
		int div = (int) Math.pow(10, right);
		int q = n / div;
		int r = n % div;
		rot = r * (int) Math.pow(10, digits - right) + q;
		return rot;
	}

}