package Dev;

public class ControlModel {

	private static ControlModel instance = null;
	private CommandType [] commandTypes = new CommandType[3];
	private CommandList controlProcess = null;
	
	
	
	private ControlModel() {
		setControlProcess(new CommandList()); 
	}

	
	public static ControlModel getInstance() {
		
		if(instance == null) 
			instance = new ControlModel();
		
		return instance;
		
	}
	
	public void createCommandTypes() {
		
		commandTypes [0] = CommandType.createClass("Direction");
		commandTypes [1] = CommandType.createClass("Gear");
		commandTypes [2] = CommandType.createClass("Pause");
		
	}


	public CommandList getControlProcess() {
		return controlProcess;
	}


	public void setControlProcess(CommandList controlProcess) {
		this.controlProcess = controlProcess;
	}
	
	
	
	
}

