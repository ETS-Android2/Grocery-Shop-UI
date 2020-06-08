package sharma.pankaj.grocerystore.ui.mycart;

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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sharma.pankaj.grocerystore.R;
import sharma.pankaj.grocerystore.ui.mycart.adapter.MyCartControllerAdapter;
import sharma.pankaj.grocerystore.ui.mycart.adapter.OrderReviewAdapter;
import sharma.pankaj.grocerystore.ui.mycart.model.AddressModel;
import sharma.pankaj.grocerystore.ui.mycart.model.MyCartViewModel;

public class OrderReviewFragment extends Fragment {

    @BindView(R.id.address)
    RecyclerView address;
    OrderReviewAdapter orderReviewAdapter;
    List<AddressModel> list = new ArrayList<>();
    NavController navController;

    public OrderReviewFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_order_review, container, false);
        ButterKnife.bind(this, root);
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        list.add(new AddressModel(false, true, ""));
        list.add(new AddressModel(false, false, ""));
        list.add(new AddressModel(true, false, ""));
        orderReviewAdapter = new OrderReviewAdapter(getContext(), list, navController);
        address.setLayoutManager(new LinearLayoutManager(getContext()));
        address.setItemAnimator(new DefaultItemAnimator());
        address.setAdapter(orderReviewAdapter);

        return root;
    }
}