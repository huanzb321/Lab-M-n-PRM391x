package funix.prm.prm391xlabs_15_sqlite;

public class Student  {
    private int id;
    private String name;
    private String address;
    private String phone_number;
    public Student(int id, String name, String address, String phonenumber) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone_number = phonenumber;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public String getPhone_number() {
        return phone_number;
    }
}
