package mapandcolection;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/*
 * nhap tu ban phim mot cau va cac chu duoc cach nhau boi space
 * vi du: Ha noi oi ha noi oi
 * hay xac dinh va in ra ban phim so xuat hien cua cac tu:
 * vi du: chu ha 2 lan 
 * chu noi 2 lan
 */
public class Example {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Moi ban nhap chuoi can xac dinh so lan xuat hien cua cac chu co trong chuoi: ");
		String s = sc.nextLine();
		String[] s1 = s.split(" ");
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String x : s1) {
			String s2 = x.toLowerCase();
			if (map.containsKey(s2)) {
				map.put(s2, map.get(x) + 1);
			} else {
				map.put(s2, 1);
			}
		}
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
}
