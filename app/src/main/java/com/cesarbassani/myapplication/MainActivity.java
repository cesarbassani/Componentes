package com.cesarbassani.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.mButtonToast = this.findViewById(R.id.button_toast);

        //Eventos

        this.setListener();

    }

    private void setListener() {
        this.mViewHolder.mButtonToast.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.button_toast){
            Toast toast = Toast.makeText(this, R.string.toast_me, Toast.LENGTH_SHORT);

            LayoutInflater inflater = getLayoutInflater();
            View toastLayout = inflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.linear_toast_custom_layout)) ;
            toast.setView(toastLayout);

            TextView textView = toast.getView().findViewById(R.id.text_toast);
            textView.setTextColor(Color.BLUE);

//            View view = toast.getView();
//            view.setBackgroundColor(Color.BLACK);

            toast.show();

        }
    }

    private static class ViewHolder {
        private Button mButtonToast;
    }
}
