package gpl.fredy.datadrill;

import java.io.File;
import javax.swing.event.*;
import javax.swing.JFileChooser;


public class GetFileName extends JFileChooser {

    String fileName;
    
    /**
     * Get the value of fileName.
     * @return value of fileName.
     */
    public String getFileName() {
	return fileName;
    }
    
    MyFileFilter filter = null;
    
    /**
     * Get the value of filter.
     * @return value of filter.
     */
    public MyFileFilter getFilter() {
	return filter;
    }
    
    /**
     * Set the Filefilter 
     * @param extensions are the desired File-extensions
     * @param description the description of the filter
     */
    public void setFilter(String f[]) {
	filter = new MyFileFilter(f);
    }
    
    /**
     * Set the value of fileName.
     * @param v  Value to assign to fileName.
     */
    public void setFileName(String  v) {
	this.fileName = v;
    }
    
    public GetFileName(String[] filter) {
	this.setFilter(filter);
	this.setDialogType(JFileChooser.OPEN_DIALOG);
	this.setDialogTitle("Open File");
	if (getFilter() != null) this.setFileFilter(getFilter());

	this.setVisible(true);
	int returnVal = this.showOpenDialog(null);
	if(returnVal == JFileChooser.APPROVE_OPTION) {
	    setFileName(this.getSelectedFile().getParent()
			+ File.separator +
			this.getSelectedFile().getName());
	} else { setFileName(null); }
    }
}
