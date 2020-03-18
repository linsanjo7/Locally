package lynapp.labs.locally;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class HireActivity extends AppCompatActivity {
    
    
    private TextView name_text;
    private TextView descriptiontext;
    private RatingBar ratingBar;
    private ImageView empImg;
    private Button contact_button;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hire_activity);
        final Bundle bundle = getIntent().getExtras();
        name_text = findViewById(R.id.emp_name1);
        empImg = findViewById(R.id.emp_img1);
        descriptiontext = findViewById(R.id.emp_desc1);
        ratingBar = findViewById(R.id.ratingbar1);
        contact_button = findViewById(R.id.contact_button);
        name_text.setText(bundle.getString("name"));
        descriptiontext.setText(bundle.getString("description"));
        ratingBar.setNumStars(5);
        ratingBar.setRating(bundle.getInt("rating"));
        ratingBar.setClickable(false);
        ratingBar.setIsIndicator(true);
        Glide.with(this).load(Uri.parse(bundle.getString("imgurl"))).into(empImg);
        contact_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call(bundle.getLong("number"));
            }
        });
    }
    
    public void call(long number){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+String.valueOf(number)));
        startActivity(intent);
    }
}
