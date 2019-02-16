package course.pllug.om.murashev;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import course.pllug.om.murashev.data.model.Comments;
import course.pllug.om.murashev.data.sours.NetworkService;
import course.pllug.om.murashev.data.model.Posts;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PostElementFragment extends Fragment {
    View inflaterView;
    TextView  postTitle, postBody;
    static int number;
    final String LOG_TAG = "PostElementFragment";




    int sizeComents;
    ListView lvSimple;
    final String ATTRIBUTE_NAME_NAME = "name";
    final String ATTRIBUTE_NAME_EMAIL = "email";
    final String ATTRIBUTE_NAME_BODY = "body";




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        inflaterView = inflater.inflate(R.layout.fragment_post_number, container, false);

        NetworkService.getInstance().getJSONApi().getPostsWithID(number).enqueue(new Callback<Posts>() {
            @Override
            public void onResponse(Call<Posts> call, Response<Posts> response) {
                final Posts list = response.body();

                postTitle = (TextView) inflaterView.findViewById(R.id.postTitlenumber);
                postBody = (TextView) inflaterView.findViewById(R.id.postBodynumber);

                postTitle.append( list.getTitle());
                postBody.append(list.getBody());

//                button.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                       CommentsList.numberid = list.getId();
//                        ((MainActivity) getActivity()).showCommensList();
//                    }
//                });
            }
            @Override
            public void onFailure(Call<Posts> call, Throwable t) {
                Log.d(LOG_TAG, "Error listnumber");
            }
        });
        Coment();
        return inflaterView;
    }



public void Coment()
{NetworkService.getInstance().getJSONApi().getAllComments().enqueue(new Callback<List<Comments>>() {

    @Override
    public void onResponse(@NonNull Call<List<Comments>> call, @NonNull Response<List<Comments>> response) {
        List <Comments> list = response.body();

        sizeComents = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPostId() == number) {
                sizeComents = sizeComents + 1;
            }
        }
        String[] name = new String[sizeComents];
        String[] email = new String[sizeComents];
        String[] body = new String[sizeComents];
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPostId() == number) {
                for (int k = 0; k < sizeComents; k++){
                    name[k] = list.get(i).getName();
                    email[k] = list.get(i).getEmail();
                    body[k] = list.get(i).getBody();}
            }
        }
        ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(
                name.length);

        Map<String, Object> m;

        for (int i = 0; i < name.length; i++) {

            m = new HashMap<String, Object>();
            m.put(ATTRIBUTE_NAME_NAME, name[i]);
            m.put(ATTRIBUTE_NAME_EMAIL, email[i]);
            m.put(ATTRIBUTE_NAME_BODY, body[i]);
            data.add(m);
        }
        String[] from = {ATTRIBUTE_NAME_NAME, ATTRIBUTE_NAME_EMAIL,
                ATTRIBUTE_NAME_BODY};
        int[] to = {R.id.nameComments, R.id.emailComments, R.id.bodyComments};
        SimpleAdapter sAdapter = new SimpleAdapter(getActivity(), data, R.layout.item4, from, to);
        lvSimple = (ListView) inflaterView.findViewById(R.id.comentListInPost);
        lvSimple.setAdapter(sAdapter);
        Log.d(LOG_TAG, name.length + "");
    }

    @Override
    public void onFailure(@NonNull Call<List<Comments>> call, @NonNull Throwable t) {
        Log.d(LOG_TAG, "Error listnumber");
    }
});}



}
