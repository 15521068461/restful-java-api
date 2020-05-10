package my;

import java.sql.SQLIntegrityConstraintViolationException;

import org.json.JSONObject;

import af.web.restful.AfRestfulApi;
import javafx.print.JobSettings;

public class StudentAddApi extends AfRestfulApi
{


	@Override
	public Object execute(JSONObject jreq) throws Exception
	{
		System.out.println("给个招呼");
		// 取得请求参数
		int id = jreq.getInt("id");
		String name = jreq.optString("name", "");
		boolean sex = jreq.optBoolean("sex", true);
		String cellphone = jreq.optString("cellphone", "");

		// 参数检查
		if (id <= 0)
			throw new Exception("ID必须为正值!");
		if (name.length() == 0)
			throw new Exception("姓名不得为空!");
        
		
		
		
		
		Student stu = new Student(id, name, sex, cellphone);	
		JSONObject j = new JSONObject(stu);
		DataBase db = new DataBase();
		

		  if(  db.addStudent(stu)==false)	{
			  return null ;
		  }
	

	     return j ;

  
		// 注意：返回 null是正常情形，不表示错误！
		// 返回null 仅仅表示客户端浏览器不需要返回什么特别的数据 。
		// 只有 throw了Exception ，才表示在处理过程中发生了错误。
    
	}

}
