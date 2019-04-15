package application;
import javafx.scene.control.TreeItem;

public class GicNode {
	// these for the branches
	String giccd;
	String gicdesc;
	String gictype; // GSECTOR, GGROUP, GIND, GSUBIND, COMPANY
	// these for the companies
	String gsector;
	String ggroup;
	String gind;
	String gsubin;
	// this to hold the ticket
	String ticker;
	// this to hold pointer to the tree item it sits in
	TreeItem ti;
	
	static int GSECTOR_LEN = 2;
	static int GGROUP_LEN = 4;
	static int GIND_LEN = 6;
	static int GSUBIND_LEN = 8;
	GicNode parentNode;
	
	public GicNode() {
		
	}

	public GicNode(String p_GICCD, String p_GICDESC, String p_GICTYPE /* , GicNode p_Parent */) {
		giccd = p_GICCD;
		gicdesc = p_GICDESC;
		gictype = p_GICTYPE;
		
	}

	public String toString() {
		if (this.ticker != null) {
			return gicdesc + "(" + this.ticker + ")";
		}
		return gicdesc;
	}
	public GicNode(String p_GICCD, String p_GICDESC, String p_GICTYPE,
			String p_GSECTOR, String p_GGROUP, String p_GIND, String p_GSUBIN)
	{
		giccd = p_GICCD;
		gicdesc = p_GICDESC;
		gictype = p_GICTYPE;
		gsector = p_GSECTOR;
		ggroup = p_GGROUP;
		gind = p_GIND;
		gsubin = p_GSUBIN;
		
	}
}