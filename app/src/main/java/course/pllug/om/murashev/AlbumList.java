
package course.pllug.om.murashev;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import course.pllug.om.murashev.data.model.Albums;
import course.pllug.om.murashev.data.sours.NetworkService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


@SuppressLint("ValidFragment")
public class AlbumList extends Fragment {
    final String LOG_TAG = "AlbumList";
    final String ATTRIBUTE_NAME_IMEG = "img";
    final String ATTRIBUTE_NAME_TEXT3 = "text3";

    private final Context mCtx;
    GridView lvSimple;
    View inflaterView;

    public AlbumList(Context mCtx) {
        this.mCtx = mCtx;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflaterView = inflater.inflate(R.layout.fragment_album_list, container, false);
        NetworkService.getInstance().getJSONApi().getAllAlbum().enqueue(new Callback<List<Albums>>() {
            @Override
            public void onResponse(Call<List<Albums>> call, Response<List<Albums>> response) {
                List<Albums> list = response.body();
                Log.d(LOG_TAG, list.size() + " ");
                int img = R.drawable.ic_menu_slideshow;

                String[] texts3 = new String[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    texts3[i] = list.get(i).getTitle();
                }

                ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(
                        texts3.length);

                Map<String, Object> m;

                for (int i = 0; i < texts3.length; i++) {
                    m = new HashMap<String, Object>();

                    m.put(ATTRIBUTE_NAME_TEXT3, texts3[i]);
                    m.put(ATTRIBUTE_NAME_IMEG, img);
                    data.add(m);
                }
                String[] from = {ATTRIBUTE_NAME_TEXT3, ATTRIBUTE_NAME_IMEG};

                int[] to = {R.id.tvText1, R.id.tvimeg};

                SimpleAdapter sAdapter = new SimpleAdapter(mCtx, data, R.layout.item1, from, to);

                lvSimple = (GridView) inflaterView.findViewById(R.id.lvSimple);
                lvSimple.setAdapter(sAdapter);
                Log.d(LOG_TAG, texts3.length + "");
                registerForContextMenu(lvSimple);


                lvSimple.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                            long id) {
                        AlbumNumber.number = position + 1;
                        ((MainActivity) getActivity()).showAlbumNumber();
                        Log.d(LOG_TAG, "work click");
                    }
                });

            }

            @Override
            public void onFailure(Call<List<Albums>> call, Throwable t) {
                Log.d(LOG_TAG, "Error list");
            }
        });
        return inflaterView;
    }

}

