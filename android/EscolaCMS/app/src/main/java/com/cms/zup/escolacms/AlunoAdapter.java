package com.cms.zup.escolacms;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by ZUP on 05/07/2017.
 */

public class AlunoAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private List<Aluno> mylist;
    private Context context;
    private LayoutInflater mlayoutinfalter;
    public AlunoAdapter(List<Aluno> l, Context c) {
        mylist = l;
        context = c;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mlayoutinfalter.inflate(R.layout.card_aluno, parent,false);
        MyViewHolder mvh = new MyViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvAluno.setText(mylist.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public void addListItem(Aluno f, int position) {
        if (mylist.contains(f) == false) {
            mylist.add(f);
        }
        notifyItemInserted(position);
    }
}
