import model.*;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;

public class Orderpanel extends JPanel {
 private JButton paybtn;
 private Za za;
 
    public Orderpanel(Za za, Summarypanel summary, ButtonPanel button) {
    	this.za = za;
    	setup();
    	build(za, summary , button);
    }
    
    public void setup(){
    	setBorder(BorderFactory.createLineBorder(Color.blue));
        setLayout(new GridLayout(1,1)); 
    }
    
    public void build(Za za, Summarypanel summary,ButtonPanel button){
    	     
    	        Box verticalBox = Box.createVerticalBox();
    	        verticalBox.add(button);
    	        verticalBox.add(summary);
                add(verticalBox); 
    }
 
}