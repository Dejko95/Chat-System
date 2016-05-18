package chat_system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientApp extends JFrame {
	JTextArea area;
	
	public ClientApp(Client client) {
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Chat");
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		//JPanel pnl = new JPanel();
		//pnl.setBackground(Color.WHITE);
		//add(pnl);
		//pnl.setLayout(null);
		
		area = new JTextArea();
		add(area);
		
		JTextField tf = new JTextField();
		//tf.setBounds(100, 100, 100, 20);
		tf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				client.sendMessage(tf.getText());
				tf.setText("");
			}
		});
		add(tf, BorderLayout.SOUTH);
		
		//pnl.setBackground(Color.RED);
	}
	
	public void printMessage(String message) {
		area.append(message + "\n");
	}
}
