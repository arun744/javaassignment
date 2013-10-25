import model.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;


public class ButtonPanel extends JPanel implements View    {
   private Za za;
   private JLabel pizzalabel;
   public ButtonGroup group = new ButtonGroup();
   public JRadioButton newbutton, radiobutton;
   public ButtonListener listener = new ButtonListener();
   private Box box = Box.createVerticalBox();
   private Pizza pizza;
   
    public ButtonPanel(Za za) {
    	this.za = za;
    	za.attach(this);
    	setup();
    	build();
    }
     private void setup()
     	
    {   Dimension d = new Dimension(200,170);
    	setBorder(BorderFactory.createLineBorder(Color.blue));
        setLayout(new FlowLayout());
        setPreferredSize(d);
        
        
       
      }

    public void build(){
 
       add(mainfield(),BorderLayout.CENTER); 
       }
  
  public Box mainfield (){
  
  	    box.add(new JLabel("Picka pizza"));
    	box.add(Box.createVerticalStrut(15));
   
         for (Pizza pizza:za.pizzas())
        	box.add(createbutton(pizza.name()));
        
        	
        return box;
  }
    
  
  public Box addbutton(String name){
  	newbutton = new JRadioButton(name);
  	group.add(newbutton);
 	newbutton.addActionListener(listener);
 	newbutton.setVisible(true);
  	box.add(newbutton);
  	return box;
  }
  


 public JRadioButton createbutton( String name){
    radiobutton = new JRadioButton(name);
 	group.add(radiobutton);
 	radiobutton.addActionListener(listener);
 	radiobutton.setVisible(true);
    return radiobutton;
 	
 }
 
 
    private String getOrder(String name){
    	return name;
    }
    

    public void update(){
    group.clearSelection();
  
    
    	}
    
        
   
    
  
    
   
   
    private class ButtonListener implements ActionListener{
      
    
      
    	public void actionPerformed(ActionEvent e){ 
    	  za.order.add(za.pizza(e.getActionCommand()));
    	  za.add(0);
    	  
    	}
    }
    
    
  
  
}