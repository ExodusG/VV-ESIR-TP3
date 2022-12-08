package fr.istic.vv;

public class StringUtils {

    private StringUtils() {}

      public static boolean isBalanced(String str) {
        		LinkedList<Character> list = new LinkedList<Character>();
        		for(int i=0;i<str.length();i++) {
        			char operator=str.charAt(i);
        			if(operator=='(' || operator=='[' || operator =='{') {
        				list.addLast(operator);
        			}else {
        				if(!list.isEmpty()) {
        					char last=list.peekLast();
        					if(last=='(' && operator==')') {
        						list.removeLast();
        					}

        					if(last=='[' && operator==']') {
        						list.removeLast();
        					}

        					if(last=='{' && operator=='}') {
        						list.removeLast();
        					}
        				}else {
        					return false;
        				}

        			}
        		}
        		return list.isEmpty();
        	}

}
