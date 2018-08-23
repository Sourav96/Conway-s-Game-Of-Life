import java.awt.event.*;
class PlayListener implements ActionListener{
	private Platform pl;
	private Cell[][] cell;
	private int numCell,speed,count,prevCount;
	private boolean[][] prevStatus;
	boolean liveRule[],deathRule[];
	public PlayListener(Platform pl){
		this.pl=pl;
		this.cell=pl.getCells();
		this.prevStatus=pl.getPrevStatus();
		this.numCell=pl.getNumCell();
		this.speed=pl.getSpeed();
	}
	public void actionPerformed(ActionEvent ae){
		Thread t1=new Thread(new Runnable(){
			public void run(){
				int counter=0;
				while(true){
					count=0;
					prevCount=0;
					for(int i=0;i<numCell;i++){
						for(int j=0;j<numCell;j++){
							if(cell[i][j].getStatus())prevCount++;
							prevStatus[i][j]=cell[i][j].getStatus();
						}
					}
					if(prevCount==0)break;
					for(int i=0;i<numCell;i++){
						for(int j=0;j<numCell;j++){
							counter=0;
							if(i>=1&&j>=1)if(prevStatus[i-1][j-1])counter++;
							if(i>=1)if(prevStatus[i-1][j])counter++;
							if(i>=1&&j<numCell-1)if(prevStatus[i-1][j+1])counter++;
							if(j>=1)if(prevStatus[i][j-1])counter++;
							if(j<numCell-1)if(prevStatus[i][j+1])counter++;
							if(i<numCell-1&&j>=1)if(prevStatus[i+1][j-1])counter++;
							if(i<numCell-1)if(prevStatus[i+1][j])counter++;
							if(i<numCell-1&&j<numCell-1)if(prevStatus[i+1][j+1])counter++;
							boolean cellInstStatus=cell[i][j].getStatus();
							cell[i][j].setStatus(false);
							for(int k=1;k<9;k++){
								if(pl.getSurviveRuleInst(k)){
									if(k==counter){
										if(cellInstStatus){
											cell[i][j].setStatus(true);
											count++;
										}
										else cell[i][j].setStatus(false);
									}
								}
							}
							for(int k=1;k<9;k++){
								if(pl.getBornRuleInst(k)){
									if(k==counter){
										cell[i][j].setStatus(true);
										count++;
									}
								}
							}
						}
					}
					pl.setGrid();
					pl.setGen(pl.getGen()+1);
					pl.setRate(((double)count/(double)prevCount)*100);
					pl.updateLabels();
					try{
						speed=pl.getSpeed();
						Thread.sleep(speed);
					}catch(InterruptedException ie){
						ie.printStackTrace();
					}
				}
			}
		});
		t1.start();
	}
}