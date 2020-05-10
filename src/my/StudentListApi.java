package my;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import af.web.restful.AfRestfulApi;

public class StudentListApi extends AfRestfulApi
{

	@Override
	public Object execute(JSONObject jreq) throws Exception
	{
		// 直接把 List 转成 JSONArray , 要求List内的元素是POJO类型
		DataBase db = new DataBase();
	List<Student> list = db.queryAllstudents(); 
		//List<Student> list = DataSource.i.list;
		JSONArray jresp = new JSONArray(list);
		System.out.println("酷酷酷酷酷酷酷酷");
		return jresp;
	}

}
