package com.musr.openitproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FriendFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FriendFragment extends Fragment {

    public FriendFragment() {
        
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FriendFragment newInstance(String param1, String param2) {
        FriendFragment fragment = new FriendFragment();
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

    FragmentTabHost tabHost;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_friend, container, false);
        tabHost = (FragmentTabHost) view.findViewById(R.id.tabhost);
        tabHost.setup(getContext(), getChildFragmentManager(), android.R.id.tabcontent);
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator(getResources().getString(R.string.friend_following)), FriendChildFollowingFragment.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator(getResources().getString(R.string.friend_follower)), FriendChildFollowerFragment.class, null);

        for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {

            TextView tv = (TextView) tabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
            tv.setTextColor(0xFFFFFFFF);
        }
        getActivity().setTitle(getResources().getString(R.string.friend));

        return view;
    }


}
