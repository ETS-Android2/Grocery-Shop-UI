package sharma.pankaj.grocerystore.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rbrooks.indefinitepagerindicator.IndefinitePagerIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sharma.pankaj.grocerystore.R;
import sharma.pankaj.grocerystore.home.model.CategoryModel;
import sharma.pankaj.grocerystore.home.model.FreshProductModel;
import sharma.pankaj.grocerystore.home.model.TestModel;
import sharma.pankaj.grocerystore.home.model.ViewModelController;

public class HomeControllerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static final int BANNER_ITEM = 1;
    private static final int CATEGORIES_ITEM = 2;
    private static final int FRESH_PRODUCT_ITEM = 3;
    private static final int VEGITABLE_ITEM = 4;
    private static final int MEAT_ITEM = 5;

    private List<ViewModelController> list;
    private Context context;
    NavController navController;
    public HomeControllerAdapter(Context context, List<ViewModelController> list, NavController navController) {
        this.list = list;
        this.context = context;
        this.navController = navController;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == BANNER_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_banner_outer_layout, parent, false);
            return new ViewHolderBanner(view);
        } else if (viewType == CATEGORIES_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_outer_layout, parent, false);
            return new ViewHolderCategory(view);
        } else if (viewType == FRESH_PRODUCT_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.freshproduct_outer_layout, parent, false);
            return new ViewHolderFreshProduct(view);
        }else if (viewType == VEGITABLE_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vegitable_outer_layout, parent, false);
            return new ViewHolderVegitable(view);
        }else {
            throw new RuntimeException("The type has to be ONE or TWO");
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case BANNER_ITEM:
                initLayoutBanner((ViewHolderBanner) holder, position);
                break;
            case CATEGORIES_ITEM:
                initLayoutCategory((ViewHolderCategory) holder, position);
                break;
            case FRESH_PRODUCT_ITEM:
                initLayoutFreshProduct((ViewHolderFreshProduct) holder, position);
                break;
            case VEGITABLE_ITEM:
                initLayoutVegitable((ViewHolderVegitable) holder, position);
                break;
            default:
                break;
        }
    }
    private void initLayoutBanner(ViewHolderBanner holder, int pos) {

        List<TestModel> list = new ArrayList<>();
        list.add(new TestModel(R.drawable.banner_1));
        list.add(new TestModel(R.drawable.banner_2));
        list.add(new TestModel(R.drawable.banner_3));
        list.add(new TestModel(R.drawable.banner_4));
        list.add(new TestModel(R.drawable.banner_5));
        HomeBannerAdapter featureAdapter = new HomeBannerAdapter(context, list, navController);
        holder.home_banner_recyleview.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.home_banner_recyleview.setItemAnimator(new DefaultItemAnimator());
        holder.home_banner_recyleview.setAdapter(featureAdapter);
        holder.indicator.attachToRecyclerView(holder.home_banner_recyleview);
    }

    private void initLayoutCategory(ViewHolderCategory holder, int pos) {
        List<CategoryModel> list = new ArrayList<>();
        list.add(new CategoryModel(R.drawable.grocery_staples, "Grocery & Staples"));
        list.add(new CategoryModel(R.drawable.vegetable, "Vegetables & Fruits"));
        list.add(new CategoryModel(R.drawable.personal_care, "Personal Care"));
        list.add(new CategoryModel(R.drawable.house_hold, "Household Items"));
        list.add(new CategoryModel(R.drawable.biscute, "Biscuits, Snacks & Chocolates"));
        list.add(new CategoryModel(R.drawable.beverages, "Beverages"));
        list.add(new CategoryModel(R.drawable.breakfast, "Breakfast & Dairy"));
        list.add(new CategoryModel(R.drawable.best_value, "Best Value"));
        list.add(new CategoryModel(R.drawable.noodles, "Noodles, Sauces & Instant Food"));
        list.add(new CategoryModel(R.drawable.baby_care, "Baby Care"));
        list.add(new CategoryModel(R.drawable.pet_care, "Pet Care"));
        list.add(new CategoryModel(R.drawable.lowest_price, "Lowest Price"));
        HomeCategoryAdapter featureAdapter = new HomeCategoryAdapter(context, list, navController);
        holder.home_category_recyleview.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.home_category_recyleview.setItemAnimator(new DefaultItemAnimator());
        holder.home_category_recyleview.setAdapter(featureAdapter);
    }

    private void initLayoutFreshProduct(ViewHolderFreshProduct holder, int pos) {
        List<FreshProductModel> list = new ArrayList<>();
        list.add(new FreshProductModel(false, R.drawable.grocery_staples, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.vegetable, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.personal_care, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.house_hold, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.biscute, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.beverages, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.breakfast, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.best_value, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.noodles, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.baby_care, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.pet_care, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.lowest_price, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.grocery_staples, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.vegetable, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.personal_care, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.house_hold, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.biscute, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.beverages, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.breakfast, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.best_value, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.noodles, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.baby_care, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.pet_care, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.lowest_price, "Grocery", "1 Kg", "Rs 12.09"));
        HomeFreshProductAdapter featureAdapter = new HomeFreshProductAdapter(context, list, navController);
        holder.fresh_product_recycleview.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.fresh_product_recycleview.setItemAnimator(new DefaultItemAnimator());
        holder.fresh_product_recycleview.setAdapter(featureAdapter);
    }

    private void initLayoutVegitable(ViewHolderVegitable holder, int pos) {
        List<FreshProductModel> list = new ArrayList<>();
        list.add(new FreshProductModel(false, R.drawable.grocery_staples, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.vegetable, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.personal_care, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.house_hold, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.biscute, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.beverages, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.breakfast, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.best_value, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.noodles, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.baby_care, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.pet_care, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.lowest_price, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.grocery_staples, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.vegetable, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.personal_care, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.house_hold, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.biscute, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.beverages, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.breakfast, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.best_value, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.noodles, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.baby_care, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.pet_care, "Grocery", "1 Kg", "Rs 12.09"));
        list.add(new FreshProductModel(false, R.drawable.lowest_price, "Grocery", "1 Kg", "Rs 12.09"));

        HomeVegetableAdapter vegetableAdapter = new HomeVegetableAdapter(context, list);
        holder.vegetable_recycleview.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.vegetable_recycleview.setItemAnimator(new DefaultItemAnimator());
        holder.vegetable_recycleview.setAdapter(vegetableAdapter);
    }

    static class ViewHolderBanner extends RecyclerView.ViewHolder {
        @BindView(R.id.home_banner_recyleview)
        public RecyclerView home_banner_recyleview;
        @BindView(R.id.indicator)
        public IndefinitePagerIndicator indicator;
        public ViewHolderBanner(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class ViewHolderCategory extends RecyclerView.ViewHolder {
        @BindView(R.id.home_category_recyleview)
        public RecyclerView home_category_recyleview;
        public ViewHolderCategory(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    static class ViewHolderFreshProduct extends RecyclerView.ViewHolder {

        @BindView(R.id.fresh_product_recycleview)
        public RecyclerView fresh_product_recycleview;

        public ViewHolderFreshProduct(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    static class ViewHolderVegitable extends RecyclerView.ViewHolder {
        @BindView(R.id.vegetable_recycleview)
        public RecyclerView vegetable_recycleview;
        public ViewHolderVegitable(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public int getItemViewType(int position) {

        ViewModelController item = list.get(position);
        if (item.getType() == ViewModelController.ItemType.BANNER_ITEM) {
            return BANNER_ITEM;
        } else if (item.getType() == ViewModelController.ItemType.CATEGORIES_ITEM) {
            return CATEGORIES_ITEM;
        } else if (item.getType() == ViewModelController.ItemType.FRESH_PRODUCT_ITEM) {
            return FRESH_PRODUCT_ITEM;
        } else if (item.getType() == ViewModelController.ItemType.VEGITABLE_ITEM) {
            return VEGITABLE_ITEM;
        } else {
            return -1;
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}

