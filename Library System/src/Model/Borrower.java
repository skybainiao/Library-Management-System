package Model;

import java.io.Serializable;

public class Borrower implements Serializable {
    private String name;
    private String email;
    private String identity;
    private String borrowTime;
    private String returnTime;

    public Borrower(String name,String email,String identity,String borrowTime,String returnTime){
        this.name=name;
        this.email=email;
        this.identity=identity;
        this.borrowTime=borrowTime;
        this.returnTime=returnTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBorrowTime(String borrowTime) {
        this.borrowTime = borrowTime;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public String getName() {
        return name;
    }

    public String getBorrowTime() {
        return borrowTime;
    }

    public String getEmail() {
        return email;
    }

    public String getIdentity() {
        return identity;
    }

    public String getReturnTime() {
        return returnTime;
    }

    @Override
    public String toString() {
        return "Borrower{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", identity='" + identity + '\'' +
                ", borrowTime='" + borrowTime + '\'' +
                ", returnTime='" + returnTime + '\'' +
                '}';
    }
}
