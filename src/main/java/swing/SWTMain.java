package swing;

import static javax.swing.JFrame.*;

import javax.swing.JFrame;

public class SWTMain {
	/** frame */
	static JFrame frame;
	public static void main(String[] args) {


	}

	/** クラスの全箇所から参照する予定なので、staticイニシャライザでフレームを設定 */
	static{
		frame = new JFrame();
		frame.setTitle("appliaction");
		frame.setSize(100, 200);
		frame.setVisible(Boolean.TRUE);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//this parameter set the SWT to monitor central
		frame.setLocationRelativeTo(null);
	}
}
