package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class ArticleList implements Serializable {
    private ArrayList<Article> articles;

    public ArticleList(){
        articles = new ArrayList<>();
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void add(Article article){
        articles.add(article);
    }

    public void remove(Article article){
        articles.remove(article);
    }
}
