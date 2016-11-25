package org.janardhan.datastructure;

public class StudentComparable implements Comparable<StudentComparable> {

	private int studentID;
	private String studentName;
	private int age;

	public StudentComparable(int studentID, String studentName, int age) {

		this.studentID = studentID;
		this.studentName = studentName;
		this.age = age;

	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(StudentComparable studentComparable) {

		int age = studentComparable.getAge();
		// ascending the order
		return this.age - age;
	}

	public String toString() {

		return this.getClass().getSimpleName() + " studentId= " + this.studentID + " studentName " + this.studentName + " studentAge " + this.age + " \n";
	}
}
