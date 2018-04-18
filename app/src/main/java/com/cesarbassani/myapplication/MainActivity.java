package com.cesarbassani.myapplication;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
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
        this.mViewHolder.mButtonSnack = this.findViewById(R.id.button_snack);
        this.mViewHolder.mCOnsConstraintLayout = this.findViewById(R.id.constraint_layout);

        //Eventos

        this.setListener();

    }

    private void setListener() {
        this.mViewHolder.mButtonToast.setOnClickListener(this);
        this.mViewHolder.mButtonSnack.setOnClickListener(this);
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

        } else if (id == R.id.button_snack) {
            Snackbar snackbar = Snackbar.make(this.mViewHolder.mCOnsConstraintLayout, R.string.snack_me, Snackbar.LENGTH_SHORT);

            snackbar.setAction(getString(R.string.desfazer), new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(mViewHolder.mCOnsConstraintLayout, R.string.acao_desfeita, Snackbar.LENGTH_LONG).show();
                }
            });

            TextView textView = findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(Color.YELLOW);

            getResources().getColor(R.color.colorPrimary);
            ContextCompat.getColor(this, R.color.colorPrimary);

            View view = snackbar.getView();
            view.setBackgroundColor(Color.DKGRAY);

            snackbar.show();
        }
    }

    private static class ViewHolder {
        private Button mButtonToast;
        private Button mButtonSnack;
        private ConstraintLayout mCOnsConstraintLayout;
    }
}
