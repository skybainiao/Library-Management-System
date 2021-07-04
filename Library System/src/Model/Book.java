package Model;

import java.io.Serializable;

public class Book implements Serializable
{
  private String title;
  private String writer;

  public Book(String title,String writer){
    this.title=title;
    this.writer=writer;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public void setWriter(String writer)
  {
    this.writer = writer;
  }

  public String getTitle()
  {
    return title;
  }

  public String getWriter()
  {
    return writer;
  }

  @Override public String toString()
  {
    return "Title='" + title + '\'' + ", Writer='" + writer;

  }
}
