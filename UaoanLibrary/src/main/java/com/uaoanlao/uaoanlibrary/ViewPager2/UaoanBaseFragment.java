package com.uaoanlao.uaoanlibrary.ViewPager2;

import androidx.fragment.app.Fragment;

public class UaoanBaseFragment extends Fragment {

     boolean ljz=true;
    @Override
    public void onResume() {
        super.onResume();
        if (ljz) {
            re.onResume();
            ljz = false;
        }
    }



    private OnResume re;
    public void setResume(OnResume resume){
        re=resume;
    }
    public interface OnResume{
        void onResume();
    }
}
