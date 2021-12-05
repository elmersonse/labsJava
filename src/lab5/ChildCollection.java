package lab5;

public class ChildCollection extends Abstract{
    private Child[] dety = new Child[5];

    public void Init() {
        for(int i=0; i<5; i++) {
            dety[0] = new Child();
        }
    }

    public Child[] getDety() {
        return dety;
    }

    public void ToString() {
        for (int i = 0; i < 5; i++) {
            dety[i].toString();
        }
    }

    @Override
    public boolean isEmpty() {
        for(int i=0; i<5; i++) {
            if(dety[i]!=null) {
                return false;
            }
        }
        return true;
    }


}
