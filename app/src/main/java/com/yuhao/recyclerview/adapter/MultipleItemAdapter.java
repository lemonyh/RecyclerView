package com.yuhao.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
public class MultipleItemAdapter extends RecyclerView.Adapter {
    private  LayoutInflater mLayoutInflater;
    private  Context mContext;
    private String[] mTitles;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE.ITEM_TYPE_IMAGE.ordinal()) {
            return new ImageViewHolder(mLayoutInflater.inflate(R.layout.item_image, parent, false));
        } else {
            return new TextViewHolder(mLayoutInflater.inflate(R.layout.item_text, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TextViewHolder) {
            ((TextViewHolder) holder).mTextView.setText(mTitles[position]);
        } else if (holder instanceof ImageViewHolder) {
            ((ImageViewHolder) holder).mTextView.setText(mTitles[position]);
        }
    }

    @Override
    public int getItemCount() {
        return mTitles == null ? 0 : mTitles.length;
    }

    /**
     * 具体获得哪种类型的view
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        return position % 2 == 0 ? ITEM_TYPE.ITEM_TYPE_IMAGE.ordinal() : ITEM_TYPE.ITEM_TYPE_TEXT.ordinal();
    }


    /**
     * 定义两种类型的视图类型，一种为普通的文本，一种为图片形式的资源
     */
    public static enum ITEM_TYPE {
        ITEM_TYPE_IMAGE,
        ITEM_TYPE_TEXT
    }


    public MultipleItemAdapter(Context context){
        this.mContext=context;
        this.mLayoutInflater=LayoutInflater.from(context);
        mTitles=context.getResources().getStringArray(R.array.titles);

    }


    public static class ImageViewHolder extends  RecyclerView.ViewHolder{

        @Bind(R.id.text_view)
        TextView mTextView;
        @Bind(R.id.image_view)
        ImageView mImageView;

        ImageViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("ImageViewHolder", "onClick--> position = " + getPosition());
                }
            });
        }
    }
    public static class TextViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.text_view)
        TextView mTextView;

        TextViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("TextViewHolder", "onClick--> position = " + getPosition());
                }
            });
        }
    }

}
