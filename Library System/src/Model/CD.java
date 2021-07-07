package Model;

import java.io.Serializable;

public class CD implements Serializable {
    private String name;
    private String status;

    public CD(String name,String status){
        this.name=name;
        this.status=status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "CD{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

}
