package thread;

/*
 * lam bai toan dua ngua:
 * co 10 con ngua cung xuat phat cung luc
 * cu sau nua giay, moi con se chay mot buoc la mot so int random tu 1 den 10
 * neu con ngua nao co quang duong bang tong cac buoc chay bang dung 100 thi con ngua do se ve dich va in ra
 * Con ngua thu xxx da ve dich voi yyy buoc chay.
 */
public class Horse {

	public static void main(String args[]) {

		ThreadHorse[] object=new ThreadHorse[10];
		for(int i=0;i<object.length;i++){
			object[i]=new ThreadHorse("Con ngua thu "+(i+1));
			object[i].start();
		}				
	}
}
