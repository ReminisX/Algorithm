package algorithm;

public class IsMatch {
	
	public boolean isMatch(String s, String p) {
		//  ÊäÈëÄ£Ê½´®pºÍ×Ö·û´®s£¬ÅĞ¶ÏsÓëpÊÇ·ñÆ¥Åä
		char[] sc = s.toCharArray();
		char[] pc = p.toCharArray();
		int j = 0;
		//  ÊäÈëÎª¿ÕÅĞ¶Ï
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
			//  ×ÖÄ¸Æ¥Åä
			if(pc[i] >= 97 && pc[i] <= 122) {
				//  ÖØ¸´×Ö·ûÆ¥Åä
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
				// Õı³£×ÖÄ¸Æ¥Åä
				if(pc[i] == sc[j]) {
					j++;
					continue;
				}else {
					return false;
				}
			}
			//  ÈÎÒâ×Ö·ûÆ¥Åä
			if(pc[i] == '.') {
			//  ÖØ¸´×Ö·ûÆ¥Åä
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
		//  ×îÖÕ½á¹ûÅĞ¶Ï
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
