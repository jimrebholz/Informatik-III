
public class ControlDeveloper {

	public String name = "Control-Developer";
	
	
	public String getName() {
		
		return name;
	
	}
	
	public void setName(String name) {
	
		this.name = name;
		
	}
	
	
	
	public static void main(String[] args) {
		
	ControlDeveloper c = new ControlDeveloper();
	System.out.println(c.name);
	System.out.println(c.getName());
	
	
	}
	
}
