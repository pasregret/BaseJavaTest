package cn.itcast.oa.domain;

public class Book {
     //测试实体类
	 private Long id;
	 private String name;
	 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + "]";
	}
	 
	 
	
}
