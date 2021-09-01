package algorithm;

public class IsMatch {
	
	public boolean isMatch(String s, String p) {
		//  ����ģʽ��p���ַ���s���ж�s��p�Ƿ�ƥ��
		char[] sc = s.toCharArray();
		char[] pc = p.toCharArray();
		int j = 0;
		//  ����Ϊ���ж�
		if(p.isEmpty() && s.isEmpty()) {
			return true;
		}
		if((p.isEmpty() && !s.isEmpty()) || (!p.isEmpty() && s.isEmpty())) {
			return false;
		}
		
		
		for(int i = 0; i < p.length(); i++) {
			if(j >= sc.length) {
				return false;
			}
			//  ��ĸƥ��
			if(pc[i] >= 97 && pc[i] <= 122) {
				//  �ظ��ַ�ƥ��
				if(i+1 < pc.length && pc[i+1] == '*') {
					char c = pc[i];
					i++;
					while(sc[j] == c) {
						j++;
						if(j >= sc.length && i == p.length()-1) {
							return true;
						}
						if(j >= sc.length && i != p.length()-1) {
							return false;
						}
					}
					continue;
				}
				// ������ĸƥ��
				if(pc[i] == sc[j]) {
					j++;
					continue;
				}else {
					return false;
				}
			}
			//  �����ַ�ƥ��
			if(pc[i] == '.') {
			//  �ظ��ַ�ƥ��
				if(i+1 < pc.length && pc[i+1] == '*') {
					i++;
					while(sc[j] >= 97 && sc[j] <= 122) {
						j++;
						if(j >= sc.length && i == p.length()-1) {
							return true;
						}
						if(j >= sc.length && i != p.length()-1) {
							return false;
						}
					}
				}else {
					j++;
				}
			}
		}
		//  ���ս���ж�
		if(j == sc.length) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		IsMatch m = new IsMatch();
		String s = "ab";
		String p = ".*c";
		System.out.println(m.isMatch(s, p));
	}
}
