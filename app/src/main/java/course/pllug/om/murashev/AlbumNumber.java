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


public class AlbumNumber extends Fragment {

    View inflaterView;
   TextView albumUserId, albumId, albumTitle;
  static int number;
    final String LOG_TAG = "AlbumNumber";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        inflaterView = inflater.inflate(R.layout.fragment_abum_number, container, false);

        NetworkService.getInstance().getJSONApi().getAlbumWithID(number).enqueue(new Callback<Albums>() {
            @Override
            public void onResponse(Call<Albums> call, Response<Albums> response) {
                Albums list = response.body();
                albumUserId = (TextView) inflaterView.findViewById(R.id.albumuserid);
                albumId = (TextView) inflaterView.findViewById(R.id.albumid);
                albumTitle = (TextView) inflaterView.findViewById(R.id.albumtitle);
                albumUserId.append("User id"+ "\n" + String.valueOf(list.getUserId()));
                albumId.append("id" + "\n" + String.valueOf(list.getId()));
                albumTitle.append("title" + "\n" + list.getTitle());
            }
            @Override
            public void onFailure(Call<Albums> call, Throwable t) {
                Log.d(LOG_TAG, "Error listnumber");
            }
        });
        return  inflaterView;
    }
}