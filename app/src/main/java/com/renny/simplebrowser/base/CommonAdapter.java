package com.renny.simplebrowser.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Renny on 2018/1/3.
 */

public abstract class CommonAdapter<T> extends RecyclerView.Adapter<ViewHolder> {
    private Context mContext;
    private int mLayoutId;
    private List<T> mDatas;
    protected ItemClickListener mItemClickListener;


    public CommonAdapter(Context context, int layoutId, List<T> datas) {
        mContext = context;
        mLayoutId = layoutId;
        mDatas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        return ViewHolder.get(mContext, parent, mLayoutId);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        convert(holder, position);
    }

    protected T getData(int position) {
        return mDatas.get(position);
    }

    protected abstract void convert(ViewHolder holder, int position);

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public CommonAdapter setItemClickListener(ItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
        return this;
    }

    public interface ItemClickListener {
        void onItemClicked(int position, View view);
    }
}