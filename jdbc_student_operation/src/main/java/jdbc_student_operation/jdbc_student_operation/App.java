package jdbc_student_operation.jdbc_student_operation;

import java.util.List;
import java.util.Map;

import com.dao.StudentDao;
import com.model.Student;
import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

public class App 
{
    public static void main( String[] args )
    {
    	// for insert student
//    	StudentDao sd = new StudentDao();
//    	Student s = new Student();
//    	s.setSname("arvind kumar");
//    	s.setScity("dhaka");
//    	s.setSpercentage(82.11);
//    	System.out.println(sd.insertStudent(s));
    	
    	
    	// delete student
    	
//    	StudentDao sd = new StudentDao();
//    	System.out.println(sd.deleteStudentBySid(304));
    	
    	
    	// find student by sid
    	
//    	StudentDao sd = new StudentDao();
//    	Student s = sd.findStudentBySid(142);
//    	System.out.println(s);
//    	
//    	
  
    	
    	// display all student
    	
//    	StudentDao sd = new StudentDao();
//    	for(Student s : sd.findAllStudent())
//    		System.out.println(s);
// 
    	
    	// update student by sid
    	
//    	StudentDao sd = new StudentDao();
//    	Student s = sd.findStudentBySid(300);
//    	s.setSpercentage(70.00);
//    	System.out.println(sd.UpdateStudent(s));
    	
    	
    	// find student by sname
    	
//    	StudentDao sd = new StudentDao();
//    	List<Student> list = sd.findStudentByName("piyu  Rudrawar");
//    	for(Student s:list)
//    		System.out.println(s);
//    	
    	
    	// find student by sname like 
    	
//    	StudentDao sd = new StudentDao();
//    	List<Student> list = sd.findStudentBySnameLike("pi");    
//    	for(Student s:list)
//    		System.out.println(s);
//    
    	
    	
    	// find student by sname or scity
    	

//    		StudentDao sd = new StudentDao();
//    		List<Student> list = sd.findStudentBySnameOrScity("AB");    
//    		for(Student s : list)
//    			System.out.println(s);
    	
    	
    	// find student by percentage greater than
    	
//    		StudentDao sd = new StudentDao();
//    		List<Student> list = sd.findStudentByPercentageGreaterThan(90);
//    		for(Student s : list)
//    			System.out.println(s);
    	
    	//find student spercentage between
    	
//    		StudentDao sd = new StudentDao();
//    		List<Student> list = sd.findStudentByPercentageBetween(91,94);
//    		// for not between
//    		 	// List<Student> list = sd.findStudentByPercentageBetween(20,90);
//    		for(Student s : list)
//    			System.out.println(s);
    	
    	
    	//  find student by any
    	
//    		StudentDao sd = new StudentDao();
//    		//List<Student> list = sd.findStudentByAny("AB");
//    		//or
//    		//List<Student> list = sd.findStudentByAny("10");
//    		for(Student s:list)
//    			System.out.println(s);
//    		
    	
    	
    	// find the name of all student
//    	
//    	StudentDao sd = new StudentDao();
//    	List<String>list = sd.findSnameOfStudent();
//    	for(String s:list)
//    		System.out.println(s);
//    	
    	

    	// find the name and city of all student
    	
    	StudentDao sd = new StudentDao();
    	Map<String,List<String>> m = sd.findSnameAndCityOfStudent();
    	List<String> names = (List<String>) m.get("names");
    	List<String> cities = (List<String>) m .get("cities");
    	
    	for(int i=0; i<names.size();i++)
    		System.out.println(names.get(i)+"\t"+cities.get(i));
    	
    }
}


















