package com.uaoanlao.uaoanlibrary.ByRecyclerView;


import java.util.ArrayList;
import java.util.HashMap;

public class UaoanByRecyclerViewAdapter extends me.jingbin.library.adapter.BaseRecyclerAdapter<HashMap<String, Object>> {

    ArrayList<HashMap<String, Object>> datas;
    public UaoanByRecyclerView.OnByRecyclerViewAdapter onByRecyclerViewAdapter= UaoanByRecyclerView.onByRecyclerViewAdapters;
            public UaoanByRecyclerViewAdapter(int lay, ArrayList<HashMap<String, Object>> data) {
                super(lay, data);
                datas=data;
            }

            @Override
            protected void bindView(me.jingbin.library.adapter.BaseByViewHolder<HashMap<String, Object>> ho, final HashMap<String, Object> name, final int position) {
                onByRecyclerViewAdapter.bindView(ho,datas,name,position);
            }
        }
