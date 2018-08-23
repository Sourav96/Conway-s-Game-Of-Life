import java.awt.event.*;
public class MouseAdapter implements MouseListener{
	protected Platform pl;
	public MouseAdapter(Platform pl){
		this.pl=pl;
	}
	public void mouseClicked(MouseEvent me){}
	public void mouseEntered(MouseEvent me){}  
	public void mouseExited(MouseEvent me){}  
	public void mousePressed(MouseEvent me){}  
	public void mouseReleased(MouseEvent me){}
}
/*int j=me.getX();
		int i=me.getY();
		j/=cellSize;
		i/=cellSize;
		cell[i][j].alterStatus();
		s[j].getStatus());
		paint1();*/