import File.Adapter;
import Model.*;

import java.io.IOException;

public class DataInit {
  public static void main(String[] args) throws IOException {
    // TODO: 07/07/2021 This is BookDataInit
    Adapter adapter = new Adapter("library.bin");

    BookList bookList = new BookList();

    Book book = new Book("Anna Karenina","Leo Tolstoy","12","released",null,null,null,null,null,"1232134256");
    Book book1 = new Book("a","b","12","released",null,null,null,null,null,"3214");
    Book book2 = new Book("1","b","12","released",null,null,null,null,null,"32142");
    bookList.addBook(book);
    bookList.addBook(book1);
    bookList.addBook(book2);

    adapter.addBookList(bookList);
    System.out.println(adapter.getBookList().getBooks());

    // TODO: 07/07/2021 This is ArticleDataInit
    Adapter adapter1 = new Adapter("Article.bin");

    ArticleList articleList = new ArticleList();

    Article article = new Article("a","a","12","released",null,null,null,null,null);
    Article article1 = new Article("a","a","12","released",null,null,null,null,null);
    articleList.add(article);
    articleList.add(article1);

    adapter1.addArticleList(articleList);
    System.out.println(adapter1.getArticleList().getArticles());

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
  }
}
