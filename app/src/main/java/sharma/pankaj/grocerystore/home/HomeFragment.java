package sharma.pankaj.grocerystore.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sharma.pankaj.grocerystore.R;
import sharma.pankaj.grocerystore.home.adapter.HomeControllerAdapter;
import sharma.pankaj.grocerystore.home.model.ViewModelController;

public class HomeFragment extends Fragment {

    @BindView(R.id.recycleview_home)
    RecyclerView recycleview_home;
    NavController navController;


    private HomeControllerAdapter adapterController;
    private List<ViewModelController> list = new ArrayList<>();
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, root);
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        list.add(new ViewModelController(ViewModelController.ItemType.BANNER_ITEM));
        list.add(new ViewModelController(ViewModelController.ItemType.CATEGORIES_ITEM));
        list.add(new ViewModelController(ViewModelController.ItemType.FRESH_PRODUCT_ITEM));
        list.add(new ViewModelController(ViewModelController.ItemType.VEGITABLE_ITEM));
        adapterController = new HomeControllerAdapter(getContext(), list, navController);
        recycleview_home.setLayoutManager(new LinearLayoutManager(getContext()));
        recycleview_home.setItemAnimator(new DefaultItemAnimator());
        recycleview_home.setAdapter(adapterController);

        return root;
    }
}