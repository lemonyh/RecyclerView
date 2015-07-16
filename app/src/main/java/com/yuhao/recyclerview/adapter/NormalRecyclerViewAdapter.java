package com.yuhao.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yuhao.recyclerview.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * com.yuhao.recyclerview.adapter
 * 创建日期： 2015/7/16.
 * 版权：天合融创
 * 作者：余昊.
 * 版本号：1.0.
 * 修改历史：
 */
public class NormalRecyclerViewAdapter extends RecyclerView.Adapter<NormalRecyclerViewAdapter.NormalTextViewHolder> {


    private  LayoutInflater mLayoutInflater;
    private  Context mContext;
    private String[] mTitles;

    public NormalRecyclerViewAdapter(Context context) {
        mTitles=context.getResources().getStringArray(R.array.titles);
        this.mContext=context;
        mLayoutInflater=LayoutInflater.from(context);
    }
    /**三者的调用顺序的getItemCount onCreateHolder OnBindViewHoler**/
    /**
     * 创建holder对象
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public NormalTextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("NormalRecycler","onCreateViewHolder") ;
        return new NormalTextViewHolder(mLayoutInflater.inflate(R.layout.item_text, parent, false));
    }

    /***
     *  holder的相关绑定操作
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(NormalTextViewHolder holder, int position) {
        Log.d("NormalRecycler","onBindViewHolder") ;
        holder.mTextView.setText(mTitles[position]);

    }

    /**
     * 获取Adapter的长度的绑定
     * @return
     */
    @Override
    public int getItemCount() {
        Log.d("NormalRecycler","getItemCount") ;
        return mTitles == null ? 0 : mTitles.length;
    }


    /**Holder**/
    public  static class NormalTextViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.text_view)
        TextView mTextView;

        public NormalTextViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("NormalTextViewHolder","onClick--> position ="+getPosition()+getOldPosition());
                }
            });
        }
    }


}

