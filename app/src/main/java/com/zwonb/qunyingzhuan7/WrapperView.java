package com.zwonb.qunyingzhuan7;

import android.view.View;

/**
 * 实现ObjectAnimator动画，必须包含set,get方法
 * Created by zyb on 2017/5/10.
 */

public class WrapperView {

    private View mTarget;

    public WrapperView(View mTarget) {
        this.mTarget = mTarget;
    }

    public int getWidth() {
        return mTarget.getLayoutParams().width;
    }

    public void setWidth(int width) {
        mTarget.getLayoutParams().width = width;
        mTarget.requestLayout();
    }
}
