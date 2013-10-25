import model.*;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;


public class Summarypanel extends JPanel implements View {
    private JLabel pizzalabel;
    private JLabel pricelabel;
    private Za za; 
    
    private JButton paybutton;
    
    public Summarypanel(Za za) {
        this.za = za;
        za.attach(this);
        setup();
    	build();
    	
    }
    
    private void setup(){
    	
    	 setBorder(BorderFactory.createLineBorder(Color.blue));
         setLayout(new GridLayout(2,1));
         
         
    }
    
    private void build(){
    	PayListener listener = new PayListener();
    	 
    	pizzalabel = new JLabel(pizzaorder());   
    	pricelabel = new JLabel(pizzaPrice());
        paybutton = new JButton("pay");
    	paybutton.addActionListener(listener);
    	add(new DisplayPanel(pizzalabel,pricelabel));
    	add(new PayPanel(paybutton));
        
    	update();
    }
    
 
    private String twoDec(double value)
    {   DecimalFormat twoD = new DecimalFormat("#0.00");
        return twoD.format(value); }
    
   
    public void update(){
    	
    	pizzalabel.setText(pizzaorder());
    	pricelabel.setText(pizzaPrice());
    	
    }
    
    public String pizzaorder(){
    	return "You ordered "+ za.order.size()+ " pizzas";
    }
    
    public String pizzaPrice(){
    	return "The charge is $"+ twoDec(za.order.price());
    }
    
   
    
    private class DisplayPanel extends JPanel
{   public DisplayPanel(JLabel pizzalabel, JLabel pricelabel) 
    {   setup();
        build(pizzalabel, pricelabel);}

    private void setup()
    {   setBorder(BorderFactory.createLineBorder(Color.blue));
        setLayout(new FlowLayout()); 
        setPreferredSize(new Dimension(200,50));  
         }
        
    private void build(JLabel pizzalabel, JLabel pricelabel)
    {   
     add(pizzalabel);
     add(pricelabel);   }
}





private class PayPanel extends JPanel
{   public PayPanel(JButton button)
    {   setup();
        build(button);}

    private void setup()
    {   setBorder(BorderFactory.createLineBorder(Color.blue));
        setLayout(new BorderLayout()); 
        setPreferredSize(new Dimension(200,30));  
         }
        
    private void build(JButton button)
    {   
     add(button);   }
}





  private class PayListener implements ActionListener
    {   
   
 
   
  public void actionPerformed(ActionEvent e)
 
    { 
    	  if (e.getSource() == paybutton){
    	  	 za.add(za.order.price());
    	     za.order.clear();
    	     update(); 
    	  
    	  }
     }
   }
}