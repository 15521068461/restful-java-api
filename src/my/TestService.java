package my;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import af.web.restful.AfSimpleREST;

@WebServlet("/Test")
public class TestService extends AfSimpleREST
{

	@Override
	protected Object execute(HttpServletRequest request, 
			HttpServletResponse response, 
			JSONObject jreq) throws Exception
	{
		// 取出请求参数
		int id = jreq.optInt("id");
		if(id <= 0)
			throw new Exception("ID必须为正值!");
		
		// 处理
		
		// 应答数据
		JSONObject jresp = new JSONObject();
		jresp.put("id", id);
		jresp.put("name", "shaofa");
		jresp.put("sex", true);
		jresp.put("cellphone", "13810012345");
		return jresp;
	}

}
