package funix.prm.prm391x_project2_huannhfx02928;

public class Item {
    private  String name; // thuộc tính thông tin tra cứu
    public Item(String name){ // gắn giá trị thuộc tính
        this.name = name;
    }
    public String getName(){ // Trả về giá trị thuộc tính
        return name;
    }
    public void setName(String name){ // sửa giá trị thuộc tính
        this.name = name;
    }
}
