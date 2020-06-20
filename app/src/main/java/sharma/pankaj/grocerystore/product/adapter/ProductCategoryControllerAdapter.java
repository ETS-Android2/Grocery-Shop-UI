package sharma.pankaj.grocerystore.product.adapter;

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
import sharma.pankaj.grocerystore.product.model.ProductCategoryModel;
import sharma.pankaj.grocerystore.product.model.ProductCategoryViewModel;

public class ProductCategoryControllerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static final int CATEGORY_ITEM = 1;
    private static final int PRODUCT_ITEM = 2;
    private List<ProductCategoryViewModel> list;
    private Context context;
    NavController navController;
    public ProductCategoryControllerAdapter(Context context, List<ProductCategoryViewModel> list,
                                            NavController navController) {
        this.list = list;
        this.context = context;
        this.navController = navController;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == CATEGORY_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_category_outer_layout, parent, false);
            return new ProductCategoryControllerAdapter.ViewHolderCategory(view);
        } else if (viewType == PRODUCT_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_category_item_outer_layout, parent, false);
            return new ProductCategoryControllerAdapter.ViewHolderItem(view);
        }else {
            throw new RuntimeException("The type has to be ONE or TWO");
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case CATEGORY_ITEM:
                initLayoutCategory((ProductCategoryControllerAdapter.ViewHolderCategory) holder, position);
                break;
            case PRODUCT_ITEM:
                initLayoutItem((ProductCategoryControllerAdapter.ViewHolderItem) holder, position);
                break;
            default:
                break;
        }
    }
    private void initLayoutCategory(ProductCategoryControllerAdapter.ViewHolderCategory holder, int pos) {
        List<ProductCategoryModel> list = new ArrayList<>();
        list.add(new ProductCategoryModel("All"));
        list.add(new ProductCategoryModel("All 1"));
        list.add(new ProductCategoryModel("All 2"));
        list.add(new ProductCategoryModel("All 3"));
        list.add(new ProductCategoryModel("All 3"));
        list.add(new ProductCategoryModel("All 5"));
        list.add(new ProductCategoryModel("All 6"));
        list.add(new ProductCategoryModel("All 7"));
        list.add(new ProductCategoryModel("All 8"));
        list.add(new ProductCategoryModel("All 9"));

        ProductCategoryAdapter productCategoryAdapter = new ProductCategoryAdapter(context, list);
        holder.product_category_rv.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.product_category_rv.setItemAnimator(new DefaultItemAnimator());
        holder.product_category_rv.setAdapter(productCategoryAdapter);
    }

    static class ViewHolderCategory extends RecyclerView.ViewHolder {
        @BindView(R.id.product_category_rv)
        public RecyclerView product_category_rv;

        public ViewHolderCategory(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private void initLayoutItem(ProductCategoryControllerAdapter.ViewHolderItem holder, int pos) {
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
        ProductCategoryItemAdapter featureAdapter = new ProductCategoryItemAdapter(context, list);
        holder.product_category_item_recycleview.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        holder.product_category_item_recycleview.setItemAnimator(new DefaultItemAnimator());
        holder.product_category_item_recycleview.setAdapter(featureAdapter);
    }

    static class ViewHolderItem extends RecyclerView.ViewHolder {
        @BindView(R.id.product_category_item_recycleview)
        public RecyclerView product_category_item_recycleview;

        public ViewHolderItem(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    @Override
    public int getItemViewType(int position) {
        ProductCategoryViewModel item = list.get(position);
        if (item.getType() == ProductCategoryViewModel.ItemType.CATEGORY_ITEM) {
            return CATEGORY_ITEM;
        } else if (item.getType() == ProductCategoryViewModel.ItemType.PRODUCT_ITEM) {
            return PRODUCT_ITEM;
        } else {
            return -1;
        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }
}