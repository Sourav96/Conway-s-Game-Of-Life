import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class FileInputBox extends JFrame{
	JTextField input;
	JButton save,cancle;
	String fileName;
	ImageIcon icon;
	FileInputBox(SaveListener sl){
		this.setSize(300,130);
		this.setLayout(null);
		icon = new ImageIcon("appIcon.png");
		this.setIconImage(icon.getImage());
		this.setTitle("Save as");

		input=new JTextField();
		save=new JButton("Save");
		cancle=new JButton("Cancle");
	
		input.setBounds(10,20,250,20);
		save.setBounds(30,50,80,20);
		cancle.setBounds(160,50,80,20);

		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				fileName=input.getText();
				if(fileName!=null&&fileName.length()>2){
					sl.setFileName(fileName);
					sl.saveFile();
					dispose();
				}else{
					dispose();
				}
			}
		});
		cancle.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				dispose();
			}
		});

		this.add(input);
		this.add(save);
		this.add(cancle);

		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
	}
}