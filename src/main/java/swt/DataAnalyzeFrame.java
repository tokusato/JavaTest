package swt;


import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class DataAnalyzeFrame extends JFrame implements ActionListener
{


	private JButton sendButton, receiveButton, newFeature1, newFeature2;

	public DataAnalyzeFrame(String title)
	{
		super(title);
		Container c=getContentPane();
		c.setLayout(new GridLayout(5,2));

		//to kick up Data Sending Thread
		sendButton=new JButton("Sending Thread");
		sendButton.addActionListener(this);

		//to kick up Data Receiving Thread
		Font f3=new Font("Bookman Old Style",Font.ITALIC,30);
		sendButton.setFont(f3);

		receiveButton=new JButton("Receiving Thread");
		receiveButton.addActionListener(this);

	 	receiveButton.setFont(f3);

		newFeature1=new JButton("Soon Comming1");
		newFeature1.addActionListener(this);


		newFeature1.setFont(f3);

		newFeature2=new JButton("Soon Comming2");
		newFeature2.addActionListener(this);


		newFeature2.setFont(f3);

		c.add(new JLabel(""));c.add(new JLabel(""));
		c.add(sendButton);c.add(receiveButton);
		c.add(new JLabel(""));c.add(new JLabel(""));
		c.add(newFeature1);c.add(newFeature2);
		c.add(new JLabel(""));c.add(new JLabel(""));

		setSize(800, 500);
		setLocation(300,100);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae)
	{

		// this is just for test
		if(ae.getSource()==newFeature1)
			new Register("Registration");

		// action event for sending thread
		//TODO check the condition (receive thread must started first)
		if (ae.getSource() == sendButton)
			new SendThread("データ送信用スレッド");



//
//		if(ae.getSource()==binfo)
//		{
//			new AccountInfo();
//		}
//
//		if(ae.getSource()==btransfer)
//		{
//			new FundTransfer(" Fund Transfer");
//		}
//
//		if(ae.getSource()==bdebit)
//		{
//			new Debit(" Debit...");
//		}
//
//		if(ae.getSource()==bcredit)
//		{
//			new Credit(" Credit...");
//		}
//
//		if(ae.getSource()==bdelete)
//		{
//			new DeleteAccount(" Delete Account...");
//		}
//
//		if(ae.getSource()==bcheque)
//		{
//			new ChequeBook(" Cheque Details... ");
//		}
//
//		if(ae.getSource()==bdraft)
//		{
//			new Draft(" Draft Details... ");
//		}
	}



	public static void main(String args[])
	{

              new DataAnalyzeFrame(" Signed Operator... ");

	}
}


