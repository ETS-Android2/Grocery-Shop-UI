package sharma.pankaj.grocerystore.myorders.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sharma.pankaj.grocerystore.R;
import sharma.pankaj.grocerystore.mycart.model.MyCartModel;
import sharma.pankaj.grocerystore.myorders.model.MyOrderViewControllerModel;

public class MyOrderControllerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static final int CURRENT_ORDER_VIEW = 1;
    private static final int OLD_ORDER_VIEW = 2;
    private List<MyOrderViewControllerModel> list;
    private Context context;
    NavController navController;

    public MyOrderControllerAdapter(Context context, List<MyOrderViewControllerModel> list, NavController navController) {
        this.list = list;
        this.context = context;
        this.navController = navController;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == CURRENT_ORDER_VIEW) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.myorder_current_order_status_layout, parent, false);
            return new MyOrderControllerAdapter.ViewHolderCurrentOrder(view);
        } else if (viewType == OLD_ORDER_VIEW) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.myorder_item_outer_layout, parent, false);
            return new MyOrderControllerAdapter.ViewHolderOldOrder(view);
        }else {
            throw new RuntimeException("The type has to be ONE or TWO");
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case CURRENT_ORDER_VIEW:
                initLayoutCurrentOrder((MyOrderControllerAdapter.ViewHolderCurrentOrder) holder, position);
                break;
            case OLD_ORDER_VIEW:
                initLayoutOldOrder((MyOrderControllerAdapter.ViewHolderOldOrder) holder, position);
                break;
            default:
                break;
        }
    }

    private void initLayoutCurrentOrder(MyOrderControllerAdapter.ViewHolderCurrentOrder holder, int pos) {

    }


    private void initLayoutOldOrder(MyOrderControllerAdapter.ViewHolderOldOrder holder, int pos) {
        List<MyCartModel> list = new ArrayList<>();
        list.add(new MyCartModel(false, R.drawable.beverages, "Beverages", "1 pkt", "Rs 30.1", "",""));
        list.add(new MyCartModel(false, R.drawable.beverages, "Beverages", "1 pkt", "Rs 30.1", "",""));
        list.add(new MyCartModel(false, R.drawable.beverages, "Beverages", "1 pkt", "Rs 30.1", "",""));
        MyOrderItemAdapter featureAdapter = new MyOrderItemAdapter(context, list, navController);
        holder.myorder_recycleview.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        holder.myorder_recycleview.setItemAnimator(new DefaultItemAnimator());
        holder.myorder_recycleview.setAdapter(featureAdapter);
    }

    static class ViewHolderCurrentOrder extends RecyclerView.ViewHolder {



        public ViewHolderCurrentOrder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class ViewHolderOldOrder extends RecyclerView.ViewHolder {

        @BindView(R.id.myorder_recycleview)
        public RecyclerView myorder_recycleview;

        public ViewHolderOldOrder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public int getItemViewType(int position) {
        MyOrderViewControllerModel item = list.get(position);
        if (item.getType() == MyOrderViewControllerModel.ItemType.CURRENT_ORDER_VIEW) {
            return CURRENT_ORDER_VIEW;
        } else if (item.getType() == MyOrderViewControllerModel.ItemType.OLD_ORDER_VIEW) {
            return OLD_ORDER_VIEW;
        } else {
            return -1;
        }
    }

    @Override
    public int getItemCount() { return list.size(); }

}