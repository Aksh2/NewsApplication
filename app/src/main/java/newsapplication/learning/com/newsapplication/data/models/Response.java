package newsapplication.learning.com.newsapplication.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response {
    @SerializedName("articles")
    List<Article> articleList;

    public List<Article> getArticleList() {
        return articleList;
    }

    @Override
    public String toString() {
        return "Response{" +
                "articleList=" + articleList +
                '}';
    }
}
