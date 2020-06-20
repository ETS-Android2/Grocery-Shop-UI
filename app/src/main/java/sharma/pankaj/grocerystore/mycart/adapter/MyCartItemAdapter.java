package sharma.pankaj.grocerystore.mycart.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.ButterKnife;
import sharma.pankaj.grocerystore.R;
import sharma.pankaj.grocerystore.mycart.model.MyCartModel;

public class MyCartItemAdapter extends RecyclerView.Adapter<MyCartItemAdapter.ViewHolder> {

    Context context;
    List<MyCartModel> list;
    LayoutInflater inflater;
    NavController navController;
    public MyCartItemAdapter(Context context, List<MyCartModel> list, NavController navController) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
        this.navController = navController;
    }

    @NonNull
    @Override
    public MyCartItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.mycart_item_inner_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyCartItemAdapter.ViewHolder holder, int position) {

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
