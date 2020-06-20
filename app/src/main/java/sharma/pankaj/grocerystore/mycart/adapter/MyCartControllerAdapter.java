package sharma.pankaj.grocerystore.mycart.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sharma.pankaj.grocerystore.R;
import sharma.pankaj.grocerystore.mycart.model.MyCartModel;
import sharma.pankaj.grocerystore.mycart.model.MyCartViewModel;

public class MyCartControllerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static final int CART_ITEM = 1;
    private static final int CALCULATION_SECTION = 2;
    private List<MyCartViewModel> list;
    private Context context;
    NavController navController;

    public MyCartControllerAdapter(Context context, List<MyCartViewModel> list, NavController navController) {
        this.list = list;
        this.context = context;
        this.navController = navController;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == CART_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mycart_item_outer_layout, parent, false);
            return new MyCartControllerAdapter.ViewHolderItem(view);
        } else if (viewType == CALCULATION_SECTION) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mycart_calculation_layout, parent, false);
            return new MyCartControllerAdapter.ViewHolderCalculation(view);
        }else {
            throw new RuntimeException("The type has to be ONE or TWO");
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case CART_ITEM:
                initLayoutItem((MyCartControllerAdapter.ViewHolderItem) holder, position);
                break;
            case CALCULATION_SECTION:
                initLayoutCalculation((MyCartControllerAdapter.ViewHolderCalculation) holder, position);
                break;
            default:
                break;
        }
    }
    private void initLayoutItem(MyCartControllerAdapter.ViewHolderItem holder, int pos) {

        List<MyCartModel> list = new ArrayList<>();
        list.add(new MyCartModel(false, R.drawable.beverages, "Beverages", "1 pkt", "Rs 30.1", "",""));
        list.add(new MyCartModel(false, R.drawable.beverages, "Beverages", "1 pkt", "Rs 30.1", "",""));
        list.add(new MyCartModel(false, R.drawable.beverages, "Beverages", "1 pkt", "Rs 30.1", "",""));
        list.add(new MyCartModel(false, R.drawable.beverages, "Beverages", "1 pkt", "Rs 30.1", "",""));
        list.add(new MyCartModel(false, R.drawable.beverages, "Beverages", "1 pkt", "Rs 30.1", "",""));
        list.add(new MyCartModel(false, R.drawable.beverages, "Beverages", "1 pkt", "Rs 30.1", "",""));
        list.add(new MyCartModel(false, R.drawable.beverages, "Beverages", "1 pkt", "Rs 30.1", "",""));
        list.add(new MyCartModel(false, R.drawable.beverages, "Beverages", "1 pkt", "Rs 30.1", "",""));
        list.add(new MyCartModel(false, R.drawable.beverages, "Beverages", "1 pkt", "Rs 30.1", "",""));
        list.add(new MyCartModel(false, R.drawable.beverages, "Beverages", "1 pkt", "Rs 30.1", "",""));
        list.add(new MyCartModel(false, R.drawable.beverages, "Beverages", "1 pkt", "Rs 30.1", "",""));
        list.add(new MyCartModel(false, R.drawable.beverages, "Beverages", "1 pkt", "Rs 30.1", "",""));
        MyCartItemAdapter featureAdapter = new MyCartItemAdapter(context, list, navController);
        holder.mycart_recycleview.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        holder.mycart_recycleview.setItemAnimator(new DefaultItemAnimator());
        holder.mycart_recycleview.setAdapter(featureAdapter);
    }

    private void initLayoutCalculation(MyCartControllerAdapter.ViewHolderCalculation holder, int pos) {
        holder.order_mb.setOnClickListener(v -> {
            navController.navigate(R.id.action_nav_my_cart_to_nav_order_review);
        });
    }

    static class ViewHolderItem extends RecyclerView.ViewHolder {
        @BindView(R.id.mycart_recycleview)
        public RecyclerView mycart_recycleview;

        public ViewHolderItem(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class ViewHolderCalculation extends RecyclerView.ViewHolder {
        @BindView(R.id.order_mb)
        MaterialButton order_mb;

        public ViewHolderCalculation(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public int getItemViewType(int position) {
        MyCartViewModel item = list.get(position);
        if (item.getType() == MyCartViewModel.ItemType.CART_ITEM) {
            return CART_ITEM;
        } else if (item.getType() == MyCartViewModel.ItemType.CALCULATION_SECTION) {
            return CALCULATION_SECTION;
        } else {
            return -1;
        }
    }

    @Override
    public int getItemCount() {
        return 2;
//        return list == null ? 0 : list.size();
    }
}