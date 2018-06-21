package Dev;

/**
 * CustomTableModel
 * Eigenes TableModel nach der das Table aufgebaut wird
 *  
 * @author Marco Arena, Jim Rebholz
 * 
 * @version 1.0
 */
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class CustomTableModel extends AbstractTableModel{
	
	static final String[] columnHeader = {"No.", "Command", "Configuration"};
	
	@Override
	public int getRowCount() {
	
		return ControlModel.getInstance().getControlProcess().count();
	}

	@Override
	public int getColumnCount() {
		
		return columnHeader.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		if(columnIndex == 0)
			return rowIndex + 1;
		
		else if (columnIndex == 1) {
			return ControlModel.getInstance().getControlProcess().get(rowIndex + 1).getName();
		}
		
		else if (rowIndex >= 0 && columnIndex == 2){
			String tmp = ControlModel.getInstance().getControlProcess().get(rowIndex + 1).toString();
			String[] parts = new String[3];
			parts = tmp.split(";");
			
			if(parts[0].equals("Direction")) {
				String s = parts[1] + " Degree";
				return s;
			}
			
			else if(parts[0].equals("Gear")) {
				String s = parts[1] + " cm/sec " + parts[2] + " sec";
				return s;
			}
			
			else if(parts[0].equals("Pause")) {
				String s = parts[1] + " sec";
				return s;
			}
			
			else
				return null;
		}
		
		else 
			return null;

	}
	
	/**
	 * Ausgabe des Headers 
	 * @return columnHeader (3 Spalten mit No./Command/Config)
	 */
	public String getColumnName(int column) {
		return columnHeader[column];
	}
	
	/**
	 * Erzeugen einer neuen Zeile, über die value, wird dabei der entsprechende Command eingefügt und in der List erzeugt
	 * @param value (Direction, Gear, Pause)
	 */
	public void addRow(String value){

		CommandList controlProcess = ControlModel.getInstance().getControlProcess();
		controlProcess.add(ControlModel.getInstance().getCommandTypes(value).createInstance());
	    fireTableDataChanged();
	}
	
	/**
	 * Löschen einer Zeile über den Zeilenindex
	 * @param row (Zeilenindex + 1)
	 */
	public void delRow(int row){
		
		CommandList controlProcess = ControlModel.getInstance().getControlProcess();
		controlProcess.remove(row + 1);
	    fireTableDataChanged();
	}
	
	/**
	 * Hochschieben einer Zeile über den Zeilenindex
	 * @param row (Zeilenindex + 1)
	 */
	public void moveUpRow(int row) {
	
		CommandList controlProcess = ControlModel.getInstance().getControlProcess();
		controlProcess.moveUp(row + 1);
	    fireTableDataChanged();
	}
	
	/**
	 * Runterschieben einer Zeile über den Zeilenindex
	 * @param row (Zeilenindex + 1)
	 */
	public void moveDownRow(int row) {
		
		CommandList controlProcess = ControlModel.getInstance().getControlProcess();
		controlProcess.moveDown(row + 1);
	    fireTableDataChanged();
	}

}
