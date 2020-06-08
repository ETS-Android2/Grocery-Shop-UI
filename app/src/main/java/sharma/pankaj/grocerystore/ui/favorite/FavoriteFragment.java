package sharma.pankaj.grocerystore.ui.favorite;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sharma.pankaj.grocerystore.R;
import sharma.pankaj.grocerystore.ui.favorite.adapter.FavoriteAdapter;
import sharma.pankaj.grocerystore.ui.home.model.FreshProductModel;

public class FavoriteFragment extends Fragment {

    @BindView(R.id.recycleview_favorite)
    RecyclerView recycleview_favorite;

    public FavoriteFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_favorite, container, false);
        ButterKnife.bind(this, root);
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

        FavoriteAdapter favoriteAdapter = new FavoriteAdapter(requireContext(), list);
        recycleview_favorite.setLayoutManager(new GridLayoutManager(requireContext(),2));
        recycleview_favorite.setItemAnimator(new DefaultItemAnimator());
        recycleview_favorite.setAdapter(favoriteAdapter);
        return root;
    }
}