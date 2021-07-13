package Model;


import java.io.Serializable;

public class Article extends Borrower implements Serializable {
    private String ArtTitle;
    private String ArTWriter;
    private String ArtReleaseTime;
    private String ArtStatus;

    public Article(String ArtTitle,String ArTWriter,String ArtReleaseTime,String ArtStatus,String name,String email,String identity,String borrowTime,String returnTime){
        super(name, email, identity, borrowTime, returnTime);
        this.ArtTitle=ArtTitle;
        this.ArTWriter=ArTWriter;
        this.ArtReleaseTime=ArtReleaseTime;
        this.ArtStatus=ArtStatus;
    }

    public void setStatus(String ArtStatus) {
        this.ArtStatus = ArtStatus;
    }

    public String getStatus() {
        return ArtStatus;
    }

    public void setReleaseTime(String ArtReleaseTime) {
        this.ArtReleaseTime = ArtReleaseTime;
    }

    public String getReleaseTime() {
        return ArtReleaseTime;
    }

    public void setTitle(String ArtTitle) {
        this.ArtTitle = ArtTitle;
    }

    public void setWriter(String ArTWriter) {
        this.ArTWriter = ArTWriter;
    }

    public String getTitle() {
        return ArtTitle;
    }

    public String getWriter() {
        return ArTWriter;
    }

    public String getToString(){
        return super.toString();
    }

    @Override
    public String toString() {
        return "              Title: " + "<<"+ArtTitle+">>"  +
                "               Writer: " + ArTWriter +
                "               ReleaseTime: " + ArtReleaseTime +
                "               Status: " + ArtStatus;
    }
}
