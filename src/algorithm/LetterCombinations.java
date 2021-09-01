package algorithm;

import java.util.ArrayList;
import java.util.List;

/*
 * 2:abc
 * 3:def
 * 4:ghi
 * 5:jkl
 * 6:mno
 * 7:pqrs
 * 8:tuv
 * 9:wxyz
 * */

public class LetterCombinations {
	public List<String> letterCombinations(String digits) {
		List<String> S = new ArrayList<String>();
		if(digits.length() == 0) {
			return S;
		}
		
		char first_value = digits.charAt(0);
		String digits_cut = digits.substring(1);
		String block = "";
		switch (first_value) {
		case '2':
			block = "abc";
			break;
		case '3':
			block = "def";
			break;
		case '4':
			block = "ghi";
			break;
		case '5':
			block = "jkl";
			break;
		case '6':
			block = "mno";
			break;
		case '7':
			block = "pqrs";
			break;
		case '8':
			block = "tuv";
			break;
		case '9':
			block = "wxyz";
			break;
		default:
			break;
		}
		
		List<String> L_back = this.letterCombinations(digits_cut);
		
		for(int i = 0; i < block.length(); i++) {
			if(L_back.size() == 0) {
				String value = block.charAt(i) + "";
				S.add(value);
				continue;
			}
			for(int j = 0; j < L_back.size();j++) {
				String value = block.charAt(i) + L_back.get(j);
				S.add(value);
			}
		}
		return S;
    }
	
	public static void main(String[] args) {
		LetterCombinations letter = new LetterCombinations();
		String digits = "234";
		List<String> result = letter.letterCombinations(digits);
		System.out.println(result);
	}
	
}
