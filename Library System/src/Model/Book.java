package Model;

import java.io.Serializable;

public class Book extends Borrower implements Serializable {
  private String title;
  private String writer;
  private String releaseTime;
  private String status;
  private String ISBN;

  public Book(String title,String writer,String releaseTime,String status,String name,String email,String identity,String borrowTime,String returnTime,String ISBN){
    super(name, email, identity, borrowTime, returnTime);
    this.title=title;
    this.writer=writer;
    this.releaseTime=releaseTime;
    this.status=status;
    this.ISBN=ISBN;

  }

  public void setISBN(String ISBN) {
    this.ISBN = ISBN;
  }

  public String getISBN() {
    return ISBN;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getStatus() {
    return status;
  }

  public void setReleaseTime(String releaseTime) {
    this.releaseTime = releaseTime;
  }

  public String getReleaseTime() {
    return releaseTime;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setWriter(String writer) {
    this.writer = writer;
  }

  public String getTitle() {
    return title;
  }

  public String getWriter() {
    return writer;
  }


  @Override
  public String toString() {
    return "Book{" +
            "title='" + title + '\'' +
            ", writer='" + writer + '\'' +
            ", releaseTime='" + releaseTime + '\'' +
            ", status='" + status + '\'' + '}'+" "+super.toString();
  }
}
