package swt;

import static java.util.logging.Level.*;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SendThread  extends JFrame implements ActionListener, Runnable{

	private final String panelName;
	private JButton send;

	//parameters for sending data
	/** time unit -> second */
	private static int sendingInterval;
	/** destination inet address */
	private static InetAddress netAddress;
	private static int port;
	private static final int DEFAULT_SENDING_INTERVAL = 1;
	private static final int DEFAULT_PORT = 12345;
	/** Logger for Sending Thread */
	private static final Logger SENDING_LOGGER =
								Logger.getLogger("SENDING_LOGGER");
	/** SimpleDateFormat for Logger Class */
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	// -> couldn't set static member using method that throws exception

	//static initializer for setting default sending parameters
	static {
		sendingInterval = DEFAULT_SENDING_INTERVAL;
		try {
			netAddress = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		port = DEFAULT_PORT;
	}

	//constructor
	public SendThread(String panelName) {
		super(panelName);
		this.panelName = panelName;

		Container c=getContentPane();
		c.setLayout(new GridLayout(3,2));

		//将来的には、設定値などを用いて送信間隔や、送信データの種類を調整できるようにする

		send=new JButton("Send");
		send.addActionListener(this);
		Font f3=new Font("Bookman Old Style",Font.ITALIC,30);
		send.setFont(f3);

		c.add(new JLabel(""));c.add(new JLabel(""));
		c.add(new JLabel(""));c.add(new JLabel(""));
		c.add(new JLabel(""));c.add(send);
		setSize(800, 500);
		setLocation(300,100);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);


		// setting for runnable thread


	}

	@Override
	/**
	 * @author toku
	 * @param ActionEvent
	 * @return void
	 * <br>
	 *	eventlistener for the buttons
	 * */
	public void actionPerformed(ActionEvent ae)
	{
		//single thread
		if(ae.getSource().equals(send)){
			//送信スレッドの実行
			ExecutorService es = Executors.newSingleThreadExecutor();
			es.execute(this);
		}
	}

	@Override
	/**
	 * @author toku
	 * @return none
	 * @param none
	 *
	 * */
	// データ送信用のスレッド
	// ユーザ設定値に基づいてデータを送信する。
	public void run(){

		//TODO running until the thread is interrupted by another thread (induced by abortButton)

		boolean safelyStopped = false;
		String logMessage;

		//trace log
		initLog();

		//sending by using rmi client


		while (true){
			try {

				//sending data
				Thread.sleep(sendingInterval);
			} catch (InterruptedException ie){

				//TODO judge that this sending thread stopped safely
				if (true){
					safelyStopped = true;
				}
				//TODO show popup messages that the sending thread stoped normally
				logMessage = safelyStopped ? "STOPPED SAFELY" : "COULDN'T STOP SAFELY";
				if (safelyStopped)	SENDING_LOGGER.log(INFO, logMessage);
				else SENDING_LOGGER.log(WARNING, logMessage);;
				//breaking this sending while loop
				break;
			}
		}
	}


	/**
	 * @author toku
	 * @param nothing
	 * */
	private void initLog() {
		SENDING_LOGGER.log(INFO,"Start sending : " + sdf.format(new Date()));
		SENDING_LOGGER.log(INFO,"Parameter info");
		//sending interval
		String strIntervalParameter;
		strIntervalParameter = (String) ((sendingInterval == DEFAULT_SENDING_INTERVAL) ?
				String.valueOf(sendingInterval) + "(default)" : sendingInterval);
		SENDING_LOGGER.log(INFO,strIntervalParameter);
		//TODO other logging parameters
	}



}
