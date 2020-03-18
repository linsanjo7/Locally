package lynapp.labs.locally;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ImageView restImg;
    MaterialSearchBar searchBar;
    RecyclerView categrecycler;
    List<CategoryInfo> categoryList = new ArrayList<>();
    List<CategoryInfo> tempList = new ArrayList<>();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        categrecycler = findViewById(R.id.categ_recycler);
        searchBar = findViewById(R.id.searchBar);
        searchBar.setSpeechMode(true);
        categrecycler.setLayoutManager(new GridLayoutManager(MainActivity.this,2,GridLayoutManager.VERTICAL,false));
        categrecycler.setHasFixedSize(true);
        categoryList.add(new CategoryInfo("http://alexandramotors.com/wp-content/uploads/2017/11/repair-workshop-icon-png-2904.png","Car work"));
        categoryList.add(new CategoryInfo("https://cdn1.iconfinder.com/data/icons/cleaning-services/66/90-512.png","Cleaning"));
        categoryList.add(new CategoryInfo("https://png.pngtree.com/svg/20160202/courier_397652.png","Delivery"));
        categoryList.add(new CategoryInfo("https://www.handymanproservices.com/newsite/images/HowWorks/handyman_icon_1.jpg","Handyman"));
        categoryList.add(new CategoryInfo("https://www.multi-area.com/wp-content/uploads/2017/07/Moving-icon.png","Moving"));
        categoryList.add(new CategoryInfo("https://image.freepik.com/free-icon/painter-with-roller-and-paint-bucket_318-42097.jpg","Painting"));
        CategoryAdapter adapter = new CategoryAdapter(getApplicationContext(),categoryList);
        categrecycler.setAdapter(adapter);
        adapter.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                startActivity(new Intent(MainActivity.this,CategoryListing.class).putExtra("categ",categoryList.get(position).getCatg_name()));
            }
        });
        searchBar.addTextChangeListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            
            }
        
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                tempList.clear();
                int x = categoryList.size();
                for(int y = 0;y<x;y++){
                    if((categoryList.get(y).catg_name.toLowerCase()).contains(charSequence.toString().toLowerCase())){
                        tempList.add(categoryList.get(y));
                    }
                }
                CategoryAdapter temp = new CategoryAdapter(getApplicationContext(),tempList);
                categrecycler.setAdapter(temp);
            }
        
            @Override
            public void afterTextChanged(Editable editable) {
            
            }
        });
    }
}
