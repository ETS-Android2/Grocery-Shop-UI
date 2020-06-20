package sharma.pankaj.grocerystore.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sharma.pankaj.grocerystore.R;
import sharma.pankaj.grocerystore.home.model.FreshProductModel;

public class HomeVegetableAdapter extends RecyclerView.Adapter<HomeVegetableAdapter.ViewHolder> {

    Context context;
    List<FreshProductModel> list;
    LayoutInflater inflater;

    public HomeVegetableAdapter(Context context, List<FreshProductModel> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public HomeVegetableAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.vegitable_inner_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeVegetableAdapter.ViewHolder holder, int position) {
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
//        @BindView(R.id.number_button)
//        ElegantNumberButton numberButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
