package lab;

import java.util.*;

public class OtryadCollection extends Abstract{
    Map<Integer, Otryad> otryady = new HashMap<Integer, Otryad>();
    Comparator<Otryad> comparator = new Comparator<Otryad>() {
        @Override
        public int compare(Otryad o1, Otryad o2) {
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
        otryady.put(0, new Otryad("Sunny", 1));
        otryady.put(1, new Otryad("Cloud", 2));
        otryady.put(2, new Otryad("Grass", 1));
        otryady.put(3, new Otryad("Sunny", 3));
        otryady.put(4, new Otryad("Flower", 2));
    }

    public Map<Integer, Otryad> getOtryady() {
        return otryady;
    }

    public void ToString() {
        for (int i = 0; i < 5; i++) {
            otryady.get(i).toString();
        }
    }

    @Override
    public boolean isEmpty() {
        for(int i=0; i<5; i++) {
            if(otryady.get(i)!=null) {
                return false;
            }
        }
        return true;
    }

    public void sort() {
        Otryad temp;
        for (int i=0; i<5; i++) {
            for(int j=1; j<5-i; j++) {
                if(comparator.compare(otryady.get(j-1), otryady.get(j)) > 0) {
                    temp = otryady.get(j-1);
                    otryady.replace(j-1, otryady.get(j));
                    otryady.replace(j, temp);
                }
            }
        }
    }
}
