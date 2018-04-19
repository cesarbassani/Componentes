package com.cesarbassani.myapplication;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.mButtonToast = this.findViewById(R.id.button_toast);
        this.mViewHolder.mButtonSnack = this.findViewById(R.id.button_snack);
        this.mViewHolder.mSpinnerDyanamic = findViewById(R.id.spinner_dynamic);
        this.mViewHolder.mButtonGetSpinner = findViewById(R.id.button_get_spinner);
        this.mViewHolder.mButtonSetSpinner = findViewById(R.id.button_set_spinner);
        this.mViewHolder.mButtonProgress = findViewById(R.id.button_progress);
        this.mViewHolder.mCOnsConstraintLayout = this.findViewById(R.id.constraint_layout);
        this.mViewHolder.mProgressDialog = new ProgressDialog(this);

        //Eventos

        this.setListener();

        this.loadSpinner();

    }

    private void loadSpinner() {
        List<String> lst = Mock.getWeightMock();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, lst);

        this.mViewHolder.mSpinnerDyanamic.setAdapter(adapter);
    }

    private void setListener() {
        this.mViewHolder.mButtonToast.setOnClickListener(this);
        this.mViewHolder.mButtonSnack.setOnClickListener(this);
        this.mViewHolder.mButtonSetSpinner.setOnClickListener(this);
        this.mViewHolder.mButtonGetSpinner.setOnClickListener(this);
        this.mViewHolder.mButtonProgress.setOnClickListener(this);

        this.mViewHolder.mSpinnerDyanamic.setOnItemSelectedListener(this);
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
        } else if (id == R.id.button_get_spinner) {
//            String value = this.mViewHolder.mSpinnerDyanamic.getSelectedItem().toString();
            String value = String.valueOf(this.mViewHolder.mSpinnerDyanamic.getSelectedItemId());
            Toast.makeText(this, value, Toast.LENGTH_SHORT).show();

        } else if (id == R.id.button_set_spinner) {
            this.mViewHolder.mSpinnerDyanamic.setSelection(3);

        } else if (id == R.id.button_progress) {

            this.mViewHolder.mProgressDialog.setTitle("Título");
            this.mViewHolder.mProgressDialog.setMessage("Minha mensagem");
            this.mViewHolder.mProgressDialog.show();

//            this.mViewHolder.mProgressDialog.hide();
//            this.mViewHolder.mProgressDialog.dismiss();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String value = parent.getItemAtPosition(position).toString();
        Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    private static class ViewHolder {
        private Button mButtonToast;
        private Button mButtonSnack;
        private Button mButtonProgress;
        private ProgressDialog mProgressDialog;
        private Button mButtonGetSpinner;
        private Button mButtonSetSpinner;
        private Spinner mSpinnerDyanamic;
        private ConstraintLayout mCOnsConstraintLayout;
    }
}
