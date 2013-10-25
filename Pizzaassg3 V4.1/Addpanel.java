import model.*;
import java.util.*;
import java.text.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;


public class Addpanel extends JPanel implements View   {
private Za za;
private JTextField namefield = new JTextField(5);
private JTextField topsfield = new JTextField(5);
private JTextField pricefield = new JTextField(5);
private JLabel namelabel,topslabel,pricelabel;
private JButton addbutton;
private JButton commitbutton = new JButton("Commit");



    public Addpanel(Za za, ButtonPanel buttonpanel) {
    	this.za = za;
        za.attach(this);
        setup();
        build(buttonpanel);
    }
    
    private void setup(){
    	setBorder(BorderFactory.createLineBorder(Color.blue));
        setLayout(new FlowLayout());
    }
    
    private void build(ButtonPanel buttonpanel){
    	Orderlistener listener = new Orderlistener(buttonpanel);
    	
    	Box box = Box.createVerticalBox();
    	Box namebox = Box.createHorizontalBox();
    	Box topbox = Box.createHorizontalBox();
    	Box pricebox = Box.createHorizontalBox();
        namelabel = new JLabel("Name");
    	topslabel = new JLabel("Topping");
    	pricelabel = new JLabel("Price$");
    	namebox.add(namelabel); namebox.add(Box.createHorizontalStrut(10));
    	namebox.add(namefield);
        box.add(namebox);	
    	box.add(Box.createVerticalStrut(20));
    	topbox.add(topslabel);topbox.add(Box.createHorizontalStrut(10));
    	topbox.add(topsfield);
        box.add(topbox);box.add(Box.createVerticalStrut(10));
        addbutton = new JButton("Add");addbutton.addActionListener(listener);
        box.add(addbutton);box.add(Box.createVerticalStrut(20));
        pricebox.add(pricelabel);pricebox.add(Box.createHorizontalStrut(10));
        pricebox.add(pricefield);
        box.add(pricebox);
        box.add(Box.createVerticalStrut(20));
        commitbutton.addActionListener(listener);
        box.add(commitbutton);
    	add(box);
   
    }
    
    public void update(){
        
    }
    
    public String pizzaname(){
    	return namefield.getText();
    }
    
    public String pizzatops(){
    	return topsfield.getText();
    }
    
  
    public double pizzaprice(){
    	double price = Double.parseDouble(pricefield.getText());
    	return price;
    }
    
    
    private class Orderlistener implements ActionListener {
    	
    	private LinkedList<String> tops = new LinkedList<String>();
    	private String [] newtoppings;
    	private ButtonPanel buttonpanel;
    	private Box box = Box.createVerticalBox();
    	public JPanel newpanel = new JPanel();
    	
    	public Orderlistener (ButtonPanel buttonpanel){
    		this.buttonpanel = buttonpanel;
    		this.buttonpanel.invalidate();    	} 
    	
    	public void actionPerformed(ActionEvent e)
 
       { 
       	
       	if (e.getSource() == addbutton){
       		tops.add(pizzatops());
       		topsfield.setText("");
       		}
    	 
    	
    	if (e.getSource() == commitbutton){
    		newtoppings = new String[tops.size()];
    		tops.toArray(newtoppings);
    		za.add(new Pizza(pizzaname(),newtoppings,pizzaprice()));
    		this.buttonpanel.add(buttonpanel.addbutton(pizzaname()));
    		tops.clear(); 
    		namefield.setText("");
    		pricefield.setText("");
    	    
      	}
    	}
    }
    
}