import java.util.Scanner;

public class Console {
	
	static Scanner scan;
	
	public static void open() {
		scan = new Scanner(System.in);
	}
	
	public static int getInt(String msg) {
		
		int result;
		
		System.out.println(msg);
		
		result = scan.nextInt();
		
		scan.nextLine();
		
		return result;
		
	}
	
	public static String getString(String msg) {
		
		String result = "";
		
		System.out.println(msg);
		
		result = scan.nextLine();
		
		return result;
		
	}
	
	public static boolean getBoolean(String msg) {
		
		boolean result;
		
		System.out.println(msg);
		
		while(true) {
		
			System.out.println("Type yes or no");
			
			String answer = scan.next();
			
			if(answer.equalsIgnoreCase("yes")) {
				
				result = true;
				break;
				
			}else if(answer.equalsIgnoreCase("no")) {
				
				result = false;
				break;
				
			}
		}
		
		return result;
		
	}
	
	public static void close() {
		scan.close();
	}
	
}
