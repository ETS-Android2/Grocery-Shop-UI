package sharma.pankaj.grocerystore.ui.mycart;

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
import sharma.pankaj.grocerystore.ui.mycart.adapter.MyCartControllerAdapter;
import sharma.pankaj.grocerystore.ui.mycart.model.MyCartViewModel;


public class MyCartFragment extends Fragment {

    @BindView(R.id.mycart_recycle_main)
    RecyclerView mycart_recycle_main;

    private MyCartControllerAdapter adapterController;
    private List<MyCartViewModel> list = new ArrayList<>();
    NavController navController;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_my_cart, container, false);
        ButterKnife.bind(this, root);
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        list.add(new MyCartViewModel(MyCartViewModel.ItemType.CART_ITEM));
        list.add(new MyCartViewModel(MyCartViewModel.ItemType.CALCULATION_SECTION));
        adapterController = new MyCartControllerAdapter(getContext(), list, navController);
        mycart_recycle_main.setLayoutManager(new LinearLayoutManager(getContext()));
        mycart_recycle_main.setItemAnimator(new DefaultItemAnimator());
        mycart_recycle_main.setAdapter(adapterController);
        return root;
    }
}