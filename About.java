import javax.swing.*;
import java.awt.*;
class About extends JFrame{
	ImageIcon icon;
	About(){ 
		icon = new ImageIcon("appIcon.png");
		this.setIconImage(icon.getImage());
        	JTextArea area=new JTextArea(); 
		JScrollPane scroll = new JScrollPane(area);
        	area.setBounds(20,20,446,390); 
		area.setLineWrap(true);
		area.setWrapStyleWord(true);
		area.setText("Disclamer : \n\n 	       This application is devloped by the student of NITW for the project purpose.Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the \"Software\"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions: \n\n The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.\n\n\nTHE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.\n\n rules : \n\n The universe of the Game of Life is an infinite, two-dimensional orthogonal grid of square cells, each of which is in one of two possible states, alive or dead, (or populated and unpopulated, respectively). Every cell interacts with its eight neighbours, which are the cells that are horizontally, vertically, or diagonally adjacent. At each step in time, the following transitions occur:\n\n      1.   Any live cell with fewer than two live neighbors dies, as if by under population.\n\n      2.   Any live cell with two or three live neighbors lives on to the next generation.\n\n      3.   Any live cell with more than three live neighbors dies, as if by overpopulation.\n\n      4.   Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.\n\n               The initial pattern constitutes the seed of the system. The first generation is created by applying the above rules simultaneously to every cell in the seed; births and deaths occur simultaneously, and the discrete moment at which this happens is sometimes called a tick. Each generation is a pure function of the preceding one. The rules continue to be applied repeatedly to create further generations."); 
        	this.setSize(500,500);  
        	this.setLayout(null);  
        	this.setVisible(true); 
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		this.setTitle("About");
		this.setLayout(new CardLayout(40,30));
		this.add(scroll);
	}
}