class Cell{
	private int x,y,size;
	private boolean status;
	public Cell(){
		this.x=0;
		this.y=0;
		this.size=0;
		this.status=false;
	}
	public void setXYS(int x,int y,int size){
		this.x=x;
		this.y=y;
		this.size=size;
	}
	public void setStatus(boolean status){
		this.status=status;
	}
	public void alterStatus(){
		if(status)status=false;
		else status=true;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getSize(){
		return size;
	}
	public boolean getStatus(){
		return status;
	}
}
	
		