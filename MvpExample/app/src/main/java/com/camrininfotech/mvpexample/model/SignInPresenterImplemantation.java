package com.camrininfotech.mvpexample.model;

import android.text.TextUtils;

import com.camrininfotech.mvpexample.presenter.SignInPresenter;
import com.camrininfotech.mvpexample.view.SignInView;

public class SignInPresenterImplemantation implements SignInPresenter {

    private SignInView signinView;
    public SignInPresenterImplemantation(SignInView signinView) {
        this.signinView = signinView;
    }

    @Override
    public void singIn(String username, String password) {
        if(TextUtils.isEmpty(username)&&TextUtils.isEmpty(password)){
            signinView.showValidationError();
        }else {
            if(username.equalsIgnoreCase("jerald")&&password.equalsIgnoreCase("123")){
                signinView.signInSuccess();
            }else {
                signinView.signInError();
            }
        }
    }
}
