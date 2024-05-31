package com.uaoanlao.tool;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.uaoanlao.uaoanlibrary.ByRecyclerView.UaoanByRecyclerView;

public class MainActivity extends AppCompatActivity {
    private UaoanByRecyclerView by=new UaoanByRecyclerView();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}