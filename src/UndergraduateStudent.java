
public class UndergraduateStudent extends Student {

	String major;
	
	public UndergraduateStudent(String n, int id, String major){
		name=n;
		idNumber=id;
		this.major=major;
	}
	
	public String getMajor(){
		return major;
		
	}
	public void setMajor(String major){
		this.major=major;
		
	}
	public String toString(){
		
		String toPrint="Undergraduate Student"+" "+name+"\n\nStudent ID: "+idNumber+"\n\nMajor: "+major+"\n\n";
		return toPrint;
		
	}
}
