package sharma.pankaj.grocerystore.product.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.ButterKnife;
import sharma.pankaj.grocerystore.R;
import sharma.pankaj.grocerystore.mycart.model.MyCartModel;

public class ProductCategoryItemAdapter extends RecyclerView.Adapter<ProductCategoryItemAdapter.ViewHolder> {

    Context context;
    List<MyCartModel> list;
    LayoutInflater inflater;

    public ProductCategoryItemAdapter(Context context, List<MyCartModel> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ProductCategoryItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.product_category_item_inner_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductCategoryItemAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
