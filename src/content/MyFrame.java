package content;

import java.awt.*;
import javax.swing.*;

/* Specializzazione di JFrame:
 * - JFrame è Serializable!
 * - Il costruttore accetta titolo e layout-manager
 * - Si aggiunge il JPanel
 * - Un metodo getMainPanel() ci dà il pannello
 */
public class MyFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel jp;
	
	public MyFrame(String title, LayoutManager lm){
		super(title); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(320,320);
		// Il layout-manager può essere passato al costruttore di JPanel
		this.jp = new JPanel(lm);
		this.getContentPane().add(this.jp);
		this.setResizable(false);
    	this.setSize(800, 800);
    	this.setVisible(true);
	}
	
	public JPanel getMainPanel(){
		return this.jp;
	}

}
