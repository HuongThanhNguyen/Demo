import java.util.Scanner;

public class OperatorsInJava {
	
	static Integer m, n, i;
	static boolean b;
	static Scanner sc = new Scanner(System.in);

	public static void main(String args[]) {
		System.out.println("input m, n");
		m = sc.nextInt();
		n = sc.nextInt();
		OperatorsInJava oij1 = new OperatorsInJava();
		oij1.showScreen();
	}

	private void showScreen() {
		System.out.println("---------Menu--------");
		System.out.println("1: Postfix");
		System.out.println("2: Unary");
		System.out.println("3: Multiplicative");
		System.out.println("4: Additive");
		System.out.println("5: Shift");
		System.out.println("6: Relational");
		System.out.println("7: Equality");
		System.out.println("8: Bitwise AND");
		System.out.println("9: Bitwise exclusive OR");
		System.out.println("10: Bitwise inclusive OR");
		System.out.println("11: Logical AND");
		System.out.println("12: Logical OR");
		System.out.println("13: Ternary");
		System.out.println("14: assignment");
		int choose = sc.nextInt();
		switch (choose) {
		case 1:
			showScreenPostfix();
			break;
		case 2:
			showScreenUnary();
			break;
		case 3:
			showScreenMultiplicative();
			break;
		case 4:
			showScreenAdditive();
			break;
		case 5:
			showScreenShift();
			break;
		case 6:
			showScreenRelational();
			break;
		case 7:
			showScreenEquality();
			break;
		case 8:
			i = m & n;
			System.out.println("m&n = " + i);
			break;
		case 9:
			i = m ^ n;
			System.out.println("m^n = " + i);
			break;
		case 10:
			i = m | n;
			System.out.println("m|n = " + i);
			break;
		case 11:
			b = (m == 5 && n == 10);
			System.out.println("so sanh m voi 5 va n voi 10 = " + m);
			break;
		case 12:
			b = (m == 5 || n == 10);
			System.out.println("so sanh m voi 5 hoac n voi 10 = " + m);
			break;
		case 13:
			String s = (m == 5) ? "true" : "false";
			System.out.println("kiem tra m = 5 dung hay sai: " + s);
			break;
		case 14:
			showScreenAssignment();
			break;
		default:
			showScreen();
			break;
		}
	}

	private void showScreenPostfix() {
		System.out.println("---------Postfix--------");
		System.out.println("1: expr++");
		System.out.println("2: expr--");
		int choose = sc.nextInt();
		switch (choose) {
		case 1:
			m++;
			System.out.println("m++ = " + m);
			break;
		case 2:
			m--;
			System.out.println("m-- = " + m);
			break;
		default:
			System.out.println("Error");
			showScreenPostfix();
		}
	}

	private void showScreenUnary() {
		System.out.println("---------Unary--------");
		System.out.println("1: ++expr");
		System.out.println("2: --expr");
		System.out.println("3: +expr");
		System.out.println("4: -expr");
		System.out.println("5: ~");
		System.out.println("6: !");
		int choose = sc.nextInt();
		switch (choose) {
		case 1:
			++m;
			System.out.println("++m = " + m);
			break;
		case 2:
			--m;
			System.out.println("--m = " + m);
			break;
		case 3:
			if (m > 0) {
				System.out.println("+m = " + m);
			} else {
				m = -m;
				System.out.println("+m = " + m);
			}
			break;
		case 4:
			if (m < 0) {
				System.out.println("+m = " + m);
			} else {
				m = -m;
				System.out.println("+m = " + m);
			}
			break;
		case 5:
			m = ~m;
			System.out.println("~m = " + m);
			break;
		case 6:
			b = !(m != n);
			System.out.println("!(m!=n) = " + b);
			break;
		default:
			System.out.println("Error");
			showScreenUnary();
		}
	}

