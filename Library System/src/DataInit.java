import File.Adapter;
import Model.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DataInit {
  public static void main(String[] args) throws IOException {


    // TODO: 10/07/2021 Please don't run this class !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // TODO: 07/07/2021 This is BookDataInit
    Adapter adapter = new Adapter("library.bin");

    BookList bookList = new BookList();

    Book book = new Book("Anna Karenina","Leo Tolstoy","1798","released","","","","","","1232134256");
    Book book1 = new Book("Madame Bovary","Gustave Flaubert","1867","released","","","","","","21354352");
    Book book2 = new Book("War and Peace","Leo Tolstoy","1873","released","","","","","","532426667");
    bookList.addBook(book);
    bookList.addBook(book1);
    bookList.addBook(book2);

    adapter.addBookList(bookList);
    System.out.println(adapter.getBookList().getBooks());


    // TODO: 07/07/2021 This is ArticleDataInit
    Adapter adapter1 = new Adapter("Article.bin");

    ArticleList articleList = new ArticleList();

    Article article = new Article("Minimum Viable Personality","FakeGrimlock","2005","released",null,null,null,null,null);
    Article article1 = new Article("Why Content Marketing Fails","Rand Fishkin","1999","released",null,null,null,null,null);
    articleList.add(article);
    articleList.add(article1);

    adapter1.addArticleList(articleList);
    System.out.println(adapter1.getArticleList().getArticles());
    System.out.println(article.getToString());


    // TODO: 07/07/2021 This is CDDataInit
    Adapter adapter2 = new Adapter("CD.bin");

    CDList cdList = new CDList();

    CD cd = new CD("exile","Booked");
    CD cd1 = new CD("Burn","Borrowed");
    CD cd2 = new CD("Breathe","Booked");
    CD cd3 = new CD("Past Lives","Booked");
    CD cd4 = new CD("Freaks","Booked");
    CD cd5 = new CD("Closer","Booked");

    cdList.addCD(cd);
    cdList.addCD(cd1);
    cdList.addCD(cd2);
    cdList.addCD(cd3);
    cdList.addCD(cd4);
    cdList.addCD(cd5);

    adapter2.addCDList(cdList);
    System.out.println(adapter2.getCDList().getCdArrayList());


    // TODO: 13/07/2021 String Text
    Adapter adapter3 = new Adapter("String.bin");

    ArrayList<String> strings = new ArrayList<>();

    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    String s = "//"+dateTime.format(formatter)+";    "+"Hello";
    String s1 = "//"+dateTime.format(formatter)+";    "+"World";

    strings.add(s);
    strings.add(s1);

    adapter3.addStrings(strings);
    System.out.println(adapter3.getString());


  }
}
