package sharma.pankaj.grocerystore.ui.mycart;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyCartViewcheckModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MyCartViewcheckModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is mycart fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}