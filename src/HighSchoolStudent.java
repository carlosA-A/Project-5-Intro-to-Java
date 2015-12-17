
public class HighSchoolStudent extends Student {

	String nameOfSchoolString;
	String typeOfStuden;
	
	public HighSchoolStudent(String n, int id, String schoolName){
		name=n;
		idNumber=id;
		nameOfSchoolString=schoolName;
	}
	
	public String getNameOfSchool(){
		return nameOfSchoolString;
	}
	public void setNameOfSchool(String schoolName){
		nameOfSchoolString=schoolName;
		
	}
	public void setTypeOfStudent(String type) {
		typeOfStuden=type;
		
	}
	public String getTypeOfStudent() {
		return typeOfStuden;
		
	}
	public String toString(){
		
		String toPrint="High School Student"+" "+name+"\n\nStudent ID: "+idNumber+"\n\nName of School: "+nameOfSchoolString+"\n\n";
		return toPrint;
		
	}
}

