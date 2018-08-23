import java.awt.event.*;
class SettingListener implements ActionListener{
	private Platform pl;
	public SettingListener(Platform pl){
		this.pl=pl;
	}
	public void actionPerformed(ActionEvent ae){
		SettingMenu sm=new SettingMenu(pl);
		sm.setVisible(true);
	}
}