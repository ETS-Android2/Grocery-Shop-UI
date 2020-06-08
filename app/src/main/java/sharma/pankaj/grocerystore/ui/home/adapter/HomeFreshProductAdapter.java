package sharma.pankaj.grocerystore.ui.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sharma.pankaj.grocerystore.R;
import sharma.pankaj.grocerystore.ui.home.model.CategoryModel;
import sharma.pankaj.grocerystore.ui.home.model.FreshProductModel;

public class HomeFreshProductAdapter extends RecyclerView.Adapter<HomeFreshProductAdapter.ViewHolder> {

    Context context;
    List<FreshProductModel> list;
    LayoutInflater inflater;
    NavController navController;
    public HomeFreshProductAdapter(Context context, List<FreshProductModel> list, NavController navController) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
        this.navController = navController;
    }

    @NonNull
    @Override
    public HomeFreshProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.freshproduct_inner_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeFreshProductAdapter.ViewHolder holder, int position) {
        if (list.get(position).isFavorite()){
            holder.favorite.setImageResource(R.drawable.ic_favorite_24);
        }else {
            holder.favorite.setImageResource(R.drawable.ic_favorite_gray_24);
        }

        holder.icon.setImageResource(list.get(position).getImage());
        holder.productName.setText(list.get(position).getProductName());
        holder.quantity.setText(list.get(position).getProductQuantity());
        holder.price.setText(list.get(position).getProductPrice());
        holder.favorite.setOnClickListener(v -> {
            if (list.get(position).isFavorite()){
                list.get(position).setFavorite(false);
            }else {
                list.get(position).setFavorite(true);
            }
            notifyDataSetChanged();
        });

        holder.card_freshproduct.setOnClickListener(v->{
            navController.navigate(R.id.action_nav_home_to_nav_product_decription);
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.favorite)
        ImageView favorite;
        @BindView(R.id.icon)
        ImageView icon;
        @BindView(R.id.name)
        TextView productName;
        @BindView(R.id.quantity)
        TextView quantity;
        @BindView(R.id.price)
        TextView price;
        @BindView(R.id.card_freshproduct)
        CardView card_freshproduct;
//        @BindView(R.id.number_button)
//        ElegantNumberButton numberButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
