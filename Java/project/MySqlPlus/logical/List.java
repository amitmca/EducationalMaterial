import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class List extends JFrame implements ListSelectionListener
 {
    JList list;
    JScrollPane sp_list;
    JLabel label_1;

    public List() 
    {
        ListLayout customLayout = new ListLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        DefaultListModel listModel_list = new DefaultListModel();
        listModel_list.addElement("item1");
        listModel_list.addElement("item2");
        listModel_list.addElement("item3");
        listModel_list.addElement("item4");
        listModel_list.addElement("item5");
        listModel_list.addElement("item6");
        list = new JList(listModel_list);	
	list.addListSelectionListener(this);
	
        sp_list = new JScrollPane(list);
        getContentPane().add(sp_list);

        label_1 = new JLabel(" ");
        getContentPane().add(label_1);

        setSize(getPreferredSize());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String args[]) {
        List window = new List();

        window.setTitle("List");
        window.pack();
        window.show();
    }
public void valueChanged(ListSelectionEvent se)	
	{
	int[] indexes=list.getSelectedIndices();
	String outs="";

	for(int i=0;i<indexes.length;i++)
		{
		outs+=" item "+indexes[i];
		}
	label_1.setText(outs);
	}

}

class ListLayout implements LayoutManager {

    public ListLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 350 + insets.left + insets.right;
        dim.height = 189 + insets.top + insets.bottom;

        return dim;
    }

    public Dimension minimumLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);
        return dim;
    }

    public void layoutContainer(Container parent) {
        Insets insets = parent.getInsets();

        Component c;
        c = parent.getComponent(0);
        if (c.isVisible()) {c.setBounds(insets.left+80,insets.top+0,112,168);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+0,insets.top+168,352,24);}
    }
}
