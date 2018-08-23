import java.awt.event.*;
import java.io.*;
import java.util.*;
class SaveListener implements ActionListener{
	Platform pl;
	FileInputBox fib;
	String fileName;
	SaveListener(Platform pl){
		this.pl=pl;
	}
	public void actionPerformed(ActionEvent ae){
		fib=new FileInputBox(this);
	}
	void setFileName(String fileName){
		this.fileName=fileName;
	}
	void saveFile(){
		Cell[][] cell=pl.getCells();
		int numCell=pl.getNumCell();
		try{
			String writeBuffer="";
			BufferedWriter br=new BufferedWriter(new FileWriter("./creatures/"+fileName+".gol"));
			for(int i=0;i<numCell;i++){
				for(int j=0;j<numCell;j++){
					if(cell[i][j].getStatus()){
						writeBuffer+="1";
					}else{
						writeBuffer+="0";
					}
					writeBuffer+=" ";
				}
				writeBuffer+="\n";
			}
			br.write(writeBuffer);
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("contentList.txt")));
			@SuppressWarnings("unchecked")
			Vector<String> contents = (Vector<String>)ois.readObject();
			ois.close();
			contents.add(fileName+".gol");
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("contentList.txt")));
			oos.writeObject(contents);
			oos.close();
			br.close();
		}catch(Exception ie){
			ie.printStackTrace();
		}
	}
}