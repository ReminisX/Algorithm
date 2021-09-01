package algorithm;

public class DecodeString {
	public String decodeString(String s) {
		char[] c = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		StringBuilder num = new StringBuilder();
		StringBuilder abc = new StringBuilder();
		for (int i = 0; i < c.length;) {
			if(c[i] >= 48 && c[i] <= 57) {
				num.append(c[i]);
				i++;
			}
			if(c[i] == '[') {
				i++;
			}
			while(c[i] >= 97 && c[i] <= 122) {
				abc.append(c[i]);
				i++;
			}
			if(c[i] == ']') {
				int k = Integer.parseInt(num.toString());
				for (int j = 0; j < k; j++) {
					sb.append(abc.toString());
				}
				num.delete(0, num.length());
				abc.delete(0, abc.length());
				i++;
			}
			
		}
		return sb.toString();
    }
	
	public static void main(String[] args) {
		String s = "1[a]2[b]3[c]";
		DecodeString D = new DecodeString();
		String res = D.decodeString(s);
		System.out.println(res);
	}
	
}
