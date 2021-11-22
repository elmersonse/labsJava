import java.util.Objects;

public class Otryad extends OtryadCollection implements Interface{
    static private int count=0;
    private int code;
    private String name;
    private int vcode;

    public Otryad() {
        count++;
        code=count;
        name="";
        vcode=0;
    }

    public Otryad(String s1, int i1) {
        count++;
        code=count;
        name=s1;
        vcode=i1;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVcode(int vcode) {
        this.vcode = vcode;
    }

    @Override
    public int getCode() {
        return code;
    }

    public int getVcode() {
        return vcode;
    }

    public String getName() {
        return name;
    }

    public void print() {
        System.out.format("|%8d| %20s| %8d|\n", code, name, vcode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Otryad otryad = (Otryad) o;
        return vcode == otryad.vcode && Objects.equals(name, otryad.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, vcode);
    }

    public String toString(Vojatiy[] vmas) {
        String s = new String();
        int i;
        for(i=0; i<vmas.length; i++) {
            if(vmas[i].getCode()==vcode) {
                s=vmas[i].getName();
                break;
            }
        }
        if(i==vmas.length) {
            s="-";
        }
        return code+"; "+name+"; "+s;
    }

    @Override
    public boolean isEmpty() {
        if(name=="" && vcode==0) {
            return true;
        }
        return false;
    }

}
