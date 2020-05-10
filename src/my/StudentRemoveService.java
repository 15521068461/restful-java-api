package my;

import java.util.HashMap;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import af.web.restful.AfRestfulApi;

public class StudentRemoveService extends AfRestfulApi
{
	@Override
	public Object execute(JSONObject jreq) throws Exception
	{
		int id = jreq.getInt("id");
		DataBase db = new DataBase();
		if( db.deleteStudentBySno(id))
		{
			System.out.println("已近删除你了！");
		}
		
		return null;
	}

}
