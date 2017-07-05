package com.cms.zup.escolacms;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by ZUP on 05/07/2017.
 */
public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView tvAluno;
    public MyViewHolder(View itemView) {
        super(itemView);
        tvAluno = (TextView) itemView.findViewById(R.id.textView5);
    }
}
