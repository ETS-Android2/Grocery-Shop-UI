package sharma.pankaj.grocerystore.ui.product;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sharma.pankaj.grocerystore.R;
import sharma.pankaj.grocerystore.ui.home.adapter.HomeControllerAdapter;
import sharma.pankaj.grocerystore.ui.home.model.ViewModelController;
import sharma.pankaj.grocerystore.ui.product.adapter.ProductCategoryControllerAdapter;
import sharma.pankaj.grocerystore.ui.product.model.ProductCategoryViewModel;

public class ProductCategoryFragment extends Fragment {

    @BindView(R.id.product_category_main_rv)
    RecyclerView product_category_main_rv;
    NavController navController;
    private ProductCategoryControllerAdapter adapterController;
    private List<ProductCategoryViewModel> list = new ArrayList<>();
    @BindView(R.id.search_et)
    EditText search_et;
    public ProductCategoryFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_product_category, container, false);
        ButterKnife.bind(this, root);
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);

        setData("");
        return root;
    }

    private void setData(String key){
        list.add(new ProductCategoryViewModel(ProductCategoryViewModel.ItemType.CATEGORY_ITEM));
        list.add(new ProductCategoryViewModel(ProductCategoryViewModel.ItemType.PRODUCT_ITEM));
        adapterController = new ProductCategoryControllerAdapter(getContext(), list, navController);
        product_category_main_rv.setLayoutManager(new LinearLayoutManager(getContext()));
        product_category_main_rv.setItemAnimator(new DefaultItemAnimator());
        product_category_main_rv.setAdapter(adapterController);
    }
}