
package course.pllug.om.murashev;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import course.pllug.om.murashev.model.Albums;
import course.pllug.om.murashev.model.NetworkService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


@SuppressLint("ValidFragment")
public class AlbumList extends Fragment {
    final String LOG_TAG = "AlbumList";
    final String ATTRIBUTE_NAME_TEXT1 = "text1";
    final String ATTRIBUTE_NAME_TEXT2 = "text2";
    final String ATTRIBUTE_NAME_TEXT3 = "text3";
    static final int CM_LOOK_ID = 1;

    private final Context mCtx;
    ListView lvSimple;
    View inflaterView;

    public AlbumList(Context mCtx) {
        this.mCtx = mCtx;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
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

//                String[]   texts1 = new String[list.size()];
//                String[] texts2 = new String[list.size()];
                String[] texts3 = new String[list.size()];
                for (int i = 0; i < list.size(); i++) {

//                    texts1[i] = String.valueOf(list.get(i).getId()) ;
//                    texts2[i] = String.valueOf(list.get(i).getUserId());
                    texts3[i] = list.get(i).getTitle();

                }
                ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(
                        texts3.length);

                Map<String, Object> m;

                for (int i = 0; i < texts3.length; i++) {
                    m = new HashMap<String, Object>();
//                    m.put(ATTRIBUTE_NAME_NAME, texts1[i]);
//                    m.put(ATTRIBUTE_NAME_TEXT2, texts2[i]);
                    m.put(ATTRIBUTE_NAME_TEXT3, texts3[i]);
                    data.add(m);
                }
// массив имен атрибутов, из которых будут читаться данные

                String[] from = {ATTRIBUTE_NAME_TEXT1, ATTRIBUTE_NAME_TEXT2,
                        ATTRIBUTE_NAME_TEXT3};
//            // массив ID View-компонентов, в которые будут вставлять данные
                int[] to = {R.id.tvText1, R.id.tvText2, R.id.tvText3};
// создаем адаптер
                SimpleAdapter sAdapter = new SimpleAdapter(mCtx, data, R.layout.item1, from, to);
                // определяем список и присваиваем ему адаптер
                lvSimple = (ListView) inflaterView.findViewById(R.id.lvSimple);
                lvSimple.setAdapter(sAdapter);
                Log.d(LOG_TAG, texts3.length + "");
                registerForContextMenu(lvSimple);


                lvSimple.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                            long id) {
                        AlbumNumber.number = position + 1;
                        ((Main3Activity) getActivity()).showAlbumNumber();
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

