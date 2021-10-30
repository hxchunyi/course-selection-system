package Student;

public class Student {
private String id;
private String name;
private String sex;
private String birthday;
private String nat;
private String pss;
private String avatar;
public Student(String id , String name , String sex , String birthday , String nat,String pss,String avatar){
	this.id=id;
	this.name=name;
	this.birthday=birthday;
	this.sex=sex;
	this.nat=nat;
	this.pss=pss;
	this.avatar=avatar;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getBirthday() {
	return birthday;
}
public void setBirthday(String birthday) {
	this.birthday = birthday;
}
public String getNat() {
	return nat;
}
public void setNat(String nat) {
	this.nat = nat;
}
public String getPss() {
	return pss;
}
public void setPss(String pss) {
	this.pss = pss;
}
public String getAvatar() {
	return avatar;
}
public void setAvatar(String Avatar) {
	this.avatar = avatar;
}
}

