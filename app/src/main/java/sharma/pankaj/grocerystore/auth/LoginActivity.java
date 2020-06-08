package sharma.pankaj.grocerystore.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textview.MaterialTextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindAnim;
import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import sharma.pankaj.grocerystore.R;
import sharma.pankaj.grocerystore.ui.HomeActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.email_et)
    EditText email_et;

    @BindView(R.id.password_et)
    EditText password_et;

    @BindView(R.id.remember_me_mcb)
    MaterialCheckBox remember_me_mcb;

    @BindView(R.id.forgot_password_mtv)
    MaterialTextView forgot_password_mtv;

    @BindView(R.id.register_mtv)
    MaterialTextView register_mtv;

    @BindView(R.id.login_mb)
    MaterialButton login_mb;

    boolean password_status = false;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        forgot_password_mtv.setOnClickListener(this);
        login_mb.setOnClickListener(this);
        register_mtv.setOnClickListener(this);

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
            case R.id.forgot_password_mtv:
                Intent forgot = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(forgot);
                break;
            case R.id.register_mtv:
                Intent register = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(register);
                break;
            case R.id.login_mb:
                setLogin();
                break;
        }
    }

    private void setLogin(){
        if (!isEmailValid(email_et.getText().toString())){
            ToastyInfo("Please Enter Valid Email Id!");
        }else if(!isValidPassword(password_et.getText().toString())){
            ToastyInfo("Please Enter Valid Password Id!");
        }else {
            Intent register = new Intent(LoginActivity.this, HomeActivity.class);
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
        Toasty.info(LoginActivity.this, msg, Toast.LENGTH_SHORT, true).show();
    }

}