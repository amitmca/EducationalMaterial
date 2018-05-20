
/* This program creates a text box which accepts only Numeric values */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

class IntTextDocument extends PlainDocument
{
	public void insertString(int offs, String str, AttributeSet a) throws BadLocationException
	{
		if (str == null) return;
		String oldStr = getText(0,getLength());
		String newStr = oldStr.substring(0,offs)
					+ str + oldStr.substring(offs);
 		try
		{
			Integer.parseInt(newStr + "0");
			super.insertString(offs,str,a);
		}
		catch(NumberFormatException e) { }
	} // End of mthd insertString
	
 
	
}// End of class IntTextDocument 
class IntTextField extends JTextField
{
	public IntTextField(int defval, int size)
	{
		super(""+ defval,size);
	}// End of constructor IntTextField
	
	protected Document createnewDefaultDocument()
	{
		return new IntTextDocument();
	}

	public boolean isValid()
	{
		try
		{
			Integer.parseInt(getText());
			return true;
		}// End of try block
		catch(NumberFormatException e) {return false;}

	}// End of isValid mthd

	public int getValue()
	{
		try
		{
			return Integer.parseInt(getText());
		}
		catch(NumberFormatException e) {return 0;}

	}
}// End of class IntTextField
