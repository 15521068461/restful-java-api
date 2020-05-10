package my;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;


public class DataBase {
	private static final String URL ="jdbc:mysql://localhost:3306/testmysql?serverTimezone=UTC";
	  private static final String USERNAME="root";
	  private static final String  PWD ="root";
	  
	  
	  public boolean addStudent(Student student) {
	  	  Connection connection=null;
		PreparedStatement pstmt= null;
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL,USERNAME,PWD);
			try {
			String  sql ="insert into student3 (id,name,sex,cellphone) values (?,?,?,?) "  ;
			 pstmt=  connection.prepareStatement(sql);
			}catch (SQLIntegrityConstraintViolationException e) {
				return false ;
			}
           
			pstmt.setInt(1,student.getId());
			pstmt.setString(2,student.getName());
			pstmt.setBoolean(3,student.isSex());
			pstmt.setString(4,student.getCellphone());
		int count = pstmt.executeUpdate();
			if(count>0)
				return true;
			else
				return false;
				
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
			return false;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
	}
		finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(connection!=null)connection.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	}
	  
	  
	  public boolean deleteStudentBySno(int id) {
		  Connection connection=null;
			PreparedStatement pstmt= null;
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(URL,USERNAME,PWD);
				String  sql ="delete from student3 where id=? "  ;
	            pstmt=  connection.prepareStatement(sql);
				pstmt.setInt(1,id);
				
			int count = pstmt.executeUpdate();
				if(count>0)
					return true;
				else
					return false;
					
			} catch (ClassNotFoundException e) {			
				e.printStackTrace();
				return false;
			}catch (SQLException e) {
				e.printStackTrace();
				return false;
			}catch (Exception e) {
				e.printStackTrace();
				return false;
		}
			finally {
				try {
					if(pstmt!=null)pstmt.close();
					if(connection!=null)connection.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	  
	  }
	  public List<Student> queryAllstudents() {
		  List<Student> students = new ArrayList<>();
			Student student = null;
					Connection connection=null;
			PreparedStatement pstmt= null;
			ResultSet rs= null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(URL,USERNAME,PWD);
				String  sql ="select * from student3 ";
	            pstmt=  connection.prepareStatement(sql);
		        rs=pstmt.executeQuery();		
				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					boolean sex = rs.getBoolean("sex");
					String cellphone = rs.getString("cellphone");
					student =new Student(id,name,sex,cellphone);
					students.add(student);
					
				}		
					return students;	
					
			} catch (ClassNotFoundException e) {			
				e.printStackTrace();
				return null;
			}catch (SQLException e) {
				e.printStackTrace();
				return null;
			}catch (Exception e) {
				e.printStackTrace();
				return null;
			
		}
			finally {
				try {
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
					if(connection!=null)connection.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		}
	  
	  
	  
	  
	  public List<Student> queryStudentByName(String n) {
		  List<Student> students = new ArrayList<>();
			Student student = null;
					Connection connection=null;
			PreparedStatement pstmt= null;
			ResultSet rs= null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(URL,USERNAME,PWD);
				String  sql ="select * from student3 where name LIKE ? ";
	            pstmt=  connection.prepareStatement(sql);
	            String m = "%"+n+"%";
				pstmt.setString(1,m);		
		        rs=pstmt.executeQuery();		
		    	while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					boolean sex = rs.getBoolean("sex");
					String cellphone = rs.getString("cellphone");
					student =new Student(id,name,sex,cellphone);
					students.add(student);
					
				}
					return students;	
					
				
					
			} catch (ClassNotFoundException e) {			
				e.printStackTrace();
				return null;
			}catch (SQLException e) {
				e.printStackTrace();
				return null;
			}catch (Exception e) {
				e.printStackTrace();
				return null;
			
		}
			finally {
				try {
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
					if(connection!=null)connection.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		}
	  
	  
	  
	  
	  
}
