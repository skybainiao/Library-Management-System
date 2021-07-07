import File.Adapter;
import Model.Article;
import Model.ArticleList;
import Model.Book;
import Model.BookList;

import java.io.IOException;

public class DataInit {
  public static void main(String[] args) throws IOException {
    // TODO: 07/07/2021 This is BookDataInit
    Adapter adapter = new Adapter("library.bin");

    BookList bookList = new BookList();

    Book book = new Book("a","a","12","released",null,null,null,null,null,"1232134256");
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
  }
}
