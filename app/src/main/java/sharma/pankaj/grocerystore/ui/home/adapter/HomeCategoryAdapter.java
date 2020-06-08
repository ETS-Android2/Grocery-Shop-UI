package sharma.pankaj.grocerystore.ui.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sharma.pankaj.grocerystore.R;
import sharma.pankaj.grocerystore.ui.home.model.CategoryModel;
import sharma.pankaj.grocerystore.ui.home.model.TestModel;

public class HomeCategoryAdapter extends RecyclerView.Adapter<HomeCategoryAdapter.ViewHolder> {

    Context context;
    List<CategoryModel> list;
    LayoutInflater inflater;
    NavController navController;
    public HomeCategoryAdapter(Context context, List<CategoryModel> list, NavController navController) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
        this.navController = navController;
    }

    @NonNull
    @Override
    public HomeCategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.category_inner_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeCategoryAdapter.ViewHolder holder, int position) {
        holder.title.setText(list.get(position).getCategoryName());
        holder.icon.setImageResource(list.get(position).getIcon());
        holder.card_category.setOnClickListener(v ->{
            navController.navigate(R.id.action_nav_home_to_nav_product_category);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.icon)
        ImageView icon;
        @BindView(R.id.card_category)
        CardView card_category;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
