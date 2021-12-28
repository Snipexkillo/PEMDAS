import java.util.ArrayList;
import java.util.Arrays;
public class PEMDAS {
	private String equation;
	
	public PEMDAS() {
		equation = null;
	}
	
	public void setEquation(String input) {
		equation = input;
	}
	
	public String solveEquation(String equation) {
		String eq = equation;
		while(eq.indexOf("(")!=-1) {//how do I do this, and how do I do exponents
			int count = 0;
			int start = -1, end = eq.length()-1;
			for(int i = 0; i<eq.length()-1;i++) {
				if(eq.charAt(i)=='('){
					count++;
					if(start==-1) {
						start = i;
					}
					
				}else if(eq.charAt(i)==')'){
					count--;
					if(end == eq.length()-1) {
						end = i;
					}
					if(count == 0) {
						break;
					}
				}
				
			}
			eq = eq.substring(0,start) + solveEquation(eq.substring(start+1,end))+eq.substring(end+1);
		}
	
		while(eq.indexOf('^')!=-1) {
			int start = -1, end = eq.length(), charPos = 0;
			for(int i = 0; i<eq.length();i++) {
				if(eq.charAt(i)<48) {
					if(charPos==0) {
						start = i;
					}else {
						end = i;
						break;
					}
				}else if(eq.charAt(i)=='^') {
					charPos = i;
				}
			}
			
			eq = eq.substring(0,start+1) + String.valueOf(Math.pow(Double.valueOf(eq.substring(start+1,charPos)),Double.valueOf(eq.substring(charPos+1,end))))+ eq.substring(end);
			
		}
		
		ArrayList<Character> addSubtractOrder = new ArrayList<Character>();
		ArrayList<String> addSubtract = new ArrayList<String>(Arrays.asList(eq.split("\\+|-")));

		for(int i = 0; i < eq.length() ;i++) {//adds all the + and - to the list in order
			if(eq.charAt(i)=='+'||eq.charAt(i)=='-') {

				addSubtractOrder.add(eq.charAt(i));
				
			}
		}
		for(int i = 0;i<addSubtract.size();i++) {
			addSubtract.set(i, multiplyDivide(addSubtract.get(i)));
		}
		while(addSubtract.size()>1) {//goes through the numbers one by one and does the operations
			
			if(addSubtractOrder.get(0)=='+') {
				addSubtract.set(0, String.valueOf(Double.valueOf(addSubtract.get(0))+Double.valueOf(addSubtract.get(1))));
			}else {
				addSubtract.set(0, String.valueOf(Double.valueOf(addSubtract.get(0))-Double.valueOf(addSubtract.get(1))));
			}
			addSubtract.remove(1);
			addSubtractOrder.remove(0);
			
		}
		return addSubtract.get(0);
	}
	
	private String multiplyDivide(String eq) {
		ArrayList<String> multiplyDivide = new ArrayList<String>(Arrays.asList(eq.split("\\*|/")));
		ArrayList<Character> multiplyDivideOrder = new ArrayList<Character>();
		for(int i = 0; i < eq.length() ;i++) {//adds all the * and / to the list in order
			if(eq.charAt(i)<'0') {
				multiplyDivideOrder.add(eq.charAt(i));
			}
		}
		while(multiplyDivide.size()>1) {//goes through the numbers one by one and does the operations
			if(multiplyDivideOrder.get(0)=='*') {
				multiplyDivide.set(0, String.valueOf(Double.valueOf(multiplyDivide.get(0))*Double.valueOf(multiplyDivide.get(1))));
			}else {
				multiplyDivide.set(0, String.valueOf(Double.valueOf(multiplyDivide.get(0))/Double.valueOf(multiplyDivide.get(1))));
			}
			multiplyDivide.remove(1);
			multiplyDivideOrder.remove(0);
		}
		return multiplyDivide.get(0);
	}
	
	public String solveEquation() {
		return this.solveEquation(equation);
	}
}
