package test.bwie.jiyun.com.ins7566.ipandatv.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import test.bwie.jiyun.com.ins7566.ipandatv.R;
import test.bwie.jiyun.com.ins7566.ipandatv.adapter.FirstPagerAdapter;


public class YindaoActivity extends AppCompatActivity implements View.OnClickListener,ViewPager.OnPageChangeListener {
    //定义ViewPager对象
    private ViewPager viewPager;

    //定义ViewPager适配器
    private FirstPagerAdapter vpAdapter;

    //定义一个ArrayList来存放View
    private ArrayList<View> views;

    // 定义各个界面View对象
    private View view1, view2, view3;

    //底部小点的图片
    private ImageView[] points;

    //记录当前选中位置
    private int currentIndex;

    private TextView startBt;

    private SharedPreferences mShared;

    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);
        initView();
        initData();
    }

    /**
     * 初始化组件
     */
    private void initView() {

        mShared=getSharedPreferences("data",MODE_PRIVATE);
        editor = mShared.edit();

        //实例化各个界面的布局对象
        LayoutInflater mLi = LayoutInflater.from(this);
        view1 = mLi.inflate(R.layout.viewpager_one, null);
        view2 = mLi.inflate(R.layout.viewpager_two, null);
        view3 = mLi.inflate(R.layout.viewpager_three, null);

        // 实例化ViewPager
        viewPager = (ViewPager) findViewById(R.id.mViewPager);
        // 实例化ArrayList对象
        views = new ArrayList<View>();
        // 实例化ViewPager适配器
        vpAdapter = new FirstPagerAdapter(views);
        //实例化开始按钮
        startBt = (TextView) view3.findViewById(R.id.mText);
        startBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("uid","2");
                editor.commit();
                Intent intent = new Intent(YindaoActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    /**
     * 初始化数据
     */
    private void initData() {
        // 设置监听
//        viewPager.setOnPageChangeListener(this);


        //将要分页显示的View装入数组中
        views.add(view1);
        views.add(view2);
        views.add(view3);

        // 设置适配器数据
        viewPager.setAdapter(vpAdapter);


        //初始化底部小点
//        initPoint(views.size());



    }

    /**
     * 初始化底部小点
     */
    private void initPoint(int views) {

        points = new ImageView[views];

        //循环取得小点图片
        for (int i = 0; i < views; i++) {
            //得到一个LinearLayout下面的每一个子元素
            //默认都设为灰色
            points[i].setEnabled(true);
            //给每个小点设置监听
            points[i].setOnClickListener(this);
            //设置位置tag，方便取出与当前位置对应
            points[i].setTag(i);
        }

        //设置当面默认的位置
        currentIndex = 0;
        //设置为白色，即选中状态
        points[currentIndex].setEnabled(false);
    }

    /**
     * 当滑动状态改变时调用
     */
    @Override
    public void onPageScrollStateChanged(int arg0) {

    }

    /**
     * 当当前页面被滑动时调用
     */

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {

    }



    /**
     * 当新的页面被选中时调用
     */

    @Override
    public void onPageSelected(int position) {
        //设置底部小点选中状态
//        setCurDot(position);
    }

    /**
     * 通过点击事件来切换当前的页面
     */
    @Override
    public void onClick(View v) {
        int position = (Integer) v.getTag();
        setCurView(position);
//        setCurDot(position);
    }

    /**
     * 设置当前页面的位置
     */
    private void setCurView(int position) {
        if (position < 0 || position >= 4) {
            return;
        }
        viewPager.setCurrentItem(position);
    }

    /**
     * 设置当前的小点的位置
     */
//    private void setCurDot(int positon) {
//        if (positon < 0 || positon > 3 || currentIndex == positon) {
//            return;
//        }
//        points[positon].setEnabled(false);
//        points[currentIndex].setEnabled(true);
//
//        currentIndex = positon;
//    }
}
