import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
public class Platform extends JFrame{
	private Cell[][] cell;
	private int size,numCell,cellSize,speed,gen;
	double rate;
	private boolean prevStatus[][];
	public JButton play,speedUp,slowDown,setting,save;
	Color backgroundColor,animatedColor;
	JComboBox<String> fileList;
	JLabel growth,generation;
	boolean bornRule[],surviveRule[];
	ImageIcon icon;
        Platform(int size,int numCell){
		this.bornRule=new boolean[9];
		this.surviveRule=new boolean[9];
		for(int i=0;i<9;i++){
			bornRule[i]=false;
			surviveRule[i]=false;
		}
		bornRule[3]=surviveRule[2]=surviveRule[3]=true;
		icon = new ImageIcon("appIcon.png");
		this.setIconImage(icon.getImage());
		this.backgroundColor=Color.BLACK;
		this.animatedColor=Color.WHITE;
		this.size=size;
		this.numCell=numCell;
		this.speed=1000;
		this.setTitle("Conway's Game of life");
        	this.setSize(size,size+35);
		this.setBackground(Color.black);
        	this.setLayout(null);
		this.addMouseListener(new MouseAdapter(this){
						public void mouseClicked(MouseEvent me){
							Cell[][] cell=pl.getCells();
							boolean[][] prevStatus=pl.getPrevStatus();
							int i=me.getY();
							int j=me.getX();
							int cellSize=pl.getCellSize();
							j/=cellSize;
							i/=cellSize;
							cell[i][j].alterStatus();
							prevStatus[i][j]=cell[i][j].getStatus();
							pl.setGrid();
						}
					});
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		size/=numCell;
		size*=numCell;
		cellSize=size/numCell;

		play=new JButton("play");
		speedUp=new JButton("A");
		slowDown=new JButton("V");
		setting=new JButton("setting");
		save=new JButton("save");
		Vector<String> contents =getVector("contentList.txt");
		fileList = new JComboBox<String>(contents);
		generation=new JLabel("0");
		growth=new JLabel("100%");
			
		play.setMargin(new Insets(0, 0, 0, 0));	
		speedUp.setMargin(new Insets(0, 0, 0, 0));	
		slowDown.setMargin(new Insets(0, 0, 0, 0));	
		setting.setMargin(new Insets(0, 0, 0, 0));	
		save.setMargin(new Insets(0, 0, 0, 0));
		growth.setHorizontalAlignment(SwingConstants.CENTER);
		growth.setVerticalAlignment(SwingConstants.CENTER);
		generation.setHorizontalAlignment(SwingConstants.CENTER);
		generation.setVerticalAlignment(SwingConstants.CENTER);
		
		play.setBounds(1,470,52,22);
		speedUp.setBounds(61,470,52,22);
		slowDown.setBounds(122,470,52,22);
		setting.setBounds(183,470,52,220);
		save.setBounds(244,470,52,22);
		fileList.setBounds(305,470,92,22);
		generation.setBounds(406,470,33,22);
		growth.setBounds(442,470,41,22);

		cell=new Cell[numCell][numCell];
		prevStatus=new boolean[numCell][numCell];
		int setX=0,setY=0;
		for(int i=0;i<numCell;i++){
			setX=0;
			for(int j=0;j<numCell;j++){
				cell[i][j]=new Cell();
				cell[i][j].setXYS(setX,setY,cellSize);
				setX+=cellSize;
				prevStatus[i][j]=false;
			}
			setY+=cellSize;
		}

		play.addActionListener(new PlayListener(this));
		speedUp.addActionListener(new SpeedUpListener(this));
		slowDown.addActionListener(new SlowDownListener(this));
		setting.addActionListener(new SettingListener(this));
		save.addActionListener(new SaveListener(this));
		fileList.addActionListener (new SaveListListener(this));

		this.add(play);
		this.add(speedUp);
                this.add(slowDown);
		this.add(setting);
		this.add(save);
		this.add(fileList);
		this.add(growth);
		this.add(generation);

		this.setVisible(true);
		Graphics g=this.getGraphics();
		g.drawLine(100,100,200,200);
		
   	}
	public Cell[][] getCells(){return cell;}
	public int getCellSize(){return cellSize;}
	public boolean[][] getPrevStatus(){return prevStatus;}
	public int getNumCell(){return numCell;}
	public int getSpeed(){return speed;}
	public void setSpeed(int speed){this.speed=speed;}
	public Color getBackgroundColor(){return backgroundColor;}
	public Color getAnimatedColor(){return animatedColor;}
	public void setBackgroundColor(Color color){this.backgroundColor=color;}
	public void setAnimatedColor(Color color){this.animatedColor=color;}
	public void setBornRule(boolean bornRule[]){this.bornRule=bornRule;}
	public void setBornRule(int index,boolean flag){this.bornRule[index]=flag;}
	public boolean[] getBornRule(){return bornRule;}
	public boolean getBornRuleInst(int index){return bornRule[index];}
	public void setSurviveRule(boolean surviveRule[]){this.surviveRule=surviveRule;}
	public boolean[] getSurviveRule(){return surviveRule;}
	public boolean getSurviveRuleInst(int index){return surviveRule[index];}
	public void setSurviveRule(int index,boolean flag){this.surviveRule[index]=flag;}
	public void setGen(int gen){this.gen=gen;}
	public int getGen(){return gen;}
	public void setRate(double rate){this.rate=rate;}
	public void setGrid(){
		Thread t1=new Thread(new Runnable(){
			public void run(){
				Graphics g=getGraphics();
				for(int i=0;i<numCell;i++){
					for(int j=0;j<numCell;j++){
						if(cell[i][j].getStatus()){
						g.setColor(animatedColor);
						g.fillRect(cell[i][j].getX(),cell[i][j].getY(),cell[i][j].getSize(),cell[i][j].getSize());
					}else{
						g.setColor(backgroundColor);
						g.fillRect(cell[i][j].getX(),cell[i][j].getY(),cell[i][j].getSize(),cell[i][j].getSize());
					}
				}
			}
		}
		});
		t1.start();
	} 
	public void updateLabels(){
		generation.setText(String.valueOf(gen));
		growth.setText(String.valueOf(rate)+"%");
	}
	Vector<String> getVector(String fileName){
		try{
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(fileName)));
				@SuppressWarnings("unchecked")
				Vector<String> contents = (Vector<String>)ois.readObject();
				ois.close();
				return contents;		
		}catch(Exception ie){
			ie.printStackTrace();
		}
		return null;
	}   
}
