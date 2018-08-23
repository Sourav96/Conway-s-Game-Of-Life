import java.awt.event.*;
class SpeedUpListener implements ActionListener{
	private Platform pl;
	private int speed;
	public SpeedUpListener(Platform pl){
		this.pl=pl;
	}
	public void actionPerformed(ActionEvent ae){
		Thread t1=new Thread(new Runnable(){
			public void run(){
				if(pl.getSpeed()>10)
				pl.setSpeed(pl.getSpeed()/2);
			}
		});
		t1.start();
	}
}