package my;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 数据源,维持一个全局的Student列表
 * @author shaofa
 *
 */
public class DataSource
{
	// 全局对象
	public static DataSource i = new DataSource();//第一次创建会调用构造方法
	
	//
	public List<Student> list = new ArrayList<>();
	
	private DataSource()
	{
		// 初始化加入一些记录，方便测试
		list.add( new Student(20190001, "莫凡", true, "13810012345") );
		list.add( new Student(20190002, "穆宁雪", false, "18600012990") );
		list.add( new Student(20190003, "叶心夏", false, "18192394889") );
		list.add( new Student(20190004, "赵满延", true, "13899008983") );
		list.add( new Student(20190005, "穆白", true, "13799389990") );
		list.add( new Student(20190006, "张小侯", true, "18900091993") );
		list.add( new Student(20190007, "唐月", false, "18934001833") );
		list.add( new Student(20190008, "斩空", true, "15299808821") );
	}
	//添加学生
	public void add(Student s)
	{
		list.add( s );
	}
	//查询学生
	public List<Student> list(String name)
	{
		List<Student> result = new ArrayList<Student>();
		System.out.println("看看");
		System.out.println(list.size());
		//System.out.println("看看");

		for(Student s :list)
		{   System.out.println(s.name+"好好");
			if(s.name.indexOf( name ) >=0 ) 
			{
				result.add( s );
			}
		}
		return result;
	}
	//删除学生
	public boolean remove(int id)
	{

		Iterator<Student> iter = list.iterator();
		while(iter.hasNext())
		{
			Student s = iter.next();
			if(s.getId() == id)
			{
				iter.remove();
			System.out.println("帅哥");
				return true;
			}
		}
		return false;
	}
	
	
}
