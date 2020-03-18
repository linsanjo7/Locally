package lynapp.labs.locally;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

interface ItemClickListener1 {
    void onClick(View view, int position);
}

public class WorkListAdapter extends RecyclerView.Adapter<WorkListAdapter.ViewHolder> implements RecyclerView.OnItemTouchListener {
    
    
    private List<WorkInfo> MainList;
    private TextView name_text;
    private TextView descriptiontext;
    private RatingBar ratingBar;
    private ImageView empImg;
    private Context context;
    private Button hire_button;
    private ItemClickListener1 clickListener1;
    
    WorkListAdapter(Context context,List<WorkInfo> TempList){
        this.MainList = TempList;
        this.context = context;
    }
    
    @NonNull
    @Override
    public WorkListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View View = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listing_item, viewGroup, false);
        
        return new WorkListAdapter.ViewHolder(View);
    }
    
    @Override
    public void onBindViewHolder(@NonNull WorkListAdapter.ViewHolder viewHolder, int i) {
        final WorkInfo UploadInfo = MainList.get(i);
        name_text.setText(UploadInfo.getEmpName());
        descriptiontext.setText(UploadInfo.getDescription());
        ratingBar.setNumStars(5);
        ratingBar.setRating(UploadInfo.getRating());
        ratingBar.setClickable(false);
        ratingBar.setIsIndicator(true);
        Glide.with(context).load(Uri.parse(UploadInfo.getImgURL())).into(empImg);
        hire_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context,HireActivity.class);
                i.putExtra("name",UploadInfo.getEmpName());
                i.putExtra("description",UploadInfo.getDescription());
                i.putExtra("rating",UploadInfo.getRating());
                i.putExtra("imgurl",UploadInfo.getImgURL());
                i.putExtra("number",UploadInfo.getNumber());
                context.startActivity(i);
            }
        });
    }
    
    public void setClickListener(ItemClickListener1 itemClickListener) {
        this.clickListener1 = itemClickListener;
    }
    
    @Override
    public int getItemCount() {
        return MainList.size();
    }
    
    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        return false;
    }
    
    @Override
    public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
    
    }
    
    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean b) {
    
    }
    
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        
        ViewHolder(View itemView){
            super(itemView);
            name_text = itemView.findViewById(R.id.emp_name);
            empImg = itemView.findViewById(R.id.emp_img);
            descriptiontext = itemView.findViewById(R.id.emp_desc);
            ratingBar = itemView.findViewById(R.id.ratingbar);
            hire_button = itemView.findViewById(R.id.hire_button);
        }
        
        @Override
        public void onClick(View view) {
            if (clickListener1 != null) clickListener1.onClick(view, getAdapterPosition());
        }
    }
}
