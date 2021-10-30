package Course;

public class course {
		private String id;
		private String name;
		private String introduce;
		private String hour;
		private String credit;
		private String semester;
		public course(String id , String name , String introduce , String hour , String credit,String semester){
			this.id=id;
			this.name=name;
			this.introduce=introduce;
			this.hour=hour;
			this.credit=credit;
			this.semester=semester;
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
		public String getIntroduce() {
			return introduce;
		}
		public void setIntroduce(String introduce) {
			this.introduce = introduce;
		}
		public String getHour() {
			return hour;
		}
		public void setHour(String hour) {
			this.hour = hour;
		}
		public String getCredit() {
			return credit;
		}
		public void setCredit(String credit) {
			this.credit = credit;
		}
		public String getSemester() {
			return semester;
		}
		public void setSemester(String semester) {
			this.semester = semester;
		}
}