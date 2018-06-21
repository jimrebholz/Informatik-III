package Dev;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class CustomTableModel extends AbstractTableModel{
	
	static final String[] columnHeader = {"No.", "Command", "Configuration"};
	private Vector<Vector<String>> rows= new Vector<Vector<String>>();
	private int rowCount = 0;

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
	
	public String getColumnName(int column) {
		return columnHeader[column];
	}
	
	public void addRow(String value){

		CommandList controlProcess = ControlModel.getInstance().getControlProcess();
		controlProcess.add(ControlModel.getInstance().getCommandTypes(value).createInstance());
	    fireTableDataChanged();
	}
	
	public void delRow(int row){
		
		CommandList controlProcess = ControlModel.getInstance().getControlProcess();
		controlProcess.remove(row + 1);
	    fireTableDataChanged();
	}
	
	public void moveUpRow(int row) {
	
		CommandList controlProcess = ControlModel.getInstance().getControlProcess();
		controlProcess.moveUp(row + 1);
	    fireTableDataChanged();
	}
	
	public void moveDownRow(int row) {
		
		CommandList controlProcess = ControlModel.getInstance().getControlProcess();
		controlProcess.moveDown(row + 1);
	    fireTableDataChanged();
	}

}
