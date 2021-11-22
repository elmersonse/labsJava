import java.util.Objects;

public class Vojatiy extends VojatiyCollection implements Interface{
    static private int count=0;
    private int code;
    private String name;

    public Vojatiy() {
        count++;
        code=count;
        name="";
    }

    public Vojatiy(String s) {
        count++;
        code=count;
        name=s;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void print() {
        System.out.printf("|%8d| %20s|\n", code, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vojatiy vojatiy = (Vojatiy) o;
        return Objects.equals(name, vojatiy.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String toString() {
        return code+"; "+name;
    }

    @Override
    public boolean isEmpty() {
        if(name=="") {
            return true;
        }
        return false;
    }
}