import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class SettingMenu extends JFrame{
	JCheckBox survives[];
	JCheckBox born[];
	JLabel deathRule,lifeRule;
	JButton animatedColor,backgroundColor,save;
	JButton email,rateUs,about;
	int checkboxIndex=0;
	ImageIcon icon;
	public SettingMenu(Platform pl){
		survives=new JCheckBox[8];
		born=new JCheckBox[8];
		icon = new ImageIcon("appIcon.png");
		this.setIconImage(icon.getImage());
		for(checkboxIndex=0;checkboxIndex<8;checkboxIndex++){
			survives[checkboxIndex]=new JCheckBox(String.valueOf(checkboxIndex+1));
			born[checkboxIndex]=new JCheckBox(String.valueOf(checkboxIndex+1));
			survives[checkboxIndex].addItemListener(new ItemListener(){
				public void itemStateChanged(ItemEvent ie){
					if(((JCheckBox)ie.getSource()).isSelected())pl.setSurviveRule(Integer.parseInt(((JCheckBox)ie.getSource()).getText().toString()),true);
					else pl.setSurviveRule(Integer.parseInt(((JCheckBox)ie.getSource()).getText().toString()),false);
				}
			});
			born[checkboxIndex].addItemListener(new ItemListener(){
				public void itemStateChanged(ItemEvent ie){
					if(((JCheckBox)ie.getSource()).isSelected())pl.setBornRule(Integer.parseInt(((JCheckBox)ie.getSource()).getText().toString()),true);
					else pl.setBornRule(Integer.parseInt(((JCheckBox)ie.getSource()).getText().toString()),false);
				}
			});
		}
		animatedColor=new JButton("animated color");
		animatedColor.setBounds(20,180,150,20);
		animatedColor.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				ColorMenu cm=new ColorMenu(pl,false);
			}
		});
		backgroundColor=new JButton("background color");
		backgroundColor.setBounds(190,180,150,20);
		backgroundColor.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				ColorMenu cm=new ColorMenu(pl,true);
			}
		});
		email=new JButton("Email");
		email.setBounds(20,250,70,20); 
		rateUs=new JButton("rate us");
		rateUs.setBounds(125,250,110,20);
		rateUs.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				RateUs ru=new RateUs();
			}
		});
		about=new JButton("About");
		about.setBounds(270,250,70,20);
		about.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				About ab=new About();
			}
		});
		save=new JButton("Save");
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				setVisible(false);
				dispose();
			}
		});
		save.setBounds(145,320,70,20);
		lifeRule=new JLabel("Life Rules");
		lifeRule.setBounds(20,20,200,20);
		deathRule=new JLabel("Survive Rules");
		deathRule.setBounds(20,90,200,20);
		for(int i=0;i<8;i++){
			born[i].setBounds(20+(42*i),50,40,30);
			survives[i].setBounds(20+(42*i),120,40,30);
			this.add(survives[i]);
			this.add(born[i]);
			born[i].setSelected(pl.getBornRuleInst(i+1));
			survives[i].setSelected(pl.getSurviveRuleInst(i+1));
		}

		this.add(animatedColor);
		this.add(backgroundColor);
		this.add(email);
		this.add(rateUs);
		this.add(about);
		this.add(deathRule);
		this.add(lifeRule);
		this.add(save);
		
		this.setLayout(null);
		this.setSize(375,400);
		this.setTitle("setting");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}