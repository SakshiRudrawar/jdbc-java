package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Student;

public class StudentDao {

	public int insertStudent(Student s) {
		int check = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jap55", "root", "1234");
			String sql = "insert into student(sname , scity , spercentage)values(?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, s.getSname());
			pst.setString(2, s.getScity());
			pst.setDouble(3, s.getSpercentage());
			check = pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return check;
	}

	// delete part

	public int deleteStudentBySid(int sid) {
		int check = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jap55", "root", "1234");
			String sql = "delete from Student where sid=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, sid);
			check = pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return check;
	}

	// display

	public Student findStudentBySid(int sid) {
	    Student s = null;
	    String url = "jdbc:mysql://localhost:3306/jap55";
	    String user = "root";
	    String password = "1234";

	    String sql = "SELECT sid, sname, scity, spercentage FROM student WHERE sid = ?";

	    try {
	        // Load the JDBC driver
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        // Establish connection, prepare statement, and execute query using try-with-resources
	        try (
	            Connection con = DriverManager.getConnection(url, user, password);
	            PreparedStatement pst = con.prepareStatement(sql);
	        ) {
	            pst.setInt(1, sid);

	            try (ResultSet rs = pst.executeQuery()) {
	                if (rs.next()) {
	                    s = new Student();
	                    s.setSid(rs.getInt("sid"));
	                    s.setSname(rs.getString("sname"));
	                    s.setScity(rs.getString("scity"));
	                    s.setSpercentage(rs.getDouble("spercentage"));
	                }
	            }
	        }
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }

	    return s;
	}

	// display all student
	
	public List<Student> findAllStudent() {
        List<Student> list = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/jap55";
        String user = "root";
        String password = "1234";
        String sql = "SELECT sid, sname, scity, spercentage FROM student";

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Use try-with-resources to ensure resources are closed
            try (
                Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement pst = con.prepareStatement(sql);
                ResultSet rs = pst.executeQuery()
            ) {
                while (rs.next()) {
                    Student s = new Student();
                    s.setSid(rs.getInt("sid"));
                    s.setSname(rs.getString("sname"));
                    s.setScity(rs.getString("scity"));
                    s.setSpercentage(rs.getDouble("spercentage"));
                    list.add(s);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return list;
	}

	
	// update student
	

		
	public int updateStudent(Student s) {
	    int check = 0;
	    Connection con = null;
	    PreparedStatement pst = null;
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jap55", "root", "1234");
	        
	        // Correct SQL query for updating a student's details
	        String sql = "UPDATE Student SET sname=?, scity=?, spercentage=? WHERE sid=?";
	        pst = con.prepareStatement(sql);
	        
	        // Setting the parameters correctly
	        pst.setString(1, s.getSname());
	        pst.setString(2, s.getScity());
	        pst.setDouble(3, s.getSpercentage());
	        pst.setInt(4, s.getSid());
	        
	        check = pst.executeUpdate();

	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (pst != null) pst.close();
	            if (con != null) con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return check;
	}
	
	
	
	
	

}
