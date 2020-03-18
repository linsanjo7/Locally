package lynapp.labs.locally;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.ArrayList;
import java.util.List;

public class CategoryListing extends AppCompatActivity {
    
    TextView categtext;
    RecyclerView recyclerView;
    Bundle bundle;
    WorkListAdapter adapter;
    List<WorkInfo> workInfoList = new ArrayList<>();
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_listing);
        bundle = getIntent().getExtras();
        String categ = bundle.getString("categ");
        categtext = findViewById(R.id.categ_name_top);
        categtext.setText(categ);
        recyclerView = findViewById(R.id.list_recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1,GridLayoutManager.VERTICAL,false));
        workInfoList.add(new WorkInfo("categ", "Alex", "https://cdn2.iconfinder.com/data/icons/avatar-2/512/billy_heat_face-512.png", 4, "I do all sorts of work related to car and maintenance",7358272486L));
        workInfoList.add(new WorkInfo("categ","Kyle","https://cdn2.iconfinder.com/data/icons/avatar-2/512/kan_boy-512.png",5,"I can clean your house and surroundings for you in a jiffy",7357232486L));
        workInfoList.add(new WorkInfo("categ","Rohit","https://cdn0.iconfinder.com/data/icons/user-pictures/100/malecostume-512.png",3,"I can be your handyman for doing all sorts of handy works in and outside your house",7358232476L));
        workInfoList.add(new WorkInfo("categ","Allan","https://cdn2.iconfinder.com/data/icons/avatar-2/512/john_man_face-512.png",3,"I can deliver food or other supplies for you from any nearby store",7358272486L));
        workInfoList.add(new WorkInfo("categ","Micheal","https://cdn1.iconfinder.com/data/icons/user-avatars-2/300/10-512.png",3,"We can provide moving services throughout the city and out of station for you",7358272486L));
        adapter = new WorkListAdapter(this,workInfoList);
        recyclerView.setAdapter(adapter);
    }
}
