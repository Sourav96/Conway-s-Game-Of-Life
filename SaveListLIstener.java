import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
class SaveListListener implements ActionListener{
	Platform pl;
	SaveListListener(Platform pl){
		this.pl=pl;
	}
	public void actionPerformed(ActionEvent ae){
		JComboBox jcb=(JComboBox)ae.getSource();
                String selected =jcb.getItemAt(jcb.getSelectedIndex()).toString();
		Cell[][] cell=pl.getCells();
		try{
			BufferedReader br=new BufferedReader(new FileReader(new File("./creatures/"+selected)));
			String readBuffer="";
			int ch;
			while((ch=br.read())!=-1){
				readBuffer+=(char)ch;
			}
			br.close();
			StringTokenizer st = new StringTokenizer(readBuffer,"\n");
			int size=st.countTokens();
			for(int i=0;i<size;i++){
				StringTokenizer sst=new StringTokenizer(st.nextToken()," ");
				for(int j=0;j<size;j++){
					if(sst.nextToken().equals("1")){
						cell[i][j].setStatus(true);
					}else{
						cell[i][j].setStatus(false);
					}
				}
			}
			pl.setGrid();
		}catch(IOException ie){
			ie.printStackTrace();
		}
                
	}
}