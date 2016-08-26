package com.shivarajpatil.mvpnewsapp.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.shivarajpatil.mvpnewsapp.R;
import com.shivarajpatil.mvpnewsapp.listeners.LoginInterface;
import com.shivarajpatil.mvpnewsapp.presenter.LoginPresenter;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class LoginActivity extends AppCompatActivity implements LoginInterface {

    @InjectView(R.id.etEmail)
    EditText mEmail;
    @InjectView(R.id.etPwd)
    EditText mPwd;
    @InjectView(R.id.btnLogin)
    Button mLogin;
    @InjectView(R.id.textView)
    TextView mErrorMessage;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);
        loginPresenter = new LoginPresenter(this);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.doLogin(mEmail.getText().toString(), mPwd.getText().toString());
            }
        });
    }

    @Override
    public void loginSuccess() {
        startActivity(new Intent(this, NewsHeadlinesActivity.class));
        finish();
    }

    @Override
    public void loginFailed(String error) {
        mErrorMessage.setText(error);
    }
}
