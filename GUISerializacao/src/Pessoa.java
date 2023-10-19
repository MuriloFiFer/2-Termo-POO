import java.io.Serializable;



public class Pessoa implements Serializable{
    private String name;
    private int age;

    public Pessoa (String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Pessoa() {
    }

    public String getName(){
        return name;
    }

    public int getAge() {
        return age;
    }
    
}
