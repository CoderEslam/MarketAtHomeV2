package com.doubleclick.marktinhome.ui.MainScreen.Groups;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.doubleclick.ViewModel.GroupViewModel;
import com.doubleclick.marktinhome.Adapters.ItemGroupsAdapter;
import com.doubleclick.marktinhome.Model.Group;
import com.doubleclick.marktinhome.R;
import com.todkars.shimmer.ShimmerRecyclerView;

import java.util.ArrayList;


public class MyGroupsFragment extends Fragment {

    private ShimmerRecyclerView myGroupsRecycler;
    public GroupViewModel groupViewModel;
    private ArrayList<Group> groups = new ArrayList<>();

    public MyGroupsFragment() {
        // Required empty public constructor
    }


    public static MyGroupsFragment newInstance(String param1, String param2) {
        MyGroupsFragment fragment = new MyGroupsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_groups, container, false);
        myGroupsRecycler = view.findViewById(R.id.MyGroupsRecycler);
        groupViewModel = new ViewModelProvider(this).get(GroupViewModel.class);
        ItemGroupsAdapter itemGroupsAdapter = new ItemGroupsAdapter(groups);
        myGroupsRecycler.setAdapter(itemGroupsAdapter);
        myGroupsRecycler.showShimmer();     // to start showing shimmer
        groupViewModel.myGroups().observe(getViewLifecycleOwner(), new Observer<Group>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onChanged(Group group) {
                if (group != null) {
                    groups.add(group);
                    itemGroupsAdapter.notifyItemInserted(groups.size() - 1);
                    itemGroupsAdapter.notifyDataSetChanged();
                    myGroupsRecycler.hideShimmer();
                }
            }
        });


        return view;
    }
}