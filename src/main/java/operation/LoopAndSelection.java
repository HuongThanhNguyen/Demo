package operation;
/**
 * Cho nhập vào một chuỗi ký tự S chỉ bao gồm [a-z]
 * tìm  chuỗi ký tự đầu tiên chỉ bao gồm các ký tự không bị lặp lại liên tiêls
 * 
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoopAndSelection {

	static Scanner sc = new Scanner(System.in);

	public static void main(String args[]) {

		System.out.println("nhap chuoi ");
		String s = sc.nextLine();
		String s1, s2;
		String s3 = "";
		int count = 0;
		int count1 = 0;
		if (checkString(s) == true) {
			while (count+1 < s.length()) {
				
				s1 = s.substring(count, count + 1);
				s2 = s.substring(count + 1, count + 2);
				if (s1.equals(s2)) {
					count1++;
					count++;
					if (s3 != "") {
						break;
					}
				} else {
					if (count1 != 0) {
						count1=0;
						count++;
					} else if(count1==0){
						count++;
						if(count==s.length()-1){
						s3 = s3.concat(s1);
						s3 = s3.concat(s2);
						}else{
						s3 = s3.concat(s1);
						}
					}
				}
			}
			System.out.println(s3);
		} else {
			System.out.println("Chuoi nhap vao chua chu so");
		}
	}

	static boolean checkString(String s) {
		Pattern pattern = Pattern.compile("^[a-z]*$");
		Matcher matcher = pattern.matcher(s);
		if (!matcher.matches()) {
			return false;
		} else {
			return true;
		}
	}
}
