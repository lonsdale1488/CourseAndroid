package course.pllug.om.murashev.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Photo {

//    long albumI;
//    long id;
//    String title;
//    String url;
//    String thumbnailUrl;




    @SerializedName("albumI")
    @Expose
    private long albumI;



    @SerializedName("id")
    @Expose
    private long id;



    @SerializedName("title")
    @Expose
    private String title;



    @SerializedName("url")
    @Expose
    private String url;



    @SerializedName("thumbnailUrl")
    @Expose
    private String thumbnailUrl;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public long getAlbumI() {
        return albumI;
    }

    public void setAlbumI(long albumI) {
        this.albumI = albumI;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
//    {
//        "albumId": 1,
//            "id": 1,
//            "title": "accusamus beatae ad facilis cum similique qui sunt",
//            "url": "https://via.placeholder.com/600/92c952",
//            "thumbnailUrl": "https://via.placeholder.com/150/92c952"
//    }
}
