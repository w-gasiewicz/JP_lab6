//bia³e t³o
//rozciaganie
//start z tego samego msc
package figury;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AnimatorApp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					final AnimatorApp frame = new AnimatorApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param delay 
	 */
	public AnimatorApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int ww = 550, wh = 300;
		setBounds((screen.width-ww)/2, (screen.height-wh)/2, ww, wh);
		contentPane = new JPanel();
		
		GridBagConstraints c = new GridBagConstraints();

		setContentPane(contentPane);
		contentPane.setLayout(new GridBagLayout());
		//contentPane.setLayout(null);
		AnimPanel kanwa = new AnimPanel();
		//kanwa.setSize(450, 211);
		
		c.gridx=0;
		c.gridy=0;
		c.weightx=1.0;
		c.weighty=1.0;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.fill = GridBagConstraints.BOTH;
		contentPane.add(kanwa,c);
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				kanwa.initialize();
				kanwa.setBackground(Color.WHITE);
			}
		});

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.addFig();
				kanwa.setBackground(Color.WHITE);
			}
		});
		btnAdd.setBounds(10, 239, 80, 23);
		c.gridx=1;
		c.gridy=1;
		c.anchor = GridBagConstraints.PAGE_END;
        c.fill = GridBagConstraints.BOTH;
		contentPane.add(btnAdd);
		
		JButton btnAnimate = new JButton("Animate");
		btnAnimate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				kanwa.animate(); 
				kanwa.setBackground(Color.WHITE);
			}
		});
		btnAnimate.setBounds(100, 239, 90, 23);
		c.gridx=1;
		c.gridy=1;
		c.anchor = GridBagConstraints.PAGE_END;
        c.fill = GridBagConstraints.BOTH;
		contentPane.add(btnAnimate);
		
	}

}
