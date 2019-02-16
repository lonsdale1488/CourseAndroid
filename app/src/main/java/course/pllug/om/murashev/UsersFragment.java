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

import course.pllug.om.murashev.data.model.users.Users;
import course.pllug.om.murashev.data.sours.NetworkService;
import retrofit2.Call;
import retrofit2.Response;


public class UsersFragment extends Fragment {
  final   String LOG_TAG = "UserList";
  final   String ATRIBUTE_USER_IMG = "imeg";
  final   String ATRIBUTE_USER_TXT = "text";
  final   String ATRIBUTE_USER_TXT1 = "text1";
  final   String ATRIBUTE_USER_TXT2 = "text2";

  View root;
  ListView Foruserlist;
  private final Context mCtx;
  final int DIALOG_EXIT = 1;




    public UsersFragment(Context mCtx) {
        this.mCtx = mCtx;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_users, container, false);

        NetworkService.getInstance().getJSONApi().getAllUsers().enqueue(new retrofit2.Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
                final List<Users> users = response.body();
                String[] postListName = new String[users.size()];
                String[] postListUsername = new String[users.size()];
                String[] postListEmail = new String[users.size()];
                int img = R.drawable.ic_menu_camera;
                for (int i = 0; i < users.size(); i++) {
                    postListName[i] = users.get(i).getName();
                    postListUsername[i] = users.get(i).getUsername();
                    postListEmail[i] = users.get(i).getEmail();
                }
                ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(
                        postListName.length);
                Map<String, Object> m;
                for (int i = 0; i < postListName.length; i++) {
                    m = new HashMap<String, Object>();
                    m.put(ATRIBUTE_USER_IMG, img);
                    m.put(ATRIBUTE_USER_TXT, postListName[i]);
                    m.put(ATRIBUTE_USER_TXT1, postListUsername[i]);
                    m.put(ATRIBUTE_USER_TXT2, postListEmail[i]);
                    data.add(m);
                }
                String[] from = {ATRIBUTE_USER_IMG,ATRIBUTE_USER_TXT,ATRIBUTE_USER_TXT1,ATRIBUTE_USER_TXT2};

                int[] to = {R.id.avatrUser, R.id.textUsername, R.id.textNichname,R.id.textemail};
                SimpleAdapter sAdapter = new SimpleAdapter(mCtx, data, R.layout.item5, from, to);
                Foruserlist = (ListView) root.findViewById(R.id.userList);
                Foruserlist.setAdapter(sAdapter);
                Log.d(LOG_TAG, "Create list");

                Foruserlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                            long id) {
                        PostElementFragment.number = position ;
                         ((MainActivity) getActivity()).showDialog(users.get(position ).getName(),
                                 users.get(position).getCompany().getName(),users.get(position ).getPhone(),
                               users.get(position ).getWebsite());
//                        ((MainActivity) getActivity()).showDialog();
                        Log.d(LOG_TAG, "work click");
                    }
                });
            }
            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {
                Log.d(LOG_TAG, t.getMessage());
            }
        });

        return root;
    }





}