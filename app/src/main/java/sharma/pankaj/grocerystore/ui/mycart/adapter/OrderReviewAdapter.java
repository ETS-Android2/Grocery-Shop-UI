package sharma.pankaj.grocerystore.ui.mycart.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sharma.pankaj.grocerystore.R;
import sharma.pankaj.grocerystore.ui.home.model.FreshProductModel;
import sharma.pankaj.grocerystore.ui.mycart.model.AddressModel;

public class OrderReviewAdapter extends RecyclerView.Adapter<OrderReviewAdapter.ViewHolder> {

    Context context;
    List<AddressModel> list;
    LayoutInflater inflater;
    NavController navController;
    int selection = 0;

    public OrderReviewAdapter(Context context, List<AddressModel> list, NavController navController) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
        this.navController = navController;
    }

    @NonNull
    @Override
    public OrderReviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.address_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull OrderReviewAdapter.ViewHolder holder, final int position) {
        if (list.get(position).isLayout()){
            holder.address_layout.setVisibility(View.GONE);
            holder.add_address_layout.setVisibility(View.VISIBLE);
        }else {
            holder.address_layout.setVisibility(View.VISIBLE);
            holder.add_address_layout.setVisibility(View.GONE);
        }
        holder.select_address.setChecked(position==selection);
        holder.address_layout.setOnClickListener(v -> {
                selection = position;
                notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.address_layout)
        RelativeLayout address_layout;

        @BindView(R.id.add_address_layout)
        LinearLayout add_address_layout;

        @BindView(R.id.select_address)
        RadioButton select_address;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}