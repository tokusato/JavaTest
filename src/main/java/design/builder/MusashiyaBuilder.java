package design.builder;

public class MusashiyaBuilder {

	//
	public Noodle noodle = Noodle.NORMAL;
	public Taste taste = Taste.NORMAL;

	/**
	 * 麺の固さを調整するビルダ
	 * ⇒ビルダクラスのため、クライアント側から当該メソッドの呼び出しは必須ではない。
	 * */
	public void setNoodle(Noodle noodle){
		this.noodle = noodle;
 	}

	/**
	 * 麺の固さを調整するビルダ
	 * ⇒ビルダクラスのため、クライアント側から当該メソッドの呼び出しは必須ではない。
	 * */
	public void setTaste(Taste taste){
		this.taste = taste;
 	}

	public Musashiya getMusashiya(){
		return new Musashiya(noodle, taste);
	}

}
