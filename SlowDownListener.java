import java.awt.event.*;
class SlowDownListener implements ActionListener{
	private Platform pl;
	public SlowDownListener(Platform pl){
		this.pl=pl;
	}
	public void actionPerformed(ActionEvent ae){
		Thread t1=new Thread(new Runnable(){
			public void run(){
				pl.setSpeed(pl.getSpeed()*2);
			}
		});
		t1.start();
	}
}