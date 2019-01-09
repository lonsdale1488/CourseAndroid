package course.pllug.om.murashev;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import course.pllug.om.murashev.model.Albums;
import course.pllug.om.murashev.model.NetworkService;
import course.pllug.om.murashev.model.Photo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class PhotoAlbum extends Fragment {

    final String LOG_TAG = "PhotoAlbum";

    final String ATTRIBUTE_NAME_TEXT1 = "imeg";
    private final Context mCtx;
    GridView lvSimple;
    View inflaterView;


    @SuppressLint("ValidFragment")
    public PhotoAlbum(Context mCtx) {
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
        inflaterView = inflater.inflate(R.layout.fragment_photo_album, container, false);
        NetworkService.getInstance().getJSONApi().getAllPhoto().enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                List<Photo> list = response.body();
                Log.d(LOG_TAG, "size "+ list.size() + " ");
//

                String[] imeg = new String[list.size()];
                for (int i = 0; i < 20; i++) {
                    imeg[i] = list.get(i).getUrl();
                    Log.d(LOG_TAG, imeg[i]);
                }
                lvSimple = (GridView) inflaterView.findViewById(R.id.lvSimple2);
                    lvSimple.setAdapter(new ImageListAdapter(mCtx, imeg));

            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                Log.d(LOG_TAG, "Error photo");
            }


        });
        return inflaterView;
    }
}