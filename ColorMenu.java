import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;  
class ColorChangeListener implements ChangeListener{
	int red,blue,green;
	ColorMenu cm;
	JSlider redSlider,blueSlider,greenSlider;
	Color color;
	boolean backOrAni;
	Platform pl;
	ColorChangeListener(ColorMenu cm,Platform pl,boolean backOrAni){
		this.pl=pl;
		this.cm=cm;
		this.color=color;
		this.backOrAni=backOrAni;
		red=0;blue=0;green=0;
	}
	public void stateChanged(ChangeEvent e) {
		red=cm.redSlider.getValue();
		blue=cm.blueSlider.getValue();
		green=cm.greenSlider.getValue();
		if(backOrAni){
			pl.setBackgroundColor(new Color(red,blue,green));
			cm.setColorboxBackground(red,blue,green);
		}
		else{
			pl.setAnimatedColor(new Color(red,blue,green));
			cm.setColorboxBackground(red,blue,green);
		}
		color=new Color(red,blue,green);
        }
}
class ColorMenu extends JFrame{  
	JLabel 	redLabel,greenLabel,blueLabel,colorBox;
	JSlider redSlider,greenSlider,blueSlider;
	JButton saveButton;
	int red=0,blue=0,green=0;
	Platform pl;
	ImageIcon icon;
	public ColorMenu(Platform pl,boolean backOrAni) {  
		this.pl=pl;
		redLabel=new JLabel("RED");
		redLabel.setBounds(30,0,50,30);
	 	redSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 25);  
		redSlider.setMinorTickSpacing(1);  
		redSlider.setMajorTickSpacing(50);  
		redSlider.setPaintTicks(true);  
		redSlider.setPaintLabels(true); 
		redSlider.setBounds(20,30,200,50);
		redSlider.addChangeListener(new ColorChangeListener(this,pl,backOrAni));

		greenLabel=new JLabel("GREEN");
		greenLabel.setBounds(30,90,50,30);

		blueSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 25);  
		blueSlider.setMinorTickSpacing(1);  
		blueSlider.setMajorTickSpacing(50);  
		blueSlider.setPaintTicks(true);  
		blueSlider.setPaintLabels(true); 
		blueSlider.setBounds(20,130,200,50);
		blueSlider.addChangeListener(new ColorChangeListener(this,pl,backOrAni));


		blueLabel=new JLabel("BLUE");
		blueLabel.setBounds(30,190,50,30);

		greenSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 25);  
		greenSlider.setMinorTickSpacing(1);  
		greenSlider.setMajorTickSpacing(50);  
		greenSlider.setPaintTicks(true);  
		greenSlider.setPaintLabels(true); 
		greenSlider.setBounds(20,220,200,50);
		greenSlider.addChangeListener(new ColorChangeListener(this,pl,backOrAni));


		colorBox =new JLabel("");
		colorBox.setBounds(270,60,80,90);
		colorBox.setOpaque(true);
		colorBox.setBackground(Color.BLUE);

		saveButton=new JButton("Save");
		saveButton.setBounds(270,190,80,30);
		saveButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				setVisible(false);
				dispose();
			}
		});

		this.add(redSlider); 
		this.add(greenSlider);
		this.add(blueSlider); 
		this.add(redLabel);
		this.add(greenLabel);
		this.add(blueLabel);
		this.add(colorBox);
		this.add(saveButton);
		
		icon = new ImageIcon("appIcon.png");
		this.setIconImage(icon.getImage());
		this.setLayout(null); 
		this.setSize(400,350);	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);  
		this.setTitle("Color menu");
	} 
	int getRed(){return red;}
	int getBlue(){return blue;}
	int getGreen(){return green;}
	public void setColorboxBackground(int red,int blue,int green){
		Color newColor=new Color(red,blue,green);
		colorBox.setBackground(newColor);
	}  
}