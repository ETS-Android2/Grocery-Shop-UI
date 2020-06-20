package sharma.pankaj.grocerystore.myorders;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import sharma.pankaj.grocerystore.R;

public class OrderDetailsFragment extends Fragment {

    public OrderDetailsFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_order_details, container, false);
        ButterKnife.bind(this, root);

        return root;
    }
}