package com.cms.zup.escolacms;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by ZUP on 05/07/2017.
 */

public class AlunoFragment extends Fragment {
        private RecyclerView myRecyclerView;
        private List<Aluno> myList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alunos,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        myRecyclerView = (RecyclerView) getActivity().findViewById(R.id.recyclerView);
        myRecyclerView.setHasFixedSize(true);
        myRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager llm = (LinearLayoutManager) myRecyclerView.getLayoutManager();
                AlunoAdapter adapter = (AlunoAdapter) myRecyclerView.getAdapter();
                if(myList.size() != llm.findLastCompletelyVisibleItemPosition() + 1 ) {
                    List<Aluno> aux = ((MainActivity) getActivity()).getMyList();
                    for(int i =0;i<aux.size();i++) {
                        adapter.addListItem(aux.get(i),myList.size());
                    }
                 }

            }
        });
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        myRecyclerView.setLayoutManager(llm);
        myList = ((MainActivity) getActivity()).getMyList();
        AlunoAdapter adapter = new AlunoAdapter(myList,getActivity());
        myRecyclerView.setAdapter(adapter);
    }
}
