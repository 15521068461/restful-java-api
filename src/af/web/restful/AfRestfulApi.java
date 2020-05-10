package af.web.restful;

import org.json.JSONObject;

import af.web.AfWebException;
import af.web.service.AfGenericApi;

public abstract class AfRestfulApi extends AfGenericApi
{
	protected boolean enableErrorLog = true; // 是否打印异常输出
	protected boolean niceJSONFormat = true; // 输出的JSON是否综进 (缩进影响运行效率)
	
	public abstract Object execute(JSONObject jreq) throws Exception;	
	
	@Override
	public String execute(String strReq) throws Exception
	{
		// 处理请求数据
		JSONObject jresp = new JSONObject();
		try
		{
			// 读取请求数据, 转成字符串, 转成 JSON
			JSONObject jreq = null;
			if (strReq.length() > 0)				
				jreq = new JSONObject(strReq);

			Object data = execute(jreq);
			jresp.put("error", 0); // 错误码,0表示成功
			jresp.put("reason", "OK"); // 错误原因描述, 如果没有错误则提示OK
			if (data != null)
				jresp.put("data", data); //
			
		} catch (AfWebException e)
		{
			String reason = e.getMessage();
			if(reason == null) reason = e.getClass().getName();
			System.out.println("** " + getClass().getName() + ": " + e.getMessage());
			
			// 出错应答
			jresp.put("error", e.error); // 错误码,0表示成功
			jresp.put("reason", reason); // 错误原因描述
			if (enableErrorLog)
				e.printStackTrace();
			
		} catch (Exception e)
		{
			String reason = e.getMessage();
			if(reason == null) reason = e.getClass().getName();
			System.out.println("** " + getClass().getName() + ": " + e.getMessage());

			jresp.put("error", -1); // 错误码,0表示成功
			jresp.put("reason", e.getMessage()); // 错误原因描述
			if (enableErrorLog)
				e.printStackTrace();
		}
		
		// 返回给客户端
		if( niceJSONFormat ) 
			return jresp.toString(2); // 缩进格式
		else 
			return jresp.toString();
	}


}
