package algorithm;

public class IsValid {
	public boolean isValid(String s) {
		boolean b = false;
		
		/* ASCII码
		 * {:123 }:125
		 * [:91 ]:93
		 * (:40 ):41
		 * 1、新建栈，确认字符串是否为空，若非空则将第一个字符入栈
		 * 2、开始对字符串进行遍历：
		 * 2-1：若字符串与栈顶匹配，则出栈；
		 * 2-2：若字符串与栈顶不匹配，则进行入栈操作
		 * 2-2-1：入栈操作检测栈顶括号等级是否大于等于入栈括号的等级，若大于则入栈，若小于则返回false
		 * */
		
		Stack S = new Stack(s.length());
		char[] c = s.toCharArray();
		
		if(s == "") {
			return true;
		}else {
			S.push(c[0]);
		}
		
		for(int i = 1;i < s.length(); i++) {
			switch (c[i]) {
			case 123:
				if(S.peek() == 123) {
					S.push(c[i]);
				}
				break;
			case 91:
				if(S.peek() == 91 || S.peek() == 123) {
					S.push(c[i]);
				}
				break;
			case 40:
				if(S.peek() == 91 || S.peek() == 123 || S.peek() == 41) {
					S.push(c[i]);
				}
				break;
			case 125:
				if(S.peek() == 123) {
					S.pop();
				}
				break;
			case 93:
				if(S.peek() == 91) {
					S.pop();
				}
				break;
			case 41:
				if(S.peek() == 40) {
					S.pop();
				}
				break;

			default:
				System.out.println("字符输入异常");
				return false;
			}
		}
		
		if(S.isEmpty()) {
			b = true;
		}
		
		return b;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsValid V = new IsValid();
		String l = "{[]}";
		boolean b;
		b = V.isValid(l);
		System.out.println(b);
	}
}
