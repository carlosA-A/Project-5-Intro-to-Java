//Name: Carlos Avogadro
//UFL ID: c.avogadro
//Section:6909
//Project Number: 5
//Brief description of file documents: Autograder
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Project5 {
public static void  main(String [] args) throws FileNotFoundException {
	String typeOfStudent;
	String nameStudent;
	int idStudent;
	String nameSchool;
	String advisor;
	String major;

	ArrayList<String> misspelledWordsArrayList= new ArrayList<>();
	int misspelled;
	
	Scanner input = new Scanner(System.in);
	 boolean openFile=true;

	 java.io.File file;
	 //Ask user for name of dictionary, keep looping until a name that exists is given
	 do{
		System.out.println("Please specify the name of the file that contains the dictionary information.");
		String fileName= input.next();
		file = new java.io.File(fileName+".txt");
		
	if (file.exists()) {
		System.out.println("File opened successfully!");
		openFile=false;
	} 
	 else {
		System.out.println("File "+fileName + " cannot be found!");
		input.nextLine();
	}
	 }while(openFile);
	 
	 //Create an array to store dictionary words
	 
	 ArrayList<String> dictionaryList=new ArrayList<>();
	 Scanner readFile = new Scanner(file);
		
		//While there are words turn them to lowercase and add them to dictionary list
		while (readFile.hasNext()) {
			dictionaryList.add(readFile.next().toLowerCase());
		}

	 String fileName="";
	 //Continue running until Finished is entered
	 while (fileName!="Finished"||fileName!="finished") {
		 
		misspelledWordsArrayList.clear();
		 
		int score=100;
		 
		boolean exists=false;
			
		boolean repeat=false;
	
	 //Ask for id file
	 openFile=true;
	 
	 do{
			System.out.println("Please specify the ID of the student whose essay will be graded.");
			fileName= input.next();
			file = new java.io.File(fileName+".txt");
			
		if (file.exists()) {
			System.out.println("File opened successfully!");
			openFile=false;
		} 
		
		else if (fileName.equals("Finished")||fileName.equals("finished")) {
			 System.exit(0);
			 }
		 else {
			System.out.println("File "+fileName + " cannot be found!");
			input.nextLine();
		}
		 }while(openFile);
	 readFile.close();
	 
	 
	 try {
		 
		 ArrayList<String> header= new ArrayList<>();
		 ArrayList<String> wordList= new ArrayList<>();
		
		 readFile = new Scanner(file);
		
		typeOfStudent=readFile.nextLine();
		
		
		if(typeOfStudent.equals("HighSchool Student")||typeOfStudent.equals("High School Student")){
		
			for (int i = 0; i < 3; i++) {
				
					header.add(readFile.nextLine());
				
				
			}	
			nameStudent=header.get(0);
			
			idStudent=new Integer(header.get(1));
			
			
			nameSchool=header.get(2);
			
			
			HighSchoolStudent studentH= new HighSchoolStudent(nameStudent,idStudent,nameSchool);
			//Sets the type of student inside the student object, because the output is not clear if it is high school or highschool :[
			studentH.setTypeOfStudent(typeOfStudent);
			
			
		while (readFile.hasNext() ) {
			
			//Strips punctuation from string and adds to array
			wordList.add(readFile.next().split("[.?!,:]")[0].toLowerCase()); 
			
				}
		misspelled=0;
		
		//Loop that checks if a word in the list of words extracted from the file is inside the dictionary list.
		for (int i = 0; i <wordList.size() ; i++) {
			
			for (int j = 0; j < dictionaryList.size(); j++) {
				if (wordList.get(i).equals(dictionaryList.get(j))) {
					
					exists=true;
					break;
				}
				else {
					exists=false;
					
				}
			}
			//If word doesn't exist in dictionary consider it a misspelling and add to list of misspelled words
			if (exists==false) {
				if(misspelledWordsArrayList.size()==0){misspelledWordsArrayList.add(wordList.get(i));
				misspelled++;
				score--;
				}
				else{
				for (int q=0;q<misspelledWordsArrayList.size();q++) {
		
				 if (misspelledWordsArrayList.get(q).equals(wordList.get(i))) {
					 repeat=true;	
					 break;
					}
					else {
						repeat=false;
						}				
					}
				if (repeat==false){
					misspelled++;
				score--;
				misspelledWordsArrayList.add(wordList.get(i));}
				}
				
			}
		}
		java.io.File grade = new java.io.File(idStudent+"_graded.txt");
		java.io.PrintWriter output = new java.io.PrintWriter(grade);

		output.print(studentH.toString());

		if(score<0){
			score=0;
		}
		output.println("Received a score of "+score+ " with "+misspelled+" misspelled words:");
		output.println();
	
	
	int number=1;
	for (String string : misspelledWordsArrayList) {
		
		output.println("("+number+")"+string);
		output.println();
		number++;
	}
	output.close();
	
		}
	else if(typeOfStudent.equals("Undergraduate Student")){

			for (int i = 0; i < 3; i++) {
				
					header.add(readFile.nextLine());
			
				}
			nameStudent=header.get(0);
		
			idStudent=new Integer(header.get(1));
			major=header.get(2);
			UndergraduateStudent studentU= new UndergraduateStudent(nameStudent,idStudent,major);
		while (readFile.hasNext() ) {
			
			wordList.add(readFile.next().split("[.?!,:]")[0].toLowerCase()); 
			
				}
		misspelled=0;
		
		//Loop that checks if a word in the list of words extracted from the file is inside the dictionary list.
		for (int i = 0; i <wordList.size() ; i++) {
			
			for (int j = 0; j < dictionaryList.size(); j++) {
				if (wordList.get(i).equals(dictionaryList.get(j))) {
					
					exists=true;
					break;
				}
				else {
					exists=false;
					
				}
			}
			//If word doesn't exist in dictionary consider it a misspelling and add to list of misspelled words
			if (exists==false) {
				if(misspelledWordsArrayList.size()==0){misspelledWordsArrayList.add(wordList.get(i));
				misspelled++;
				score-=3;
				}
				else{
				for (int q=0;q<misspelledWordsArrayList.size();q++) {				
				 if (misspelledWordsArrayList.get(q).equals(wordList.get(i))) {
					 repeat=true;	
					 break;
					}
					else {
						repeat=false;
						}}
				if (repeat==false){
					misspelled++;
				score-=3;
				misspelledWordsArrayList.add(wordList.get(i));}
				}}}
		//creates a new file
		java.io.File grade = new java.io.File(idStudent+"_graded.txt");
		java.io.PrintWriter output = new java.io.PrintWriter(grade);
//Prints output to file
		
		output.print(studentU.toString());
		if(score<0){
			score=0;
		}
		output.println("Received a score of "+score+ " with "+misspelled+" misspelled words:");
		output.println();
	
	int number=1;
	for (String string : misspelledWordsArrayList) {
		
		output.println("("+number+")"+string);
		output.println();
		number++;
	}
	output.close();
	
		}
		if(typeOfStudent.equals("Graduate Student")){
	
			for (int i = 0; i < 4; i++) {
				
					header.add(readFile.nextLine());
				
				}
			
			nameStudent=header.get(0);
			
			
			idStudent=new Integer(header.get(1));
			
			
			major=header.get(2);
			
			advisor=header.get(3);
			
			GraduateStudent studentG= new GraduateStudent(nameStudent,idStudent,major,advisor);
	
		while (readFile.hasNext() ) {
			
			
			wordList.add(readFile.next().split("[.?!,:']")[0].toLowerCase()); 
			
				}
		misspelled=0;
		
		//Loop that checks if a word in the list of words extracted from the file is inside the dictionary list.
		for (int i = 0; i <wordList.size() ; i++) {
			
			for (int j = 0; j < dictionaryList.size(); j++) {
				if (wordList.get(i).equals(dictionaryList.get(j))) {
					
					exists=true;
					break;
				}
				else {
					exists=false;
					
				}
			}
			//If word doesn't exist in dictionary consider it a misspelling and add to list of misspelled words
			if (exists==false) {
				if(misspelledWordsArrayList.size()==0){
					misspelledWordsArrayList.add(wordList.get(i));
					misspelled++;
					score-=5;
				}
				else{
				for (int q=0;q<misspelledWordsArrayList.size();q++) {
				 if (misspelledWordsArrayList.get(q).equals(wordList.get(i))) {
					 repeat=true;	
					 break;
					}
					else {
						repeat=false;	
					}
					}
				if (repeat==false){
					misspelled++;
				score-=5;
				misspelledWordsArrayList.add(wordList.get(i));}
				}}}
		java.io.File grade = new java.io.File(idStudent+"_graded.txt");
		java.io.PrintWriter output = new java.io.PrintWriter(grade);
		output.print(studentG.toString());
				
		if(score<0){
			score=0;
		}
		output.println("Received a score of "+score+ " with "+misspelled+" misspelled words:");
		output.println();
	
	int number=1;
	for (String string : misspelledWordsArrayList) {
		output.println("("+number+")"+string);
		output.println();
		number++;
	}
	output.close();
		}
	 }
	  
	 catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 	 
}	
}
}
