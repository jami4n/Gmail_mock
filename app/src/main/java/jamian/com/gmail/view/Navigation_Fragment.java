package jamian.com.gmail.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import jamian.com.gmail.R;
import jamian.com.gmail.adapter.navigation_adapter.Navigation_Adapter;
import jamian.com.gmail.model.navigation_model.Navigation_data;
import jamian.com.gmail.utils.LinkClicked;

public class Navigation_Fragment extends Fragment implements LinkClicked {

    private FragmentDrawerListener drawerListener;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private View containerView;

    private ArrayList<Navigation_data> navigation_data;
    private Navigation_Adapter navigation_adapter;
    private RecyclerView recyc_menu;

    private int current_dataset = 1;

    public Navigation_Fragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_menu,container,false);

        navigation_data = new ArrayList<>();
        navigation_adapter = new Navigation_Adapter(navigation_data,getActivity());
        recyc_menu = v.findViewById(R.id.recyc_menu);

        recyc_menu.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyc_menu.setItemAnimator(new DefaultItemAnimator());
        recyc_menu.setAdapter(navigation_adapter);

        TextView tv_user_email = v.findViewById(R.id.tv_user_email);
        tv_user_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(current_dataset == 1){
                    setDataSetTwo();
                }else{
                    setDataSetOne();
                }
            }
        });

        setDataSetOne();
        
        return v;
    }

    private void setDataSetOne() {

        current_dataset = 1;

        navigation_data.clear();

        Navigation_data n = new Navigation_data("Primary",R.drawable.fax,"23",2);
        navigation_data.add(n);
        n = new Navigation_data("Social",R.drawable.fax,"23",2);
        navigation_data.add(n);
        n = new Navigation_data("Promotions",R.drawable.fax,"23",2);
        navigation_data.add(n);
        n = new Navigation_data("Starred",R.drawable.fax,"23",2);
        navigation_data.add(n);

        navigation_adapter.notifyDataSetChanged();

    }

    private void setDataSetTwo() {

        current_dataset = 2;

        navigation_data.clear();

        Navigation_data n = new Navigation_data("Add account",R.drawable.upload,"23",2);
        navigation_data.add(n);
        n = new Navigation_data("Manage Account",R.drawable.upload,"23",2);
        navigation_data.add(n);

        navigation_adapter.notifyDataSetChanged();

    }




    public void setUp(int fragmentId, DrawerLayout drawerLayout, final Toolbar toolbar) {
        containerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.app_name, R.string.app_name) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                toolbar.setAlpha(1 - slideOffset / 2);
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

    }

    @Override
    public void linkClicked(String link, int position, View view) {
        drawerListener.onDrawerItemSelected(view,position,link);
        mDrawerLayout.closeDrawer(containerView);
    }


    public interface FragmentDrawerListener {
        void onDrawerItemSelected(View view, int position, String link);
    }

    public void setDrawerListener(FragmentDrawerListener listener) {
        this.drawerListener = listener;
    }
}
