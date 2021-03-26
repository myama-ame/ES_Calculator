import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Scrollbar;

public class Work extends JFrame {

	private JPanel contentPane;
	private JTextField nowP;
	private JTextField goalP;
	private JTextField dDay;
	private JTextPane printOut = new JTextPane();
	
	private int goalPoint = 0, day = 0;
	private double nowPoint = 0.0, oneDayPoint = 0.0;

	private class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String s = "";
			
			nowPoint = Integer.parseInt(nowP.getText());
			goalPoint = Integer.parseInt(goalP.getText());
			day = Integer.parseInt(dDay.getText());
			
			oneDayPoint = (goalPoint - nowPoint) / (double)day;
			
			s = "하루 목표 달성량은 " + String.valueOf(oneDayPoint) + "pt입니다\n";
			printOut.setText(s);
			
			for (int i = day - 1; i > 0; i--) {
				nowPoint += oneDayPoint;
				s = printOut.getText() + "D-" + String.valueOf(i) + "     " + String.valueOf(nowPoint) + "\n";
				printOut.setText(s);
			}
			
			nowPoint += oneDayPoint;
			s = printOut.getText() + "D-day " + String.valueOf(nowPoint) + "\n";
			printOut.setText(s);
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Work frame = new Work();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Work() {
		setTitle("\uC774\uBCA4\uD2B8 \uD3EC\uC778\uD2B8 \uACC4\uC0B0\uAE30");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 364, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		nowP = new JTextField();
		nowP.setBounds(96, 10, 116, 21);
		panel.add(nowP);
		nowP.setColumns(10);
		
		JLabel label = new JLabel("\uD604\uC7AC \uD3EC\uC778\uD2B8");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(22, 13, 73, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("\uBAA9\uD45C \uD3EC\uC778\uD2B8");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(22, 45, 73, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\uB0A8\uC740 \uC77C\uC218");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(22, 77, 73, 15);
		panel.add(label_2);
		
		goalP = new JTextField();
		goalP.setColumns(10);
		goalP.setBounds(96, 42, 116, 21);
		panel.add(goalP);
		
		dDay = new JTextField();
		dDay.setColumns(10);
		dDay.setBounds(96, 74, 116, 21);
		panel.add(dDay);
		
		JButton bt = new JButton("\uACC4\uC0B0\uD558\uAE30");
		bt.setBounds(228, 73, 97, 23);
		panel.add(bt);
		bt.addActionListener(new MyActionListener());
		
		printOut.setBounds(22, 106, 303, 145);
		panel.add(printOut);
		
		JScrollPane scrollbar = new JScrollPane(printOut);
		scrollbar.setBounds(22, 106, 303, 145);
		panel.add(scrollbar);		
	}
}
