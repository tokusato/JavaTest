package free;


public class Test {

	public static void main(String args[]){
		//16真数表記をint型に変換する
		int num = 0xa;
		System.out.println(num);
		//int型を16進数表記に変換する Integerクラスのコンストラクタに10進数表記の整数を挿入
		int num2 = 10;
		System.out.println(Integer.toHexString(num2));

	}
}
