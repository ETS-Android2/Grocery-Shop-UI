package sharma.pankaj.grocerystore.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import sharma.pankaj.grocerystore.R;

public class ForgotPasswordActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.email_et)
    EditText email_et;

    @BindView(R.id.submit_mb)
    MaterialButton submit_mb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        ButterKnife.bind(this);
        submit_mb.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.submit_mb:
                changePassword();
                break;
        }
    }

    private void changePassword(){
        if (!isEmailValid(email_et.getText().toString())){
            ToastyInfo("Please Enter Valid Email Id!");
        }else {
            finish();
            ToastyInfo("Password Change Link sent to Your Register email id please check!");
        }
    }

    public boolean isEmailValid(String email) {
        boolean isValid = false;
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }
    private void ToastyInfo(String msg){
        Toasty.info(ForgotPasswordActivity.this, msg, Toast.LENGTH_LONG, true).show();
    }
}