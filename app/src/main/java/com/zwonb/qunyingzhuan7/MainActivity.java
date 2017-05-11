package com.zwonb.qunyingzhuan7;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.LayoutAnimationController;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private boolean click;
    private TextView textValue;
    private LinearLayout layout;

    private int[] mRes = {R.id.imageView_a, R.id.imageView_b, R.id.imageView_c,
            R.id.imageView_d, R.id.imageView_e};
    private List<ImageView> mImageViews = new ArrayList<>();
    private boolean mFlag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        for (int mRe : mRes) {
            ImageView imageView = (ImageView) findViewById(mRe);
            imageView.setOnClickListener(this);
            mImageViews.add(imageView);
        }
    }

    private void initView() {
        textValue = (TextView) findViewById(R.id.textview1);
        layout = (LinearLayout) findViewById(R.id.linear_layout);

        //设置viewGroup子视图动画
        setViewGroupAnim();

        //矢量动画
        setVectorAnim();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageView_a:
                if (mFlag) {
                    startAnim();
                } else {
                    closeAnim();
                }
                break;
            default:
                Toast.makeText(this, "" + v.getId(),
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void closeAnim() {
        ObjectAnimator animator0 = ObjectAnimator.ofFloat(mImageViews.get(0),
                "alpha", 0.5F, 1F);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(mImageViews.get(1),
                "translationY", 200F, 0);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mImageViews.get(2),
                "translationX", 200F, 0);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(mImageViews.get(3),
                "translationY", -200F, 0);
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(mImageViews.get(4),
                "translationX", -200F, 0);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(500);
        set.setInterpolator(new BounceInterpolator());
        set.playTogether(animator0, animator1, animator2, animator3, animator4);
        set.start();
        mFlag = true;
    }

    private void startAnim() {
        ObjectAnimator animator0 = ObjectAnimator.ofFloat(
                mImageViews.get(0),
                "alpha",
                1F,
                0.5F);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(
                mImageViews.get(1),
                "translationY",
                200F);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(
                mImageViews.get(2),
                "translationX",
                200F);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(
                mImageViews.get(3),
                "translationY",
                -200F);
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(
                mImageViews.get(4),
                "translationX",
                -200F);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(500);
        set.setInterpolator(new BounceInterpolator());
        set.playTogether(
                animator0,
                animator1,
                animator2,
                animator3,
                animator4);
        set.start();
        mFlag = false;
    }

    //设置viewGroup子视图动画
    private void setViewGroupAnim() {
        TranslateAnimation animation = new TranslateAnimation(-200,0,0,0);
        animation.setDuration(200);
        LayoutAnimationController controller = new LayoutAnimationController(animation,0.6F);
        controller.setOrder(LayoutAnimationController.ORDER_NORMAL);
        layout.setLayoutAnimation(controller);
//        ListView listView = new ListView(this);
//        listView.setLayoutAnimation(controller);
    }

    //矢量动画
    private void setVectorAnim() {

        final ImageView trick = (ImageView) findViewById(R.id.trick_img);
        trick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable drawable = trick.getDrawable();
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
            }
        });

        final ImageView sun = (ImageView) findViewById(R.id.sun_img);
        sun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable drawable = sun.getDrawable();
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
            }
        });

        final ImageView search = (ImageView) findViewById(R.id.search_img);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable drawable = search.getDrawable();
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
            }
        });
    }

    public void btnAlpha(View view) {
        AlphaAnimation aa = new AlphaAnimation(0, 1);
        aa.setDuration(1000);
        view.startAnimation(aa);
//        WrapperView view1 = new WrapperView(view);
//        ObjectAnimator.ofInt(view1, "width", 500).setDuration(5000).start();
    }

    public void btnRotate(View view) {
        RotateAnimation ra = new RotateAnimation(0, 360, 100, 100);
        ra.setDuration(1000);
        view.startAnimation(ra);
    }

    public void btnRotateSelf(View view) {
        RotateAnimation ra = new RotateAnimation(0, 360,
                RotateAnimation.RELATIVE_TO_SELF, 0.5F,
                RotateAnimation.RELATIVE_TO_SELF, 0.5F);
        ra.setDuration(1000);
        view.startAnimation(ra);
    }

    public void btnTranslate(View view) {
        TranslateAnimation ta = new TranslateAnimation(0, 200, 0, 300);
        ta.setDuration(1000);
        view.startAnimation(ta);
    }

    public void btnScale(View view) {
        ScaleAnimation sa = new ScaleAnimation(0, 2, 0, 2);
        sa.setDuration(1000);
        view.startAnimation(sa);
    }

    public void btnScaleSelf(View view) {
        ScaleAnimation sa = new ScaleAnimation(0, 1, 0, 1,
                Animation.RELATIVE_TO_SELF, 0.5F,
                Animation.RELATIVE_TO_SELF, 0.5F);
        sa.setDuration(1000);
        view.startAnimation(sa);
    }

    public void btnSet(View view) {
        AnimationSet as = new AnimationSet(true);
        as.setDuration(1000);

        AlphaAnimation aa = new AlphaAnimation(0, 1);
        aa.setDuration(1000);
        as.addAnimation(aa);

        TranslateAnimation ta = new TranslateAnimation(0, 100, 0, 200);
        ta.setDuration(1000);
        as.addAnimation(ta);

        view.startAnimation(as);


//        if (!click) {
//            PropertyValuesHolder pvh1 = PropertyValuesHolder.ofFloat("translationX", 300f);
//            PropertyValuesHolder pvh2 = PropertyValuesHolder.ofFloat("scaleX", 1f, 0, 1f);
//            PropertyValuesHolder pvh3 = PropertyValuesHolder.ofFloat("scaleY", 1f, 0, 1f);
//            ObjectAnimator.ofPropertyValuesHolder(view, pvh1, pvh2, pvh3).setDuration(1000).start();
//        }else {
//            PropertyValuesHolder pvh1 = PropertyValuesHolder.ofFloat("translationX", 0);
//            PropertyValuesHolder pvh2 = PropertyValuesHolder.ofFloat("scaleX", 1f, 0, 1f);
//            PropertyValuesHolder pvh3 = PropertyValuesHolder.ofFloat("scaleY", 1f, 0, 1f);
//            ObjectAnimator.ofPropertyValuesHolder(view, pvh1, pvh2, pvh3).setDuration(1000).start();
//        }
//        click = !click;
    }

    public void textValue(View view) {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0.01f,99.455f);
        valueAnimator.setDuration(800).start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float animatedValue = (float) animation.getAnimatedValue();
                BigDecimal bigDecimal = new BigDecimal(animatedValue);
                BigDecimal bigDecimal1 = bigDecimal.setScale(2, BigDecimal.ROUND_DOWN);
                textValue.setText(bigDecimal1+"");
            }
        });
    }

    public void imgClose(View view) {
        CustomAnim customAnim = new CustomAnim();
        view.startAnimation(customAnim);
    }

    public void btnAnim(View view) {
        CustomAnim1 customAnim = new CustomAnim1();
        customAnim.setRotateY(30);
        view.startAnimation(customAnim);
    }
}
