package course.pllug.om.murashev.data.sours;

import java.util.List;

import course.pllug.om.murashev.data.model.Albums;
import course.pllug.om.murashev.data.model.Comments;
import course.pllug.om.murashev.data.model.Photo;
import course.pllug.om.murashev.data.model.Posts;
import course.pllug.om.murashev.data.model.users.Users;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AlbumRepository {
    @GET("albums/{id}")
    public Call<Albums> getAlbumWithID(@Path("id") int id);

    @GET("albums")
    public Call<List<Albums>> getAllAlbum();

    @GET("photos/{id}")
    public Call<Photo> getPhotoWithID(@Path("id") int id);

    @GET("photos")
    public Call<List<Photo>> getAllPhoto();

    @GET("users/{id}")
    public Call<Users> getUserWithID(@Path("id") int id);

    @GET("users")
    public Call<List<Users>> getAllUsers();

    @GET("posts/{id}")
    public Call<Posts> getPostsWithID(@Path("id") int id);

    @GET("posts")
    public Call<List<Posts>> getAllPosts();

    @GET("comments/{postId}")
    public Call<Comments> getCommentsWithID(@Path("postId") int id);

    @GET("comments")
    public Call<List<Comments>> getAllComments();

}