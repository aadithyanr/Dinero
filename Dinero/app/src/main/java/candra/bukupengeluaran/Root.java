package com.trinet.dinero;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.trinet.dinero.Modules.Wireframe.Wireframe;
import com.trinet.dinero.Supports.Utils.TextReader;

public class Root extends AppCompatActivity implements TextReader.ReadTextListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);
        new TextReader(this, this);
    }

    @Override
    public void onFinishReadingText() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Wireframe.getInstance().toHomeView(Root.this);
            }
        }, 2000);
    }

    @Override
    public void onErrorReadingText() {
    }
}
