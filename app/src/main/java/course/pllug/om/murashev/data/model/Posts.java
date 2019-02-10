package course.pllug.om.murashev.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Posts {

    @SerializedName("userId")
    @Expose
    private long userId;

    @SerializedName("id")
    @Expose
    private long id;


    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("body")
    @Expose
    private String body;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long postId) {
        this.userId = postId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String email) {
        this.title = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }




//    {
//        "userId": 1,
//            "id": 1,
//            "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
//            "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
//    }
}
