package course.pllug.om.murashev;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import course.pllug.om.murashev.model.Albums;
import course.pllug.om.murashev.model.NetworkService;
import course.pllug.om.murashev.model.Posts;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PostsList extends Fragment {
    final String LOG_TAG = "PostList";
    final String ATTRIBUTE_NAME_POST = "text";
    private final Context mCtx;
    ListView lvSimple;
    View inflaterView;

    public PostsList(Context mCtx) {
        this.mCtx = mCtx;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflaterView = inflater.inflate(R.layout.fragment_posts_list, container, false);

        NetworkService.getInstance().getJSONApi().getAllPosts().enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                List<Posts> list = response.body();

                String[] postList = new String[list.size()];
                for (int i = 0; i < list.size(); i++){
                    postList[i] = list.get(i).getTitle();
                }
                ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(
                        postList.length);
                Map<String, Object> m;
                for (int i = 0; i < postList.length; i++) {
                    m = new HashMap<String, Object>();
                    m.put(ATTRIBUTE_NAME_POST, postList[i]);
                    data.add(m);}

                String[] from = {ATTRIBUTE_NAME_POST};

                int[] to = {R.id.item3Text};
                SimpleAdapter sAdapter = new SimpleAdapter(mCtx, data, R.layout.item3, from, to);
                lvSimple = (ListView) inflaterView.findViewById(R.id.albumList);
                lvSimple.setAdapter(sAdapter);
                Log.d(LOG_TAG, "Create list");

                lvSimple.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                            long id) {
                        PostNumber.number = position + 1;
                        ((Main3Activity) getActivity()).showPostNumber();
                        Log.d(LOG_TAG, "work click");
                    }
                });
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                Log.d(LOG_TAG, "Error list");
            }

        });
       return inflaterView;
    }


}
