package compare;

/**
 * @Author ZhangXD
 * @Date 2021/9/16 11:10
 * @Description
 */
public class Student implements Comparable<Student>{

    private String id;

    private String name;

    private Integer age;

    public Student(String id, String name, Integer age) {
        this.id = id;
        this.age = age;
        this.name = name;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Student)) {
            return false;
        }

        Student student = (Student) o;

        if (getId() != null ? !getId().equals(student.getId()) : student.getId() != null) {
            return false;
        }
        if (getName() != null ? !getName().equals(student.getName()) : student.getName() != null) {
            return false;
        }
        return getAge() != null ? getAge().equals(student.getAge()) : student.getAge() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getAge() != null ? getAge().hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Student s) {
        System.out.println(this.getId());
        System.out.println(s.getId());
        return - Integer.parseInt(this.getId()) + Integer.parseInt(s.getId());
    }
}
