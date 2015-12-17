
public class GraduateStudent extends Student {

	String major;
	String advisor;

	public GraduateStudent(String n, int id, String major, String advisor){
		name=n;
		idNumber=id;
		this.major=major;
		this.advisor=advisor;
	}
	
	public String getMajor(){
		return major;
		
	}
	public void setMajor(String major){
		
		this.major=major;
	}
	public String getAdvisor(){
		return advisor;
	}
	public void setAdvisor(String advisor){
		this.advisor=advisor;
		
	}
public String toString(){
		
		String toPrint="Graduate Student"+" "+name+"\n\nStudent ID: "+idNumber+"\n\nMajor: "+major+"\n\nAdvisor: "+advisor+"\n\n";
		return toPrint;
		
	}
	
}
