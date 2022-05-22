package com.doubleclick.marktinhome.ui.MainScreen;


import static com.doubleclick.marktinhome.BaseApplication.ShowToast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.doubleclick.ViewModel.ProductViewModel;
import com.doubleclick.ViewModel.UserViewModel;
import com.doubleclick.marktinhome.Adapters.NavAdapter;
import com.doubleclick.marktinhome.Model.ChildCategory;
import com.doubleclick.marktinhome.Model.ClassificationPC;
import com.doubleclick.marktinhome.Model.User;
import com.doubleclick.marktinhome.R;
import com.doubleclick.marktinhome.Views.SmoothButtom.OnItemSelectedListener;
import com.doubleclick.marktinhome.Views.SmoothButtom.SmoothBottomBar;
import com.doubleclick.marktinhome.ui.Filter.FilterActivity;
import com.doubleclick.marktinhome.ui.MainScreen.Frgments.HomeFragment;
import com.doubleclick.marktinhome.ui.MainScreen.Groups.GroupsActivity;
import com.doubleclick.marktinhome.ui.MainScreen.Parents.ParentActivity;
import com.mxn.soul.flowingdrawer_core.ElasticDrawer;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;

import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainScreenActivity extends AppCompatActivity implements NavAdapter.onClickChild, SwipeRefreshLayout.OnRefreshListener {

    private SmoothBottomBar bottomBar;
    private NavController navController;
    private RecyclerView menu_recycler_view;
    private ProductViewModel productViewModel;
    private SearchView search;
    private FlowingDrawer drawerLayout;
    private ImageView openDrawer;
    private UserViewModel userViewModel;
    private CircleImageView myImage;
    private View main_fragment;
    //    private RecentSearchViewModel recentSearchViewModel;
    private String ShareUrl;
    private String type;
    private SwipeRefreshLayout refreshCategorical;
    private NavAdapter catecoriesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
//        recentSearchViewModel = new ViewModelProvider(this).get(RecentSearchViewModel.class);
        ShareUrl = getIntent().getStringExtra("ShareUrl");
        type = getIntent().getStringExtra("type");
        main_fragment = findViewById(R.id.main_fragment);
        navController = Navigation.findNavController(this, main_fragment.getId());
        menu_recycler_view = findViewById(R.id.menu_recycler_view);
        search = findViewById(R.id.search);
        bottomBar = findViewById(R.id.bottomBar);
        refreshCategorical = findViewById(R.id.refreshCategorical);
        refreshCategorical.setOnRefreshListener(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        openDrawer = findViewById(R.id.openDrawer);
        drawerLayout = findViewById(R.id.drawer_layout);
        myImage = findViewById(R.id.myImage);
        drawerLayout.setTouchMode(ElasticDrawer.TOUCH_MODE_BEZEL);
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                Glide.with(MainScreenActivity.this).load(user.getImage()).into(myImage);
            }
        });
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("");
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.menu_Cart, R.id.menu_group, R.id.homeFragment, R.id.menu_profile).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        setupSmoothBottomMenu();
        loadCategorical();
        openDrawer.setOnClickListener(v -> {
            drawerLayout.openMenu(true);
        });

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query.contains("https://www.market.doublethink.com/product/")) {
                    String[] url = query.split("com.doubleclick.marktinhome/product/");
                    String idProduct = url[1];
                    Intent intent = new Intent(MainScreenActivity.this, FilterActivity.class);
                    intent.putExtra("id", idProduct);
                    intent.putExtra("type", "ShareUrl");
                    startActivity(intent);
                } else {
//                    Sending.Check(query, MainScreenActivity.this, MainScreenActivity.this);
                    Intent intent = new Intent(MainScreenActivity.this, FilterActivity.class);
                    intent.putExtra("id", query);
                    intent.putExtra("type", "search");
                    startActivity(intent);
                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        refreshCategorical.setColorScheme(R.color.blue, R.color.ripplecoloreffect, R.color.green, R.color.orange);

        //  https://developer.android.com/training/sharing/receive#java
        Share(ShareUrl, type);
    }

    private void Share(String ShareUrl, String type) {
        try {
            if (!ShareUrl.equals("") && type.equals("group")) {
                Intent intent = new Intent(MainScreenActivity.this, GroupsActivity.class);
                intent.putExtra("id", ShareUrl);
                intent.putExtra("type", "ShareUrl");
                startActivity(intent);
            }
            if (!ShareUrl.equals("") && type.equals("product")) {
                Intent intent = new Intent(MainScreenActivity.this, FilterActivity.class);
                intent.putExtra("id", ShareUrl);
                intent.putExtra("type", "ShareUrl");
                startActivity(intent);
            }
        } catch (NullPointerException e) {

        }

    }


    private void loadCategorical() {
        productViewModel = new ProductViewModel();
        productViewModel.getClassification();
        productViewModel.getClassificationPC().observe(this, classificationPCS -> {
            catecoriesAdapter = new NavAdapter(classificationPCS, this);
            menu_recycler_view.setAdapter(catecoriesAdapter);
        });
    }

    private void setupSmoothBottomMenu() {
        PopupMenu popupMenu = new PopupMenu(this, null);
        popupMenu.inflate(R.menu.menu_bottom);
        Menu menu = popupMenu.getMenu();
        bottomBar.setupWithNavController(menu, navController);
    }

    @Override
    public void onClickedNavChild(ChildCategory childCategory) {
        Intent intent = new Intent(MainScreenActivity.this, FilterActivity.class);
        intent.putExtra("id", childCategory.getPushId());
        intent.putExtra("type", "childId");
        startActivity(intent);
    }

    @Override
    public void onClickedNavParent(ClassificationPC classificationPC) {
        Intent intent = new Intent(MainScreenActivity.this, ParentActivity.class);
        intent.putExtra("classificationPC", classificationPC);
        startActivity(intent);
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadCategorical();
                refreshCategorical.setRefreshing(false);
            }
        }, 2000);
    }
}