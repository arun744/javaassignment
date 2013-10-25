import model.*;
import java.awt.*;
import javax.swing.*;

public class Window extends JFrame
{private JTabbedPane addTab, orderTab;

    public Window(Za za)
    {   setup();
        build(za);
        pack();
        setVisible(true);   }

    private void setup()
    {   setLocation(500, 500);  }
        
    private void build(Za za)
    	
    {   
        ButtonPanel buttonpanel = new ButtonPanel(za);
        Summarypanel summarypanel = new Summarypanel(za);
        addTab = new JTabbedPane();
        addTab.add(new Orderpanel(za, summarypanel, buttonpanel), "Order");
        addTab.add(new Addpanel(za,buttonpanel),"Add");
        addTab.add(new Showpanel(za), "Show");
     	add(addTab);
     
    }
}