package com.doubleclick.marktinhome.ui.MainScreen.Frgments

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.airbnb.lottie.LottieAnimationView
import com.doubleclick.OnItem
import com.doubleclick.OnProduct
import com.doubleclick.Tradmarkinterface
import com.doubleclick.ViewModel.AdvertisementViewModel
import com.doubleclick.ViewModel.ProductViewModel
import com.doubleclick.ViewModel.RecentSearchViewModel
import com.doubleclick.ViewModel.TradmarkViewModel
import com.doubleclick.ViewMore
import com.doubleclick.marktinhome.Adapters.HomeAdapter
import com.doubleclick.marktinhome.BaseApplication.isNetworkConnected
import com.doubleclick.marktinhome.BaseFragment
import com.doubleclick.marktinhome.Model.Constantes.PRODUCT
import com.doubleclick.marktinhome.Model.HomeModel
import com.doubleclick.marktinhome.Model.ParentCategory
import com.doubleclick.marktinhome.Model.Product
import com.doubleclick.marktinhome.Model.Trademark
import com.doubleclick.marktinhome.R
import com.doubleclick.marktinhome.Views.Animatoo
import com.doubleclick.marktinhome.ui.MainScreen.FilterParent.FilterParentActivity
import com.doubleclick.marktinhome.ui.MainScreen.MainScreenActivity
import com.doubleclick.marktinhome.ui.Trademark.FilterTradmarkActivity
import com.doubleclick.marktinhome.ui.ProductActivity.productActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import java.util.*
import kotlin.collections.ArrayList


class HomeFragment : BaseFragment(), OnItem, OnProduct, Tradmarkinterface, ViewMore {


    lateinit var MainRecyceler: RecyclerView
    private lateinit var homeModels: ArrayList<HomeModel>
    lateinit var homeAdapter: HomeAdapter
    lateinit var animationView: LottieAnimationView
    private var timer: Timer = Timer();
    private var idProduct: String = ""
    private lateinit var refresh: SwipeRefreshLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            idProduct = it.getString("idProduct", "")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment\
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        MainRecyceler = view.findViewById(R.id.MainRecyceler)
        animationView = view.findViewById(R.id.animationView);
        refresh = view.findViewById(R.id.refresh);
        homeModels = ArrayList()
        if (idProduct != "") {
            reference.child(PRODUCT).child(idProduct)
                .addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        try {
                            if (isNetworkConnected()) {
                                if (snapshot.exists()) {
                                    var product: Product? = snapshot.getValue(Product::class.java)
                                    val intent =
                                        Intent(requireContext(), productActivity::class.java);
                                    intent.putExtra("product", product);
                                    startActivity(intent)
                                }
                            } else {
                                ShowToast("No Internet Connection")
                            }
                        } catch (e: Exception) {

                        }
                    }

                    override fun onCancelled(error: DatabaseError) {

                    }
                })
        }
        refresh.setColorScheme(
            R.color.blue,
            R.color.ripplecoloreffect,
            R.color.green,
            R.color.orange
        )
        refresh.setOnRefreshListener {
            homeModels.clear()
            loadHomePage()
        }
        loadHomePage();
//        ReloadData();
        return view;
    }

    override fun onItem(parentCategory: ParentCategory?) {
        val intent = Intent(requireContext(), FilterParentActivity::class.java)
        intent.putExtra("parentCategory", parentCategory);
        startActivity(intent)
    }

    override fun onItemLong(parentCategory: ParentCategory?) {}

    override fun onItemProduct(product: Product?) {
        val intent = Intent(requireContext(), productActivity::class.java);
        intent.putExtra("product", product);
        startActivity(intent)
    }

    override fun AllTradmark(tradmark: ArrayList<Trademark?>?) {}

    override fun AllNameTradmark(names: List<String?>?) {}

    override fun OnItemTradmark(tradmark: Trademark?) {
        val intent = Intent(requireContext(), FilterTradmarkActivity::class.java)
        intent.putExtra("tradmark", tradmark);
        startActivity(intent)
    }

    override fun onEditTradmark(tradmark: Trademark) {

    }

    override fun onDeleteTradmark(tradmark: Trademark) {

    }

    override fun getViewMore(products: ArrayList<Product>) {

    }

    override fun getViewMore(product: Product) {

    }

    private fun loadHomePage() {
        Loadproduct()
        Loadtrademark()
        Loadadvertisement()
    }

    private fun Loadproduct() {
        val productViewModel = ProductViewModel();
        productViewModel.parent.observe(viewLifecycleOwner, Observer {
            if (it.size != 0) {
                homeModels.add(0, HomeModel(it, HomeModel.TopCategory, this))
                homeAdapter = HomeAdapter(homeModels);
                MainRecyceler.adapter = homeAdapter
                animationView.visibility = View.GONE
                timer.cancel()
            } else {
                animationView.visibility = View.VISIBLE
            }
        });
        productViewModel.topDealsLiveData.observe(viewLifecycleOwner, Observer {
            if (it.size != 0) {
                homeModels.add(HomeModel(it, HomeModel.TopDeal, this, this));
                timer.cancel()
            }
        })
        productViewModel.product.observe(
            viewLifecycleOwner,
            Observer { products: ArrayList<Product?>? ->
                if (products!!.size != 0) {
                    homeModels.add(HomeModel(products, HomeModel.Products, this))
                    timer.cancel()
                }
            });
    }

    private fun Loadtrademark() {
        val trademarkViewModel = TradmarkViewModel()
        trademarkViewModel.allMark.observe(viewLifecycleOwner, Observer {
            if (it.size != 0) {
                homeModels.add(HomeModel(it, HomeModel.Trademarks, this))
                timer.cancel()
            }
        });
    }

    private fun Loadadvertisement() {
        val advertisementViewModel = AdvertisementViewModel();
        advertisementViewModel.allAdv.observe(viewLifecycleOwner, Observer {
            homeModels.add(1, HomeModel(it, HomeModel.Advertisement))
            timer.cancel()

        });
    }

    private fun LoadrecentSearch() {
        val recentSearchViewModel = ViewModelProvider(this)[RecentSearchViewModel::class.java]
//        to get last Recent Search
        recentSearchViewModel.lastSearchListLiveDataOneTime.observe(viewLifecycleOwner, Observer {
            if (it.size != 0) {
                homeModels.add(HomeModel(HomeModel.RecentSearch, it, this, this, 0))
            }
        })
    }

    private fun ReloadData() {
        val handler = Handler()
        val runnable = Runnable {
            try {
                loadHomePage();
                Animatoo.animateSwipeLeft(requireContext());
            } catch (e: Exception) {
                Log.e("ExceptionHomeFrg", e.message.toString());
            }
        }
        timer.schedule(object : TimerTask() {
            override fun run() {
                handler.post(runnable)
            }
        }, 2000, 2000)
    }

}

