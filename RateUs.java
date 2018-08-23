import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
public class RateUs extends JFrame{
	ImageIcon icon;
	int numStars=0;
	RateUs(){
		icon = new ImageIcon("appIcon.png");
		this.setIconImage(icon.getImage());
		this.setSize(237,100);
		this.setTitle("Rate us");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent me){
				int x=me.getX();
				String rating="";
				int ratings[]=new int[5],index=0;
				try{
					BufferedReader bin = new BufferedReader(new FileReader("rating.txt"));
					int ch;
					while((ch=bin.read())!=-1){
						rating+=(char)ch;
					}
					bin.close();
				}catch(IOException ie){
					ie.printStackTrace();
				}	
				StringTokenizer st=new StringTokenizer(rating," ");
				int size=st.countTokens();
				for(int i=0;i<size;i++){
					ratings[i]=Integer.parseInt(st.nextToken());
				}
				if(x<20){}
				else if(x<60)ratings[0]++;
				else if(x<100)ratings[1]++;
				else if(x<140)ratings[2]++;
				else if(x<180)ratings[3]++;
				else if(x<220)ratings[4]++;
				else ratings[4]++;
				rating="";
				for(int i=0;i<5;i++){
					rating+=String.valueOf(ratings[i]);
					rating+=" ";	
				}
				try{
					BufferedWriter bw = new BufferedWriter(new FileWriter("rating.txt"));
					bw.write(rating);
					bw.close();
				}catch(IOException ie){
					ie.printStackTrace();
				}
				setVisible(false);
				dispose();
			}
			public void mouseEntered(MouseEvent me){}
			public void mouseExited(MouseEvent me){}
			public void mousePressed(MouseEvent me){} 
			public void mouseReleased(MouseEvent me){}  
		});
		this.addMouseMotionListener(new MouseMotionListener(){
			public void mouseDragged(MouseEvent me){}  
			public void mouseMoved(MouseEvent me){
				int x=me.getX();
				if(x<20)numStars=0;
				else if(x<60)numStars=1;
				else if(x<100)numStars=2;
				else if(x<140)numStars=3;
				else if(x<180)numStars=4;
				else if(x<220)numStars=5;
				else numStars=5;
				repaint();	
			} 
		});
	}
	int[][] getStar(int x,int y,int rad){
		int[][] points =new int[2][5];
		for(int i=0;i<5;i++){
			points[0][i]=x+(int)(rad*(Math.cos((i+1)*720)));
			points[1][i]=y+(int)(rad*(Math.sin((i+1)*720)));
		}
		return points;
	}
	public void paint(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(0,0,237,100);
		g.setColor(new Color(230,230,230));	
		for(int i=0;i<5;i++){
			int[][] points=getStar((40*(i+1)),60,20);
			g.drawPolygon(new Polygon(points[0],points[1],5));
		}
		g.setColor(new Color(255,215,0));
		for(int i=0;i<numStars;i++){
			int[][] points=getStar((40*(i+1)),60,20);
			g.fillPolygon(new Polygon(points[0],points[1],5));
		}
	}
}