package my;

import java.util.HashMap;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import af.web.restful.AfRestfulApi;

public class StudentQueryService extends AfRestfulApi
{
	@Override
	public Object execute(JSONObject jreq) throws Exception
	{
		String name = jreq.getString("filter");
		System.out.println(name);
		DataBase db = new DataBase();
		List<Student> rows = db.queryStudentByName(name);

		JSONArray result = new JSONArray(rows);
		return result;
	}

}
