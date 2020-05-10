package my;

public class Student
{
	public int id;
	public String name;
	public boolean sex;
	public String cellphone;
	
	public Student()
	{
		
	}
	
	public Student(int id, String name, boolean sex, String cellphone)
	{
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.cellphone = cellphone;
	}
	
	////////////////////////////
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public boolean isSex()
	{
		return sex;
	}
	public void setSex(boolean sex)
	{
		this.sex = sex;
	}

	public String getCellphone()
	{
		return cellphone;
	}

	public void setCellphone(String cellphone)
	{
		this.cellphone = cellphone;
	}
	
}
