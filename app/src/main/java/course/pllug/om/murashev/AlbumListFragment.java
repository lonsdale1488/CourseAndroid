
package course.pllug.om.murashev;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
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
public class AlbumListFragment extends Fragment {
    private final String LOG_TAG = "AlbumListFragment";
    private final String ATTRIBUTE_NAME_IMEG = "img";
    private final String ATTRIBUTE_NAME_TEXT = "text";
    private GridView lvSimple;
    private View root;
    private List<Albums> list;
    private int img;
    private String[] texts;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_album_list, container, false);
        data();
        init();
        initAdapter();
        initListeners();
        return root;
    }

    private void data() {
        NetworkService.getInstance().getJSONApi().getAllAlbum().enqueue(new Callback<List<Albums>>() {
            @Override
            public void onResponse(Call<List<Albums>> call, Response<List<Albums>> response) {
                list = response.body();
            }

            @Override
            public void onFailure(Call<List<Albums>> call, Throwable t) {
                Log.d(LOG_TAG, t.getMessage());
            }
        });
    }

    private void init() {
        img = R.drawable.ic_menu_slideshow;
        texts = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            texts[i] = list.get(i).getTitle();
        }
        initAdapter();
    }

    private void initAdapter() {
        String[] from = {ATTRIBUTE_NAME_TEXT, ATTRIBUTE_NAME_IMEG};
        int[] to = {R.id.tvText1, R.id.tvimeg};
        ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(texts.length);
        Map<String, Object> m;
        for (int i = 0; i < texts.length; i++) {
            m = new HashMap<String, Object>();
            m.put(ATTRIBUTE_NAME_TEXT, texts[i]);
            m.put(ATTRIBUTE_NAME_IMEG, img);
            data.add(m);
        }
        SimpleAdapter sAdapter = new SimpleAdapter(getActivity(), data, R.layout.item1, from, to);
        lvSimple = (GridView) root.findViewById(R.id.lvSimple);
        lvSimple.setAdapter(sAdapter);
        registerForContextMenu(lvSimple);
    }

    private void initListeners() {
        lvSimple.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                    long id) {
                AlbumElementFragment.number = position + 1;
                ((MainActivity) getActivity()).showAlbumNumber();
            }
        });
    }
}

