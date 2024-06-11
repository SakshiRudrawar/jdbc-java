package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.model.Student;
import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;
import com.util.MyDatabase;

public class StudentDao {

	public int insertStudent(Student s) {
		int check = 0;
		String sql = "insert into student(sname,scity,spercentage)values(?,?,?)";
		try (Connection con = MyDatabase.myConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			
			pst.setString(1, s.getSname());
			pst.setString(2, s.getScity());
			pst.setDouble(3, s.getSpercentage());
			check = pst.executeUpdate();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return check;

	}
	
	// delete student by id
	
	public int deleteStudentBySid(int sid)
	{
		int check =0;
		
		String sql = "delete from student where sid=?";
		try(Connection con = MyDatabase.myConnection();
				PreparedStatement pst = con.prepareStatement(sql);){
			pst.setInt(1, sid);
			check = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}
	
	
	// find student by sid
	
	public Student findStudentBySid(int sid)
	{
		Student s = null;
		String sql = "select sid , sname, scity, spercentage from student where sid=?";
		try(Connection con = MyDatabase.myConnection();
				PreparedStatement pst = con.prepareStatement(sql);){
			
			pst.setInt(1, sid);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				s = new Student();
				s.setSid((int)rs.getObject("sid"));
				s.setSname((String)rs.getObject("sname"));
				s.setScity((String)rs.getObject("scity"));
				s.setSpercentage((double)rs.getObject("spercentage"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return s;
	}
	
	
	// display all student
	
	public List<Student> findAllStudent()
	{
	    List<Student> list = new ArrayList<>(); // Use List<Student> instead of List<String>
	    String sql = "select sid, sname , scity, spercentage from student"; // Correct table name to "student"

	    try(Connection con = MyDatabase.myConnection();
	        PreparedStatement pst = con.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();){

	        while(rs.next()) { // Loop through the result set
	            Student s = new Student();
	            s.setSid((int)rs.getObject("sid"));
				s.setSname((String)rs.getObject("sname"));
				s.setScity((String)rs.getObject("scity"));
				s.setSpercentage((double)rs.getObject("spercentage"));
	            list.add(s);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return list;
	}

	// update student
	
	public int UpdateStudent(Student s)
	{
		int check =0;
		String sql = "update student set sname=? , scity=? , spercentage=? where sid=?";
		 try(Connection con = MyDatabase.myConnection();
			        PreparedStatement pst = con.prepareStatement(sql);){
			 pst.setString(1, s.getSname());
			 pst.setString(2, s.getScity());
			 pst.setDouble(3,s.getSpercentage());
			 pst.setInt(4,s.getSid());
			 check = pst.executeUpdate();
		 } catch (SQLException e) {
			e.printStackTrace();
		}
		 
		return check;
	}
	
	
	// find student by name
	
	public List<Student> findStudentByName(String sname) {
	    List<Student> list = new ArrayList<>();
	    String sql = "SELECT sid, sname, scity, spercentage FROM student WHERE sname=?";
	    
	    try (Connection con = MyDatabase.myConnection();
	         PreparedStatement pst = con.prepareStatement(sql)) {
	        
	        pst.setString(1, sname);
	        ResultSet rs = pst.executeQuery();
	        
	        while (rs.next()) {
	            Student s = new Student();
	            s.setSid((int)rs.getObject("sid"));
				s.setSname((String)rs.getObject("sname"));
				s.setScity((String)rs.getObject("scity"));
				s.setSpercentage((double)rs.getObject("spercentage"));
	            list.add(s);
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return list;
	}
	
	// find student by sname like
	
	public List<Student> findStudentBySnameLike(String sname)
	{
		List<Student> list = new ArrayList<>();
	    String sql = "SELECT sid, sname, scity, spercentage FROM student WHERE sname like '%"+sname+"%'";
	    
	    try (Connection con = MyDatabase.myConnection();
	         PreparedStatement pst = con.prepareStatement(sql);
	    		ResultSet rs = pst.executeQuery();) {
	        
	        while (rs.next()) {
	            Student s = new Student();
	            s.setSid((int)rs.getObject("sid"));
				s.setSname((String)rs.getObject("sname"));
				s.setScity((String)rs.getObject("scity"));
				s.setSpercentage((double)rs.getObject("spercentage"));
	            list.add(s);
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return list;
	}
	
	
	// method to find student by name or city
	
	public List<Student> findStudentBySnameOrScity(String sname) // passing sname in both sname and scity , becoz in bracket we use string sname
	{
		List<Student> list = new ArrayList<>();
	    String sql = "SELECT sid, sname, scity, spercentage FROM student WHERE sname like '%"+sname+"%' or scity like '%"+sname+"%'";
	    
	    try (Connection con = MyDatabase.myConnection();
	         PreparedStatement pst = con.prepareStatement(sql);
	    		ResultSet rs = pst.executeQuery();) {
	        
	        while (rs.next()) {
	            Student s = new Student();
	            s.setSid((int)rs.getObject("sid"));
				s.setSname((String)rs.getObject("sname"));
				s.setScity((String)rs.getObject("scity"));
				s.setSpercentage((double)rs.getObject("spercentage"));
	            list.add(s);
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return list;
		
	}
	
	// method to find student by percentage greater than
	
	public List<Student> findStudentByPercentageGreaterThan(double spercentage)
	{
		List<Student> list = new ArrayList<>();
	    String sql = "SELECT sid, sname, scity, spercentage FROM student where spercentage>=?";
	    
	    try (Connection con = MyDatabase.myConnection();
	         PreparedStatement pst = con.prepareStatement(sql);) {
	    	
	    	pst.setDouble(1, spercentage);
	    	ResultSet rs = pst.executeQuery();
	        
	        while (rs.next()) {
	            Student s = new Student();
	            s.setSid((int)rs.getObject("sid"));
				s.setSname((String)rs.getObject("sname"));
				s.setScity((String)rs.getObject("scity"));
				s.setSpercentage((double)rs.getObject("spercentage"));
	            list.add(s);
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return list;
		
		
	}
	
	// method to find student spercentage between
	
	public List<Student> findStudentByPercentageBetween(double low , double high)
	{
		List<Student> list = new ArrayList<>();
	    String sql = "SELECT sid, sname, scity, spercentage FROM student where spercentage between ? and ?"; 
	    // for not betweeen
	    //String sql = "SELECT sid, sname, scity, spercentage FROM student where spercentage not between ? and ?"; 
	    try (Connection con = MyDatabase.myConnection();
	         PreparedStatement pst = con.prepareStatement(sql);) {
	    	
	    	pst.setDouble(1, low);
	    	pst.setDouble(2, high);
	    	ResultSet rs = pst.executeQuery();
	        
	        while (rs.next()) {
	            Student s = new Student();
	            s.setSid((int)rs.getObject("sid"));
				s.setSname((String)rs.getObject("sname"));
				s.setScity((String)rs.getObject("scity"));
				s.setSpercentage((double)rs.getObject("spercentage"));
	            list.add(s);
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return list;
		
	}
	
	
	// method to find student by any
	
	public List<Student> findStudentByAny(String value)
	{
		List<Student> list = new ArrayList<>();
	    String sql = "SELECT sid, sname, scity, spercentage FROM student WHERE sname like '%"+value+"%' or scity like '%"+value+"%'";
	    
	    boolean b = false;
	    for(int i=0; i<value.length();i++) {
	    	if(Character.isAlphabetic(value.charAt(i)))
	    	{
	    		b=true;
	    		break;
	    	}
	    }
	    
	    if(!b)
	    	sql+="or sid="+value+" or spercentage="+value;
	    	
	    	
	    try (Connection con = MyDatabase.myConnection();
	         PreparedStatement pst = con.prepareStatement(sql);
	    		ResultSet rs = pst.executeQuery();) {
	        
	        while (rs.next()) {
	            Student s = new Student();
	            s.setSid((int)rs.getObject("sid"));
				s.setSname((String)rs.getObject("sname"));
				s.setScity((String)rs.getObject("scity"));
				s.setSpercentage((double)rs.getObject("spercentage"));
	            list.add(s);
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return list;
		
	}


	 // find the name of all student
	
		public List<String> findSnameOfStudent()
		{
			List<String> list = new ArrayList();
			String sql = "select sname from student";
			
			 try (Connection con = MyDatabase.myConnection();
			         PreparedStatement pst = con.prepareStatement(sql);
			    		ResultSet rs = pst.executeQuery();) {
			        
			        while (rs.next()) {
			        	
			        	list.add((String)rs.getObject("sname"));
						
			        }
			        
			    } catch (SQLException e) {
			        e.printStackTrace();
			    }
			    
			    return list;
			
		}
		
		
		// find name and city of all student
		
		public Map<String , List<String>> findSnameAndCityOfStudent()
		{
			Map<String , List<String>> m = new HashMap();
			String sql = "select sid, sname, scity from student";
			List<Integer> id = new ArrayList();
			List<String> name = new ArrayList();
			List<String> city = new ArrayList();
			
			try(Connection con = MyDatabase.myConnection();
					PreparedStatement pst = con.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();){
				
					while(rs.next())
					{
						name.add((String)rs.getObject("sname"));
						city.add((String)rs.getObject("scity"));
					}
					
				   m.put("names" , name);
				   m.put("cities", city);
				   
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return m;
		}
		
		
		
		
		
		

		
		
}
























