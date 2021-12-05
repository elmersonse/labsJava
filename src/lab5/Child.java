package lab5;

import java.sql.Date;
import java.util.Objects;

public class Child extends ChildCollection implements Interface{
    static public int count=0;
    private int code;
    private String name;
    private Date bdate;
    private int ocode;
    private int kcode;

    public Child() {
        count++;
        code=count;
        name="";
        bdate = new Date(0);
        ocode=0;
        kcode=0;
    }

    public Child(String s1, String s2, int i1, int i2) {
        count++;
        code=count;
        name=s1;
        bdate=Date.valueOf(s2);
        ocode=i1;
        kcode=i2;
    }

    public void setName(String name) {
        this.name=name;
    }

    public void setBdate(String bdate) {
        this.bdate=Date.valueOf(bdate);
    }

    public void setKcode(int kcode) {
        this.kcode = kcode;
    }

    public void setOcode(int ocode) {
        this.ocode = ocode;
    }

    @Override
    public int getCode() {
        return code;
    }

    public Date getBdate() {
        return bdate;
    }

    public int getKcode() {
        return kcode;
    }

    public int getOcode() {
        return ocode;
    }

    public void print(){
        System.out.format("|%8d| %30s| %10s| %8d| %8d|\n", code, name, bdate.toString(), ocode, kcode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Child child = (Child) o;
        return ocode == child.ocode && kcode == child.kcode && Objects.equals(name, child.name) && Objects.equals(bdate, child.bdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, bdate, ocode, kcode);
    }

    public String toString(Otryad[] omas, Komnata[] kmas) {
        String s1=new String(), s2=new String();
        int i;
        for(i=0; i<omas.length; i++) {
            if(omas[i].getCode()==ocode) {
                s1=omas[i].getName();
                break;
            }
        }
        if(i==omas.length) {
            s1="-";
        }
        for(i=0; i<kmas.length; i++) {
            if(kmas[i].getCode()==kcode) {
                s2=String.valueOf(kmas[i].getNomer());
                break;
            }
        }
        if(i==kmas.length) {
            s2="-";
        }
        return code+"; "+name+"; "+bdate+"; "+s1+"; "+s2;
    }

    @Override
    public boolean isEmpty() {
        if(name=="" && bdate == new Date(0) && ocode==0 && kcode==0) {
            return true;
        }
        return false;
    }
}
