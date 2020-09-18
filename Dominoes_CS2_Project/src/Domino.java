import java.util.*;
public class Domino {
	private int pip1;
	private int pip2;
	 public Domino(int s1, int s2) {
		pip1 = s1;
		pip2 = s2;
	 }
	 
	 public int getPip1() {
		 return pip1;
	 }
	 
	 public int getPip2() {
		 return pip2;
	 }
	 
	 public void setPip1(int x) {
		 pip1 = x;
	 }
	 
	 public void setPip2(int x) {
		 pip2 = x;
	 }
	 
	 public boolean isCompatible(Domino d) {
		 return pip1 == d.getPip1() || pip1 == d.getPip2() || pip2 == d.getPip1() || pip2 == d.getPip2();
	 }
	 public boolean isDouble() {
		 return pip1==pip2;
	 }
	 
}