	private void showScreenMultiplicative() {
		System.out.println("---------Multiplicative--------");
		System.out.println("1: *");
		System.out.println("2: /");
		System.out.println("3: %");
		int choose = sc.nextInt();
		switch (choose) {
		case 1:
			m = m * n;
			System.out.println("m*n = " + m);
			break;
		case 2:
			m = m / n;
			System.out.println("m/n = " + m);
			break;
		case 3:
			m = m % n;
			System.out.println("m%n = " + m);
			break;
		default:
			System.out.println("Error");
			showScreenMultiplicative();
		}
	}

	private void showScreenAdditive() {
		System.out.println("---------Additive--------");
		System.out.println("1: +");
		System.out.println("2: -");
		int choose = sc.nextInt();
		switch (choose) {
		case 1:
			m = m + n;
			System.out.println("m+n = " + m);
			break;
		case 2:
			m = m - n;
			System.out.println("m-n = " + m);
			break;
		default:
			System.out.println("Error");
			showScreenAdditive();
		}
	}

	private void showScreenShift() {
		System.out.println("---------Shift--------");
		System.out.println("1: >>");
		System.out.println("2: <<");
		System.out.println("3: >>>");
		int choose = sc.nextInt();
		switch (choose) {
		case 1:
			m >>= 2;
			System.out.println("Shift to right 2 units = " + m);
			break;
		case 2:
			m <<= 2;
			System.out.println("Shift to left 2 units = " + m);
			break;
		case 3:
			m >>>= 2;
			System.out.println("shift to right 2 units and add zezo on blank = " + m);
			break;
		default:
			System.out.println("Error");
			showScreenShift();
		}
	}

	private void showScreenRelational() {
		System.out.println("---------Relational--------");
		System.out.println("1: >");
		System.out.println("2: <");
		System.out.println("3: <=");
		System.out.println("4: >=");
		System.out.println("5: instanceof");
		int choose = sc.nextInt();
		switch (choose) {
		case 1:
			b = (m > n);
			System.out.println("m>n = " + b);
			break;
		case 2:
			b = (m < n);
			System.out.println("m<n = " + b);
			break;
		case 3:
			b = (m <= n);
			System.out.println("m<=n = " + b);
			break;
		case 4:
			b = (m >= n);
			System.out.println("m>=n = " + b);
			break;
		case 5:
			b = m instanceof Integer;
			System.out.println(b);
			break;
		default:
			System.out.println("Error");
			showScreenRelational();
		}
	}

	private void showScreenEquality() {
		System.out.println("---------Equality--------");
		System.out.println("1: ==");
		System.out.println("2: !=");
		int choose = sc.nextInt();
		switch (choose) {
		case 1:
			b = (m == n);
			System.out.println("m==n = " + b);
			break;
		case 2:
			b = (m != n);
			System.out.println("m!=n = " + b);
			break;
		default:
			System.out.println("Error");
			showScreenEquality();
			;
		}
	}

	private void showScreenAssignment() {
		System.out.println("---------Assignment--------");
		System.out.println("1: =");
		System.out.println("2: +=");
		System.out.println("3: -=");
		System.out.println("4: *=");
		System.out.println("5: /=");
		System.out.println("6: %=");
		System.out.println("7: &=");
		System.out.println("8: ^=");
		System.out.println("9: |=");
		int choose = sc.nextInt();
		switch (choose) {
		case 1:
			m = n;
			System.out.println("n gan cho m = " + m);
			break;
		case 2:
			m += 2;
			System.out.println("tang m len 2 don vi = " + m);
			break;
		case 3:
			m -= 4;
			System.out.println("giam m xuong 4 don vi = " + m);
			break;
		case 4:
			m *= 2;
			System.out.println("gap doi m = " + m);
			break;
		case 5:
			m /= 2;
			System.out.println("chia doi m" + m);
			break;
		case 6:
			m %= 2;
			System.out.println("m chia lay du cho 2 = " + m);
			break;
		case 7:
			m &= 2;
			System.out.println("m&2 =" + m);
			break;
		case 8:
			m ^= 2;
			System.out.println("m^2 =" + m);
			break;
		case 9:
			m |= 2;
			System.out.println("m|2 =" + m);
			break;
		default:
			System.out.println("Error");
			showScreenAssignment();
		}
	}
}
