import model.*;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;

public class Showpanel extends JPanel implements View {
private Za za;
private JLabel cashlabel, stocklabel;

    public Showpanel(Za za) {
    	this.za = za;
        za.attach(this);
        setup();
        build();
    }
    
    
    private void setup(){
    	setBorder(BorderFactory.createLineBorder(Color.blue));
        setLayout(new FlowLayout());
    }
    
    private void build(){
    Box box = Box.createVerticalBox();
    cashlabel = new JLabel(cashdisplay());
    stocklabel = new JLabel(stockdisplay());
    box.add(Box.createVerticalStrut(50));
    box.add(cashlabel);
    box.add(Box.createVerticalStrut(20));
    box.add(stocklabel);
    add(box);
    update();
    }
    
    private String cashdisplay(){
    	return "Cash is $"+ formatted(za.money());
    }
    
    private String stockdisplay(){
    	return "Toppings = "+ za.stock().size();
    }
    
    public void update(){
    	cashlabel.setText(cashdisplay());
    	stocklabel.setText(stockdisplay());
    	
    }
    
     private String formatted(double amount)
    {   DecimalFormat twoD = new DecimalFormat("###,##0.00");
        return twoD.format(amount); }
}