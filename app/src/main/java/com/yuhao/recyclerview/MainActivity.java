package com.yuhao.recyclerview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yuhao.recyclerview.adapter.MultipleItemAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends ActionBarActivity {
    @Bind(R.id.recycler_view)
    RecyclerView   myRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //代表绑定当前Activity的布局
        ButterKnife.bind(this);

        /**
         * 设置布局的样式
         */
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));//设置为线性显示
       // myRecyclerView.setLayoutManager(new GridLayoutManager(this,2));//线性宫格显示 类似于grid view
       // myRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.HORIZONTAL)); //这里用线性宫格显示 类似于瀑布流

        /**
         * 设置布局的适配器  这个适配器所做的工作包括数据的填充，以及view余数据的绑定，相当于MVC中的C祈祷了
         * 控制作用
         */
        myRecyclerView.setAdapter(new MultipleItemAdapter(this));



    }


}
