package sharma.pankaj.grocerystore.ui.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.rbrooks.indefinitepagerindicator.IndefinitePagerIndicator;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sharma.pankaj.grocerystore.R;
import sharma.pankaj.grocerystore.ui.home.model.TestModel;

public class HomeBannerAdapter extends RecyclerView.Adapter<HomeBannerAdapter.ViewHolder> {

    Context context;
    List<TestModel> list;
    LayoutInflater inflater;
    NavController navController;
    public HomeBannerAdapter(Context context, List<TestModel> list, NavController navController) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
        this.navController = navController;
    }

    @NonNull
    @Override
    public HomeBannerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.home_banner_inner_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeBannerAdapter.ViewHolder holder, int position) {
        holder.banner.setImageResource(list.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.banner_image)
        ImageView banner;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
