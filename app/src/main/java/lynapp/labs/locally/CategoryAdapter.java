package lynapp.labs.locally;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

interface ItemClickListener {
    void onClick(View view, int position);
}

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> implements RecyclerView.OnItemTouchListener {
    
    
    private List<CategoryInfo> MainList;
    private ImageView categ_image;
    private TextView categ_name;
    private Context context;
    private ItemClickListener clickListener;
    
    CategoryAdapter(Context context,List<CategoryInfo> TempList){
            this.MainList = TempList;
            this.context = context;
    }
    
    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View View = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.menucategory_item, viewGroup, false);

        return new CategoryAdapter.ViewHolder(View);
    }
    
    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder viewHolder, int i) {
        CategoryInfo UploadInfo = MainList.get(i);
        Glide.with(context).load(Uri.parse(UploadInfo.getCateg_url())).into(categ_image);
        categ_name.setText(UploadInfo.getCatg_name());
    }
    
    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
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
         categ_image = itemView.findViewById(R.id.categ_image);
         categ_image.setScaleType(ImageView.ScaleType.FIT_XY);
         categ_name = itemView.findViewById(R.id.categ_name);
         itemView.setOnClickListener(this);
        }
    
        @Override
        public void onClick(View view) {
            if (clickListener != null) clickListener.onClick(view, getAdapterPosition());
        }
    }
}
