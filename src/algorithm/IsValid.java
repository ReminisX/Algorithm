package algorithm;

public class IsValid {
	public boolean isValid(String s) {
		boolean b = false;
		
		/* ASCII��
		 * {:123 }:125
		 * [:91 ]:93
		 * (:40 ):41
		 * 1���½�ջ��ȷ���ַ����Ƿ�Ϊ�գ����ǿ��򽫵�һ���ַ���ջ
		 * 2����ʼ���ַ������б�����
		 * 2-1�����ַ�����ջ��ƥ�䣬���ջ��
		 * 2-2�����ַ�����ջ����ƥ�䣬�������ջ����
		 * 2-2-1����ջ�������ջ�����ŵȼ��Ƿ���ڵ�����ջ���ŵĵȼ�������������ջ����С���򷵻�false
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
				System.out.println("�ַ������쳣");
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
