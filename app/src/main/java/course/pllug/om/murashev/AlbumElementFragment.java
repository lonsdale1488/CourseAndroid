package course.pllug.om.murashev;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import course.pllug.om.murashev.data.model.Albums;
import course.pllug.om.murashev.data.sours.NetworkService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AlbumElementFragment extends Fragment {

    private View root;
    private TextView albumTitle;
    static int number;
    private final String LOG_TAG = "AlbumElementFragment";
    private Albums list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_abum_number, container, false);
        Data();
        viewAlbumElementFragment();
        return root;
    }

    private void viewAlbumElementFragment() {
        init();
    }

    private void Data() {

        NetworkService.getInstance().getJSONApi().getAlbumWithID(number).enqueue(new Callback<Albums>() {
            @Override
            public void onResponse(Call<Albums> call, Response<Albums> response) {
                list = response.body();
            }

            @Override
            public void onFailure(Call<Albums> call, Throwable t) {
                Log.d(LOG_TAG, t.getMessage());
            }
        });
    }

    private void init() {
        albumTitle = (TextView) root.findViewById(R.id.albumtitle);
        albumTitle.append(list.getTitle());
    }
}