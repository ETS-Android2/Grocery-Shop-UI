package sharma.pankaj.grocerystore.mycart;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CartEntryModel extends ViewModel {

    private MutableLiveData<Integer> mText;

    public CartEntryModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<Integer> getText() {
        return mText;
    }
}