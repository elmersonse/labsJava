import java.util.Objects;

public class Komnata extends KomnataCollection implements Interface{
    static private int count=0;
    private int code;
    private int nomer;
    private String type;

    public Komnata() {
        count++;
        code=count;
        nomer=0;
        type="";
    }

    public Komnata(int i1, String s1) {
        count++;
        code=count;
        nomer=i1;
        type=s1;
    }

    public void setNomer(int nomer) {
        this.nomer = nomer;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int getCode() {
        return code;
    }

    public int getNomer() {
        return nomer;
    }

    public String getType() {
        return type;
    }

    public void print() {
        System.out.format("|%8d| %8d| %20s|\n", code, nomer, type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Komnata komnata = (Komnata) o;
        return nomer == komnata.nomer && Objects.equals(type, komnata.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomer, type);
    }

    public String toString() {
        return code+"; "+nomer+"; "+type;
    }

    @Override
    public boolean isEmpty() {
        if(nomer==0 && type=="") {
            return true;
        }
        return false;
    }
}
