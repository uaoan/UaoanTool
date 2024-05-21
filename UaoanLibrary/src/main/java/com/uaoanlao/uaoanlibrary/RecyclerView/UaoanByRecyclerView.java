package com.uaoanlao.uaoanlibrary.RecyclerView;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import me.jingbin.library.adapter.BaseByViewHolder;
import me.jingbin.library.decoration.SpacesItemDecoration;
import me.jingbin.library.skeleton.ByRVItemSkeletonScreen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class UaoanByRecyclerView {

    //横向显示
    public UaoanByRecyclerView setLinearLayoutManager(me.jingbin.library.ByRecyclerView byRecyclerView, Context ei){
        byRecyclerView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(ei));
        return this;
    }
    //网格显示
    public UaoanByRecyclerView setGridLayoutManager(me.jingbin.library.ByRecyclerView byRecyclerView, int po, Context ei){
        byRecyclerView.setLayoutManager(new androidx.recyclerview.widget.GridLayoutManager(ei,po, androidx.recyclerview.widget.GridLayoutManager.VERTICAL, false));
        return this;
    }
    //瀑布流显示
    public UaoanByRecyclerView setStaggeredGridLayoutManager(me.jingbin.library.ByRecyclerView byRecyclerView, int po){
        byRecyclerView.setLayoutManager(new androidx.recyclerview.widget.StaggeredGridLayoutManager(po,androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL));
        return this;
    }
    //横向显示
    public UaoanByRecyclerView setHorizontalLinearLayoutManager(me.jingbin.library.ByRecyclerView byRecyclerView, Context ei){
        byRecyclerView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(ei, RecyclerView.HORIZONTAL,false));
        return this;
    }

    private View vwa;
    //添加头部布局
    public UaoanByRecyclerView setTopView(me.jingbin.library.ByRecyclerView byRecyclerView, int lay, Context ei){
        vwa = android.view.LayoutInflater.from(ei).inflate(lay, byRecyclerView, false);
        byRecyclerView.addHeaderView(vwa);
        return this;
    }

    //获取头部布局
    public View getTopView(){
        return vwa;
    }

    public static OnByRecyclerViewAdapter onByRecyclerViewAdapters;
    //设置适配器
    public UaoanByRecyclerView setAdapter(me.jingbin.library.ByRecyclerView byRecyclerView, int lay, ArrayList<HashMap<String, Object>> arrayList, OnByRecyclerViewAdapter onByRecyclerViewAdapter){
        onByRecyclerViewAdapters=onByRecyclerViewAdapter;
        byRecyclerView.setAdapter(new UaoanByRecyclerViewAdapter(lay,arrayList));
        return this;
    }

    public interface OnByRecyclerViewAdapter{
        void bindView(BaseByViewHolder<HashMap<String, Object>> ho,ArrayList<HashMap<String, Object>> data, final HashMap<String, Object> name, final int position);
    }


    public View getView(BaseByViewHolder<HashMap<String, Object>> ho){
        return ho.itemView;
    }

    //创建ArrayList
    public ArrayList<HashMap<String, Object>> newArrayList(){
        ArrayList<HashMap<String, Object>> data=new ArrayList<>();
        return data;
    }
    private View vwb;
    //添加尾部布局
    public UaoanByRecyclerView setBottomView(me.jingbin.library.ByRecyclerView byRecyclerView, int lay, Context ei){
        vwb = android.view.LayoutInflater.from(ei).inflate(lay, byRecyclerView, false);
        byRecyclerView.addFooterView(vwb);
        return this;
    }
    //获取尾部布局
    public View getBottomView(){
        return vwb;
    }

    //刷新
    public UaoanByRecyclerView notifyDataSetChanged(me.jingbin.library.ByRecyclerView byRecyclerView){
        byRecyclerView.getAdapter().notifyDataSetChanged();
        return this;
    }
    //删除
    public UaoanByRecyclerView notifyItemRemoved(me.jingbin.library.ByRecyclerView byRecyclerView, int po){
        byRecyclerView.getAdapter().notifyItemRemoved(po);
        RecyclerView.ItemAnimator animator = new androidx.recyclerview.widget.DefaultItemAnimator();
        byRecyclerView.setItemAnimator(animator);
        return this;
    }

    //保存列表缓存
    public UaoanByRecyclerView setListDownCache(me.jingbin.library.ByRecyclerView byrecyclerview1, int po){
        byrecyclerview1.setItemViewCacheSize(po);
        byrecyclerview1.setDrawingCacheEnabled(true);
        byrecyclerview1.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        return this;
    }

    //定位跳转
    public UaoanByRecyclerView setScrollToPosition(me.jingbin.library.ByRecyclerView byRecyclerView, int po){
        byRecyclerView.scrollToPosition(po);
        return this;
    }

    //倒序显示
    public UaoanByRecyclerView setCollections(ArrayList dx){
        Collections.reverse(dx);
        return this;
    }

    //加载更多
    public UaoanByRecyclerView addAll(ArrayList<HashMap<String,Object>> arrayList, ArrayList<HashMap<String,Object>> arrayList2){
        arrayList.addAll(arrayList2);
        return this;
    }

    //开始刷新
    public UaoanByRecyclerView setTopRefreshing(me.jingbin.library.ByRecyclerView byRecyclerView, boolean an){
        byRecyclerView.setRefreshing(an);
        return this;
    }
    //加载完成
    public UaoanByRecyclerView setBottomMoreComplete(me.jingbin.library.ByRecyclerView byRecyclerView){
        byRecyclerView.loadMoreComplete();
        return this;
    }
    //标记没有更多内容
    public UaoanByRecyclerView setNoVoidBottomLayout(me.jingbin.library.ByRecyclerView byRecyclerView){
        byRecyclerView.loadMoreEnd();
        return this;
    }
    //标记加载更多失败
    public UaoanByRecyclerView setErrorBottomLayout(me.jingbin.library.ByRecyclerView byRecyclerView){
        byRecyclerView.loadMoreFail();
        return this;
    }
    //下拉刷新回调
    public UaoanByRecyclerView setOnTopRefreshListener(me.jingbin.library.ByRecyclerView byRecyclerView, OnRefreshListener refreshListener){
        byRecyclerView.setOnRefreshListener(new me.jingbin.library.ByRecyclerView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // 刷新完成
                refreshListener.onRefresh();
            }
        });
        return this;
    }

    public interface OnRefreshListener{
        void onRefresh();
    }

    //上拉加载回调
    public UaoanByRecyclerView setOnBottomLoadMoreListener(me.jingbin.library.ByRecyclerView byRecyclerView, OnLoadMoreListener onLoadMoreListener){
        byRecyclerView.setOnLoadMoreListener(true,new me.jingbin.library.ByRecyclerView.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                //加载完成
                onLoadMoreListener.onLoadMore();
            }
        });
        return this;
    }
    public UaoanByRecyclerView setOnBottomLoadMoreListener(me.jingbin.library.ByRecyclerView byRecyclerView, OnLoadMoreListener onLoadMoreListener,boolean ty){
        byRecyclerView.setOnLoadMoreListener(ty,new me.jingbin.library.ByRecyclerView.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                //加载完成
                onLoadMoreListener.onLoadMore();
            }
        });
        return this;
    }
    public interface OnLoadMoreListener{
        void onLoadMore();
    }

    private ByRVItemSkeletonScreen skeletonScreen;
    //创建骨架图
    public UaoanByRecyclerView addBySkeleton(me.jingbin.library.ByRecyclerView byRecyclerView, boolean an, int color, int size){
        skeletonScreen = me.jingbin.library.skeleton.BySkeleton
                .bindItem(byRecyclerView)
               .adapter(byRecyclerView.getAdapter())// 必须设置adapter，且在此之前不要设置adapter
               .shimmer(an)// 是否有动画
               .load(me.jingbin.library.R.layout.layout_by_default_item_skeleton)// item骨架图
                .angle(30)// 微光角度
                .frozen(false) // 是否不可滑动
                .color(color)// 动画的颜色
                .duration(1500)// 微光一次显示时间
                .count(size)// item个数
                .show();
        return this;
    }

    public UaoanByRecyclerView daleBySkeleton(){
        skeletonScreen.hide();
        return this;
    }
    public int HORIZONTAL=SpacesItemDecoration.HORIZONTAL;  //横向
    public int VERTICAL=SpacesItemDecoration.VERTICAL;  //竖向

    //设置分割线
    public UaoanByRecyclerView setSpacesItemDecoration(me.jingbin.library.ByRecyclerView byRecyclerView, int 方向, int 间距, int 左间距, int 右间距, int color, Context ei){
        SpacesItemDecoration itemDecoration = new SpacesItemDecoration(ei, 方向)
        .setNoShowDivider(1, 1)
                // 颜色，分割线间距，左边距(单位dp)，右边距(单位dp)
                .setParam(color,间距,左间距,右间距);
       byRecyclerView.addItemDecoration(itemDecoration);
        return this;
    }

    //瀑布流网格分割线
    public UaoanByRecyclerView setSpacesItemDecorationGrid(me.jingbin.library.ByRecyclerView byRecyclerView){
        me.jingbin.library.decoration.GridSpaceItemDecoration itemDecora = new me.jingbin.library.decoration.GridSpaceItemDecoration(10, true)
                .setNoShowSpace(1, 1);
        byRecyclerView.addItemDecoration(itemDecora);
        return this;
    }

}
