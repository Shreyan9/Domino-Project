import java.util.*;
public class e {
public static void main(String[] args) {
	
	System.out.println(recur(32));
}
public static String recur(int val) {
	String dig = ""+(val%3);
	if(val/3 > 0)
		return dig + recur(val/3);
	return dig;
}
}
