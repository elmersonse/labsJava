package lab;

import java.util.*;

public class KomnataCollection extends Abstract{
    Comparator<Komnata> comparator = new Comparator<Komnata>() {
        @Override
        public int compare(Komnata o1, Komnata o2) {
            if(o1.getNomer() < o2.getNomer()) {
                return -1;
            }
            else if(o1.getNomer() > o2.getNomer()) {
                return 1;
            }
            else {
                return 0;
            }
        }
    };
    Set<Komnata> komnaty = new TreeSet<Komnata>(comparator);

    public void Init() {
        komnaty.add(new Komnata(101, "Living"));
        komnaty.add(new Komnata(302, "living"));
        komnaty.add(new Komnata(201, "living"));
    }

    public Set<Komnata> getKomnaty() {
        return komnaty;
    }

    public void ToString() {
        Iterator<Komnata> iterator = komnaty.iterator();
        while (iterator.hasNext()) {
            iterator.toString();
        }
    }

    @Override
    public boolean isEmpty() {
        Iterator<Komnata> iterator = komnaty.iterator();
        while (iterator.hasNext()) {
            if(iterator.next()!=null) {
                return false;
            }
        }
        return true;
    }
}
