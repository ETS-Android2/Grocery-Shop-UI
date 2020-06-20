package sharma.pankaj.grocerystore.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textview.MaterialTextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import sharma.pankaj.grocerystore.R;
import sharma.pankaj.grocerystore.HomeActivity;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.name_et)
    EditText name_et;

    @BindView(R.id.email_et)
    EditText email_et;

    @BindView(R.id.mobile_no_et)
    EditText mobile_no_et;

    @BindView(R.id.password_et)
    EditText password_et;

    @BindView(R.id.tandc_mcb)
    MaterialCheckBox tandc_mcb;

    @BindView(R.id.login_mtv)
    MaterialTextView login_mtv;

    @BindView(R.id.submit_mb)
    MaterialButton submit_mb;

    boolean password_status = false;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        login_mtv.setOnClickListener(this);
        submit_mb.setOnClickListener(this);
        password_et.setOnTouchListener((v, event) -> {
            final int DRAWABLE_RIGHT = 2;
            if (event.getAction() == MotionEvent.ACTION_UP) {
                if (event.getRawX() >= (password_et.getRight() - password_et.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                    if (password_status) {
                        password_et.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_password_gone, 0);
                        password_et.setTransformationMethod(null);
                        password_status = false;
                    } else {
                        password_et.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_password_visible, 0);
                        password_et.setTransformationMethod(new PasswordTransformationMethod());
                        password_status = true;
                    }
                    return true;
                }
            }
            return false;
        });

    }




    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_mtv:
                finish();
                break;
            case R.id.submit_mb:
                setRegister();
                break;
        }
    }

    private void setRegister(){
        if (name_et.getText().toString().length()==0){
            ToastyInfo("Please Enter your Full Name!");
        } else if (!isEmailValid(email_et.getText().toString())){
            ToastyInfo("Please Enter Valid Email Id!");
        } else if (mobile_no_et.getText().toString().length()!=10){
            ToastyInfo("Please Enter 10 Digit Mobile Number!");
        }else if(isValidPassword(password_et.getText().toString())){
            ToastyInfo("Please Enter Valid Password Id!");
        }else {
            Intent register = new Intent(RegisterActivity.this, HomeActivity.class);
            startActivity(register);
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

    public boolean isValidPassword(final String password) {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }

    private void ToastyInfo(String msg){
        Toasty.info(RegisterActivity.this, msg, Toast.LENGTH_SHORT, true).show();
    }

}