package sharma.pankaj.grocerystore.mycart;

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
import android.widget.TimePicker;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sharma.pankaj.grocerystore.R;
import sharma.pankaj.grocerystore.mycart.adapter.OrderReviewAdapter;
import sharma.pankaj.grocerystore.mycart.model.AddressModel;

public class OrderReviewFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.address)
    RecyclerView address;
    OrderReviewAdapter orderReviewAdapter;
    List<AddressModel> list = new ArrayList<>();
    NavController navController;

    @BindView(R.id.simpleTimePicker)
    TimePicker simpleTimePicker;

    @BindView(R.id.pay_mb)
    MaterialButton pay_mb;

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
        address.setNestedScrollingEnabled(false);
        pay_mb.setOnClickListener(this);

        simpleTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

            }
        });

        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.pay_mb:
//                navController
                break;
        }
    }
}