package course.pllug.om.murashev;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import course.pllug.om.murashev.R;
import course.pllug.om.murashev.model.Albums;
import course.pllug.om.murashev.model.NetworkService;
import course.pllug.om.murashev.model.Posts;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PostNumber extends Fragment {
    View inflaterView;
    TextView postUserId, postId, postTitle, postBody;
    Button button;
    static int number;
    final String LOG_TAG = "PostNumber";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflaterView = inflater.inflate(R.layout.fragment_post_number, container, false);

        NetworkService.getInstance().getJSONApi().getPostsWithID(number).enqueue(new Callback<Posts>() {
            @Override
            public void onResponse(Call<Posts> call, Response<Posts> response) {
                final Posts list = response.body();
                postUserId = (TextView) inflaterView.findViewById(R.id.postuserid);
                postId = (TextView) inflaterView.findViewById(R.id.postid);
                postTitle = (TextView) inflaterView.findViewById(R.id.posttitle);
                postBody = (TextView) inflaterView.findViewById(R.id.postbody);
                button = (Button) inflaterView.findViewById(R.id.comment);

                postUserId.append("User id"+ "\n" + String.valueOf(list.getUserId()));
                postId.append("id" + "\n" + String.valueOf(list.getId()));
                postTitle.append("title" + "\n" + list.getTitle());
                postBody.append("body" + "\n" + list.getBody());

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       CommentsList.numberid = list.getId();
                        ((Main3Activity) getActivity()).showCommensList();
                    }
                });
            }
            @Override
            public void onFailure(Call<Posts> call, Throwable t) {
                Log.d(LOG_TAG, "Error listnumber");
            }
        });

        return inflaterView;
    }




}
