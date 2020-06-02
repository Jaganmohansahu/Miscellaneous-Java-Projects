package KeyListener1;
//Catching which key is pressed 
import java.awt.*;
import java.awt.event.*;
class KeyListener1 extends Frame implements KeyListener
{
	TextArea ta;
	String msg="";

	KeyListener1()
	{
		setLayout(new FlowLayout());
		ta = new TextArea(5, 25);

		Font f = new Font("Arial", Font.BOLD, 25);
		ta.setFont(f);
		ta.setBackground(Color.red);

		add(ta);

		ta.addKeyListener(this);

		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
	}
	public void keyPressed(KeyEvent ke)
	{
		int keycode = ke.getKeyCode();
		msg += "\nKey Code: "+keycode;

		String keyname = ke.getKeyText(keycode);
		msg += "\nKey Released: "+keyname;

		ta.setText(msg);
		msg = "";
	}
	public void keyTyped(KeyEvent ke)
	{

	}
	public void keyReleased(KeyEvent ke)
	{
		int keycode = ke.getKeyCode();
		msg += "\nKey Code: "+keycode;

		String keyname = ke.getKeyText(keycode);
		msg += "\nKey Released: "+keyname;

		ta.setText(msg);
		msg = "";
	}
	public static void main(String[] args) 
	{
		KeyListener1 ks = new KeyListener1();

		ks.setTitle("Keyboard Tracker");	
		ks.setSize(400, 400);
		ks.setVisible(true);
	}
}