package com.uaoanlao.uaoanlibrary.ViewPager2;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.uaoanlao.uaoanlibrary.adapter.ViewPager2Adapter;

import java.util.ArrayList;

public class UaoanViewPager2 {

    //设置Tabalayout标题
    public UaoanViewPager2 setTabLayoutTitle(ViewPager2 viewPager2, TabLayout tabLayou, OnTabLayoutMediator onTabLayoutMediator){
        com.google.android.material.tabs.TabLayoutMediator tabLayoutMediator = new com.google.android.material.tabs.TabLayoutMediator(tabLayou, viewPager2, new com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@androidx.annotation.NonNull TabLayout.Tab tab, int position) {
//                tab.setText(nr);
                onTabLayoutMediator.setText(tab,position);
            }
        });
        tabLayoutMediator.attach();
        return this;
    }


    public interface OnTabLayoutMediator{
        void setText(TabLayout.Tab tab, int position);
    }

    //获取当前页面
    public static int getCurrentItem(ViewPager2 viewPager2){
        return viewPager2.getCurrentItem();
    }

    //获取页面总数
    public static int getSizeCount(ViewPager2 viewPager2){
        return viewPager2.getAdapter().getItemCount();
    }
    //获取当前页面
    public int getCurrentItems(ViewPager2 viewPager2){
        return viewPager2.getCurrentItem();
    }

    public int VERTICAL= ViewPager2.ORIENTATION_VERTICAL;  //竖向
    public int HORIZONTAL=ViewPager2.ORIENTATION_HORIZONTAL;  //横向

    //设置显示方向
    public UaoanViewPager2 setOrientation(ViewPager2 viewPager2, int po){
            viewPager2.setOrientation(po);
            return this;
    }

    //切换事件
    public UaoanViewPager2 setonSlidingevent(ViewPager2 viewPager2, OnPageChangeCallback pageChangeCallback){
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int po, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(po, positionOffset, positionOffsetPixels);
                //当滚动当前页面时，将调用此方法
                pageChangeCallback.onPageScrolled(po,positionOffset,positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int po) {
                super.onPageSelected(po);
                //当选择新页面时，将调用此方法。动画不是一定完成。
                pageChangeCallback.onPageSelected(po);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
                //当滚动状态改变时调用。
                pageChangeCallback.onPageScrollStateChanged(state);
            }
        });
        return this;
    }


    //禁止滑动
     public UaoanViewPager2 setNoScroll(ViewPager2 viewPager2){
         viewPager2.setUserInputEnabled(false);
         return this;
     }

     //切换页面
    public UaoanViewPager2 setCurrentItem(ViewPager2 viewPager2, int po){
        viewPager2.setCurrentItem(po);
        return this;
    }

    //切换页面无动画
    public UaoanViewPager2 setCurrentItems(ViewPager2 viewPager2, int po){
        viewPager2.setCurrentItem(po,false);
        return this;
    }

    //设置缓存
    public UaoanViewPager2 setOffscreenPageLimit(ViewPager2 viewPager2, int po){
        viewPager2.setOffscreenPageLimit(po);
        return this;
    }
    //关闭预加载
    public UaoanViewPager2 outLoading(ViewPager2 viewPager2){
        ((androidx.recyclerview.widget.RecyclerView) viewPager2.getChildAt(0)).getLayoutManager().setItemPrefetchEnabled(false);
        return this;
    }
    //设置间距
    public UaoanViewPager2 setMargin(ViewPager2 viewPager2, int po){
        viewPager2.setPageTransformer(new androidx.viewpager2.widget.MarginPageTransformer(po));
        return this;
    }



    private ArrayList<Fragment> frags;
    //创建Fragment
    public UaoanViewPager2 newFragment(){
         frags=new ArrayList<>();
         return this;
    }

    //添加Fragment
    public UaoanViewPager2 addFragment(Fragment fragment){
        frags.add(fragment);
        return this;
    }

    //设置适配器
    public UaoanViewPager2 setAdapter(ViewPager2 viewPager2, FragmentActivity ei){
        viewPager2.setAdapter(new ViewPager2Adapter(ei, frags));
        return this;
    }


    public interface OnPageChangeCallback{
        //当滚动当前页面时
        void onPageScrolled(int po, float positionOffset, int positionOffsetPixels);
       //当选择新页面时
        void onPageSelected(int po);
        //当滚动状态改变时调用
        void onPageScrollStateChanged(int state);
    }


}
