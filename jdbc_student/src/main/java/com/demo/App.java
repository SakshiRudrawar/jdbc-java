package com.demo;

import java.util.List;
import java.util.Random;

import com.dao.StudentDao;
import com.model.Student;

public class App 
{
    public static void main( String[] args )
    {
        
 
//-----------------------------------------------------------------------------
        // insert part 
    	 //StudentDao sd = new StudentDao();
//        Student s = new Student();
//        s.setSname("ketaki kothalkar");
//        s.setScity("mumbai");
//        s.setSpercentage(82.70);
//        
//        System.out.println(sd.insertStudent(s));
   
 // ------------------------------------------------------------------------
         // delete part
    	 // StudentDao sd = new StudentDao();
        //System.out.println(sd.deleteStudentBySid(2));
       
// --------------------------------------------------------------------------
        // find student
        //StudentDao sd = new StudentDao();
        //Student s = sd.findStudentBySid(1);
        //System.out.println(s);
        
// --------------------------------------------------------------------------
        //display all
//    	 StudentDao sd = new StudentDao();
//         List<Student> list = sd.findAllStudent();
//         for (Student s : list) {
//             System.out.println(s);
//             }
    
    
    
 // -------------------------------------------------------------------------
    	//update student
    	
//    	StudentDao sd = new StudentDao();
//    	Student s = sd.findStudentBySid(1);
//    	System.out.println(s);
//    	s.setSname("piyu  Rudrawar");
//    	s.setSpercentage(90.00);
//    	System.out.println(sd.updateStudent(s));
    	
    	
// -----------------------------------------------------------------------------
    	// add random record
    	StudentDao sd = new StudentDao();
    	
    	for(int i=1; i<=300; i++)
    	{
    		Student s = new Student();
    		StringBuilder sname = new StringBuilder();
    		
    		for(int j=1; j<=15;j++)
    		{
    			sname.append((char)(new Random().nextInt(26)+65));
    			s.setSname(sname.toString());
    			StringBuilder scity = new StringBuilder();
    			
    			for( j=1; j<=15; j++)
    				scity.append((char)(new Random().nextInt(26)+65));
    			s.setScity(scity.toString());
    			
    			s.setSpercentage(new Random().nextDouble()*100);
    			System.out.println(sd.insertStudent(s));
    		}
    	
    	
    
    
    }
}
    
}
















