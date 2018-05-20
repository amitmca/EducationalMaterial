package gpl.fredy.ui;


import java.awt.*;
import java.awt.Font.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.util.*;
import java.io.File;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.border.*;
import javax.swing.text.*;
import javax.swing.undo.*;

public class TextEditor extends JPanel {

    public ImageButton ok,cancel;
    private Toolkit toolKit;

    public JTextArea text;
  
    public String getText() {
	return text.getText();

    }

    public void setText(String v) { 
	    text.setText(v);
    }

    public void setTitle(String t) {
	this.setTitle(t);
    }

    public TextEditor() {
	doIt();
    }
    public TextEditor(String text) {
	doIt();
	this.text.setText(text);
    }


    private void doIt() {
	toolKit = this.getToolkit();
	this.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        text = new JTextArea(24,80);
        text.setFont(new  java.awt.Font("Monospaced", Font.PLAIN, 12));      
        panel.add(BorderLayout.CENTER,new JScrollPane(text));
        
        
        text.setDragEnabled(true);
        
        text.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent fe) {
                
            }
            public void focusLost(FocusEvent fe) {
            }
        });
        
        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout());
        
        ImageButton clear = new ImageButton(null,"clear.gif",null);
        clear.setToolTipText("clear text area");
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text.setText("");
                
            }});
            buttons.add(clear);
            
            ImageButton copy = new ImageButton(null,"copy.gif",null);
            copy.setToolTipText("Copy selection to clipboard");
            copy.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        String s = text.getSelectedText();
                        if ( s.length() > 0 ) {
                            StringSelection ss = new StringSelection(s);
                            toolKit.getSystemClipboard().setContents(ss,ss);
                        }
                    } catch ( Exception ec) {
                        toolKit.beep();
                    }
                }});
                buttons.add(copy);
                
                ImageButton paste = new ImageButton(null,"paste.gif",null);
                paste.setToolTipText("Paste");
                paste.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Clipboard c =toolKit.getSystemClipboard();
                        Transferable t = c.getContents(this);
                        try {
                            String s = (String) t.getTransferData(DataFlavor.stringFlavor);
                            text.insert(s, text.getCaretPosition());
                        }
                        catch (Exception eexc) {
                            toolKit.beep();
                        }
                    }});
                    buttons.add(paste);
                    
                    ImageButton cut = new ImageButton(null,"cut.gif",null);
                    cut.setToolTipText("Cut");
                    cut.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            String s = text.getSelectedText();
                            StringSelection ss = new StringSelection(s);
                            toolKit.getSystemClipboard().setContents(ss,ss);
                            text.replaceRange(null, text.getSelectionStart(), text.getSelectionEnd());
                        }});
                        buttons.add(cut);
                        
                        ImageButton saveText = new ImageButton(null,"save.gif","Save Text to file");
                        saveText.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                gpl.fredy.io.FileWriter fw = new gpl.fredy.io.FileWriter();
                                fw.setFilter(new String[] {"sql","SQL","txt","TXT"});
                                fw.setContent(text.getText());
                                fw.setFileName("?");
                                fw.setSwitch("a");
                                fw.write();
                            }
                        });
                        buttons.add(saveText);
                        
                        ImageButton loadText = new ImageButton(null,"load.gif","Load text from file");
                        loadText.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                gpl.fredy.io.ReadFile rf = new gpl.fredy.io.ReadFile();
                                rf.setFilter(new String[]{"sql","SQL","txt","TXT"});
                                rf.setFileName("?");
                                if (text.getText().length() > 0 ) text.append(";\n");
                                text.append(rf.getText());
                                text.updateUI();
                            }
                        });
                        buttons.add(loadText);
                        
                        buttons.setBorder(new EtchedBorder());
                        panel.add(BorderLayout.NORTH,buttons);
                        
                        panel.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(),"Text"));
			
			this.add(BorderLayout.CENTER,panel);
			this.add(BorderLayout.SOUTH,buttonPanel());


    }

    private JPanel buttonPanel() {
	JPanel panel = new JPanel();
	panel.setBorder(new EtchedBorder());
	ok = new ImageButton(null,"ok.gif",null);
	cancel = new ImageButton(null,"exit.gif",null);
	panel.add(ok);
	panel.add(cancel);
	return panel;
    }



	
    private JPanel textPanel() {
	JPanel panel = new JPanel();
	panel.setLayout(new GridLayout());

	GridBagConstraints gbc;
	Insets insets = new Insets(5,5,5,5);

	gbc = new GridBagConstraints();
	gbc.anchor= GridBagConstraints.WEST;
        gbc.fill  = GridBagConstraints.BOTH;

	JScrollPane pane = new JScrollPane(text);


	gbc.gridx = 0;
	gbc.gridy = 0;
	gbc.weightx = 1.0;	
	gbc.weighty = 1.0;
	panel.add(pane,gbc);

	return panel;

    }


    public static void main(String args[] ) {
	final TextEditor f = new TextEditor();
	JFrame e = new JFrame("Editor");
	e.getContentPane().add(f);
	e.pack();
	e.setVisible(true);
	e.addWindowListener(new WindowAdapter() {
		public void windowActivated(WindowEvent e) {}
		public void windowClosed(WindowEvent e) {}
		public void windowClosing(WindowEvent e) {
		    System.out.println(f.getText());
		    System.exit(0);
		}
		public void windowDeactivated(WindowEvent e) {}
		public void windowDeiconified(WindowEvent e) {}
		public void windowIconified(WindowEvent e) {}
		public void windowOpened(WindowEvent e) {}});
	f.cancel.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    System.exit(0);
		    }});
	


    }

}
