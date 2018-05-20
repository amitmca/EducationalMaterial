import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Font.*;
import java.util.*;
import java.io.*;

public class Main extends JFrame implements 
        ActionListener
{    
    public static JEditorPane editor = new JEditorPane();
    public JScrollPane editorScrollPane = new JScrollPane(editor,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    
    JMenuItem editCopy = new JMenuItem();
    JMenuItem editCut = new JMenuItem();
    JMenu editMenu = new JMenu();
    JMenuItem editPaste = new JMenuItem();
    JMenu fileMenu = new JMenu();
    JMenuItem fileNew = new JMenuItem();
    JMenuItem fileOpen = new JMenuItem();
    JMenuItem fileSave = new JMenuItem();
    /* private JMenuItem formatFonts = new JMenuItem();
    private JMenu formatMenu = new JMenu(); */
    JMenuBar menuBar = new JMenuBar();
    JMenuItem quit = new JMenuItem();
    JMenuItem selectAll = new JMenuItem();
    JMenuItem timeDate = new JMenuItem();
    
    final JPopupMenu popMenu = new JPopupMenu();
    JMenuItem popCopy = new JMenuItem();
    JMenuItem popCut = new JMenuItem();
    JMenuItem popPaste = new JMenuItem();
    JSeparator popSep = new JSeparator();
    JMenuItem popSelectAll = new JMenuItem();
    JMenuItem popTimeDate = new JMenuItem();
    popupListener popupListener = new popupListener();
    
    public static void getTime()
        {
        String time;
        Calendar now = Calendar.getInstance();
        int hour = now.get(Calendar.HOUR_OF_DAY);
        int minute = now.get(Calendar.MINUTE);
        int month = now.get(Calendar.MONTH) + 1;
        int day = now.get(Calendar.DAY_OF_MONTH);
        int year = now.get(Calendar.YEAR);

        String monthName = "";
        switch (month)
        {
            case (1):
                monthName = "January";
                break;
            case (2):
                monthName = "February";
                break;
            case (3):
                monthName = "March";
                break;
            case (4):
                monthName = "April";
                break;
            case (5):
                monthName = "May";
                break;
            case (6):
                monthName = "June";
                break;
            case (7):
                monthName = "July";
                break;
            case (8):
                monthName = "August";
                break;
            case (9):
                monthName = "September";
                break;
            case (10):
                monthName = "October";
                break;
            case (11):
                monthName = "November";
                break;
            case (12):
                monthName = "December";
        }
        time = monthName + " " + day + ", " + year + " " + hour + ":" + minute;
        String text = editor.getText();
        
        if (text == null) {
            editor.setText(time);
        } else {
            editor.setText(text + " " + time);
        }
    }
    public Main() 
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("nText 0.6.0.5 Beta");
    
        editMenu.addActionListener(this);

        
        fileMenu.setText("File");

        fileNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        fileNew.setText("New File");
        fileMenu.add(fileNew);

        fileOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        fileOpen.setText("Open File");
        fileOpen.addActionListener(this);
        fileMenu.add(fileOpen);

        fileSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        fileSave.setText("Save File");
        fileSave.addActionListener(this);
        fileMenu.add(fileSave);
        fileMenu.addSeparator();

        quit.setText("Quit");
        quit.addActionListener(this);
        fileMenu.add(quit);

        menuBar.add(fileMenu);

        editMenu.setText("Edit");

        editCut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        editCut.setText("Cut");
        editCut.addActionListener(this);
        editMenu.add(editCut);

        editCopy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        editCopy.setText("Copy");
        editCopy.addActionListener(this);
        editMenu.add(editCopy);

        editPaste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        editPaste.setText("Paste");
        editPaste.addActionListener(this);
        editMenu.add(editPaste);
        editMenu.addSeparator();

        timeDate.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        timeDate.setText("Time & Date");
        timeDate.addActionListener(this);
        editMenu.add(timeDate);

        selectAll.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        selectAll.setText("Select All");
        selectAll.addActionListener(this);
        editMenu.add(selectAll);
        
        editMenu.addActionListener(this);
        
        menuBar.add(editMenu);

        /* formatMenu.setText("Format");

        formatFonts.setText("Font...");
        formatMenu.add(formatFonts);

        menuBar.add(formatMenu); */
        
        popCopy.setText("Copy");
        popCopy.addActionListener(this);
        popMenu.add(popCopy);
        
        popCut.setText("Cut");
        popCut.addActionListener(this);
        popMenu.add(popCut);
        
        popPaste.setText("Paste");
        popPaste.addActionListener(this);
        popMenu.add(popPaste);
        
        popMenu.addSeparator();
        
        popTimeDate.setText("Time & Date");
        popTimeDate.addActionListener(this);
        popMenu.add(popTimeDate);
        
        popSelectAll.setText("Select All");
        popSelectAll.addActionListener(this);
        popMenu.add(popSelectAll);
    
        editor.addMouseListener(popupListener);
        
        setJMenuBar(menuBar);
        
        setSize(500, 350);
        setLayout(new BorderLayout());
        add(editorScrollPane);
        setVisible(true);
    }
    
    public class popupListener extends MouseAdapter {
     public void mousePressed(MouseEvent evt) {
            if (evt.isPopupTrigger()) {
                popMenu.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
        public void mouseReleased(MouseEvent evt) {
            if (evt.isPopupTrigger()) {
                popMenu.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
}
    
    
    
    public void actionPerformed(ActionEvent evt) 
    {
        Object source = evt.getSource();
        if (source == fileOpen) {
/*        openFile oP = new openFile();
        } else if (source == fileNew) {
            editor.setText("");
        } else if (source == fileSave) {
            saveFile sF = new saveFile();*/
        } else if (source == quit) {
            System.exit(0);
        } else if (source == editCut) {
            editor.cut();
        } else if (source == editCopy) {
            editor.copy();
        } else if (source == editPaste) {
            editor.paste();
        } else if (source == timeDate) {
            getTime();
        } else if (source == selectAll) {
            editor.selectAll();
        } else if (source == popCopy) {
            editor.copy();
        } else if (source == popCut) {
            editor.cut();
        } else if (source == popPaste) {
            editor.paste();
        } else if (source == popTimeDate) {
            getTime();
        } else if (source == popSelectAll) {
            editor.selectAll();
        } else if (source == editMenu) {
            if (editor.getSelectedText() == null) {
                editCut.setEnabled(false);
                editCut.repaint();
            } else {
                editCut.setEnabled(true);
                editMenu.repaint();
            }
        }
        else /*if (source == formatFonts)*/ {
            // The font changer will be ignored until the syntax highlighter is finished.
    }
}

    public static void main(String args[]) {
        try {
        UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
        } 
        catch (UnsupportedLookAndFeelException e) {
        }
        catch (ClassNotFoundException e) {
        }
        catch (InstantiationException e) {
        }
        catch (IllegalAccessException e) {
        }
        Main m = new Main();
    }    
}
