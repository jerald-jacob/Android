package com.camrininfotech.mvpexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.camrininfotech.mvpexample.model.SignInPresenterImplemantation;
import com.camrininfotech.mvpexample.presenter.SignInPresenter;
import com.camrininfotech.mvpexample.view.SignInView;

public class MainActivity extends AppCompatActivity implements SignInView {

    private SignInPresenter signInPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signInPresenter=new SignInPresenterImplemantation(MainActivity.this);
        signInPresenter.singIn(null,null);
    }

    @Override
    public void showValidationError() {
        Toast.makeText(MainActivity.this,"failed",Toast.LENGTH_LONG).show();
    }

    @Override
    public void signInSuccess() {
        Toast.makeText(MainActivity.this,"sign In Success",Toast.LENGTH_LONG).show();
    }

    @Override
    public void signInError() {
        Toast.makeText(MainActivity.this,"sign In Error",Toast.LENGTH_LONG).show();
    }
}
