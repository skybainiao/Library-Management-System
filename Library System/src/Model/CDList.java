package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class CDList implements Serializable {
    private ArrayList<CD> cdArrayList;

    public CDList(){
        cdArrayList = new ArrayList<>();
    }

    public ArrayList<CD> getCdArrayList(){
        return cdArrayList;
    }

    public void addCD(CD cd){
        cdArrayList.add(cd);
    }

    public void removeCD(CD cd){
        cdArrayList.remove(cd);
    }
}
