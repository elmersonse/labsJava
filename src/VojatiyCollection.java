import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class VojatiyCollection extends Abstract{
    List<Vojatiy> vojatie = new ArrayList<Vojatiy>();
    Comparator<Vojatiy> comparator = new Comparator<Vojatiy>() {
        @Override
        public int compare(Vojatiy o1, Vojatiy o2) {
            if(o1.getName().compareTo(o2.getName()) < 0) {
                return -1;
            }
            else if(o1.getName().compareTo(o2.getName()) > 0) {
                return 1;
            }
            else {
                return 0;
            }
        }
    };

    public void Init() {
        vojatie.add(new Vojatiy("Nikolay"));
        vojatie.add(new Vojatiy("Alexey"));
        vojatie.add(new Vojatiy("Ruslan"));
    }

    public List<Vojatiy> getVojatie() {
        return vojatie;
    }

    public void ToString() {
        for (int i = 0; i < 5; i++) {
            vojatie.get(i).toString();
        }
    }

    @Override
    public boolean isEmpty() {
        for(int i=0; i<3; i++) {
            if(vojatie.get(i) !=null) {
                return false;
            }
        }
        return true;
    }

    public void sort() {
        vojatie.sort(comparator);
    }
}
