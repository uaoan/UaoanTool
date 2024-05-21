package com.uaoanlao.uaoanlibrary.ViewPager2;

import androidx.fragment.app.Fragment;

public class UaoanRepeatFragment extends Fragment {


     boolean ljz=true;

    @Override
    public void onResume() {
        super.onResume();
        if (true) {
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
