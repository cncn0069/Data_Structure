package streamPractice;


public class OptionalMember {
	
	private String name;
	private int age;
	private String phoneNum;
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public OptionalMember(String name, int age, String phoneNum, String address) {
		super();
		this.name = name;
		this.age = age;
		this.phoneNum = phoneNum;
		this.address = address;
	}
	public OptionalMember() {
		super();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + " " + age + " " + phoneNum + " " + address;
	}
	
}
