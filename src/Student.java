
public class Student {
	String name;
	int idNumber;
	public Student(){
		
	}
	public Student(String n, int id){
		name=n;
		idNumber=id;
		
	}
	
	public String getName() {
		return name;
		
	}
	public void setName(String n){
		name=n;
	}
	public String getIDNumber(){
		return idNumber+"";
		
	}
	public void setIDNumber(int id){
		idNumber=id;
		
	}
	public String toString(){
		
		return name+"\n"+idNumber;
	}
}
