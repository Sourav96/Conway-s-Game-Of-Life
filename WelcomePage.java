import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class WelcomePage extends JFrame{
	ImageIcon icon;
	JLabel gameName;
	JButton start;
	JComboBox frameSize,cellnumber;
	int fsize=500,cnum=50;
	WelcomePage(){
		this.setLayout(new FlowLayout());

		start=new JButton("Start");
		start.setBounds(200,300,80,40);
		start.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				Platform pl=new Platform(fsize,cnum);
				dispose();
			}
		});
		gameName=new JLabel("Conwey's  game of life");
		gameName.setBounds(0,30,500,150);
		gameName.setHorizontalAlignment(SwingConstants.CENTER);
		gameName.setVerticalAlignment(SwingConstants.CENTER);
		gameName.setFont(new Font("YU Gothic UI", Font.PLAIN, 45));
		String size[]={"50","100","200","500","750"};
		JComboBox<String> frameSize=new JComboBox<String>(size);
		frameSize.setBounds(100,200,80,40);
		frameSize.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				JComboBox jcb=(JComboBox)ae.getSource();
               		 	String selected =jcb.getItemAt(jcb.getSelectedIndex()).toString();
				fsize=Integer.parseInt(selected);
				
			}
		});
		String num[]={"50","70","100","150"};
		JComboBox<String> cellNum=new JComboBox<String>(num);
		cellNum.setBounds(400,200,80,40);
		cellNum.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				JComboBox jcb=(JComboBox)ae.getSource();
               		 	String selected =jcb.getItemAt(jcb.getSelectedIndex()).toString();
				cnum=Integer.parseInt(selected);
			}
		});
		this.add(gameName);
		this.add(frameSize);
		this.add(start);
		this.add(cellNum);


		this.setSize(500,150);
		this.setTitle("Conwey's game of life");
		icon = new ImageIcon("appIcon.png");
		this.setIconImage(icon.getImage());
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}