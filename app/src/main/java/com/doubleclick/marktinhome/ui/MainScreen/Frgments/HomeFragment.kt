package com.doubleclick.marktinhome.ui.MainScreen.Frgments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.doubleclick.OnItem
import com.doubleclick.OnProduct
import com.doubleclick.Tradmarkinterface
import com.doubleclick.ViewModel.AdvertisementViewModel
import com.doubleclick.ViewModel.ProductViewModel
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
    private lateinit var productViewModel: ProductViewModel
    private lateinit var homeModels: ArrayList<HomeModel>
    lateinit var homeAdapter: HomeAdapter
    lateinit var advertisementViewModel: AdvertisementViewModel
    lateinit var trademarkViewModel: TradmarkViewModel
    lateinit var animationView: LottieAnimationView
    private lateinit var timer: Timer;

    //    lateinit var recentSearchViewModel: RecentSearchViewModel
    private var idProduct: String = ""


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
        homeModels = ArrayList()
//        productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
//        advertisementViewModel = ViewModelProvider(this)[AdvertisementViewModel::class.java];
//        trademarkViewModel = ViewModelProvider(this)[TradmarkViewModel::class.java]
//        recentSearchViewModel = ViewModelProvider(this)[RecentSearchViewModel::class.java]
//        productViewModel.parent.observe(viewLifecycleOwner, Observer {
//            if (it.size != 0) {
//                homeModels.add(0, HomeModel(it, HomeModel.TopCategory, this))
//            }
//        });
//        advertisementViewModel.allAdv.observe(viewLifecycleOwner, Observer {
//            homeModels.add(1, HomeModel(it, HomeModel.Advertisement))
//        });
//        productViewModel.product.observe(
//            viewLifecycleOwner,
//            Observer { products: ArrayList<Product?>? ->
//                if (products!!.size != 0) {
//                    homeModels.add(HomeModel(products, HomeModel.Products, this))
//                    homeAdapter = HomeAdapter(homeModels);
//                    MainRecyceler.adapter = homeAdapter
//                    animationView.visibility = View.GONE
//                } else {
//                    animationView.visibility = View.VISIBLE
//                }
//
//            });
////        productViewModel.topDealsLiveData.observe(viewLifecycleOwner, Observer {
//            homeModels.add(HomeModel(it, HomeModel.TopDeal, this, this));
//        })


//        trademarkViewModel.allMark.observe(viewLifecycleOwner, Observer {
//            homeModels.add(HomeModel(it, HomeModel.Trademarks, this))
//        });


//        recentSearchViewModel.lastSearchListLiveDataOneTime.observe(viewLifecycleOwner, Observer {
//            if (it.size != 0) {
//                homeModels.add(HomeModel(HomeModel.RecentSearch, it, this, this, 0))
//            }
//        })

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
                                ShowToast(context, "No Internet Connection")
                            }
                        } catch (e: Exception) {

                        }
                    }

                    override fun onCancelled(error: DatabaseError) {

                    }

                })

        }

        loadHomePage();
        ReloadData();
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
        val productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        val advertisementViewModel = ViewModelProvider(this)[AdvertisementViewModel::class.java];
        val trademarkViewModel = ViewModelProvider(this)[TradmarkViewModel::class.java]
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
        advertisementViewModel.allAdv.observe(viewLifecycleOwner, Observer {
            homeModels.add(1, HomeModel(it, HomeModel.Advertisement))
            timer.cancel()

        });
        productViewModel.product.observe(
            viewLifecycleOwner,
            Observer { products: ArrayList<Product?>? ->
                if (products!!.size != 0) {
                    homeModels.add(HomeModel(products, HomeModel.Products, this))
                    timer.cancel()
                }
            });
        productViewModel.topDealsLiveData.observe(viewLifecycleOwner, Observer {
            if (it.size != 0) {
                homeModels.add(HomeModel(it, HomeModel.TopDeal, this, this));
                timer.cancel()
            }
        })
        trademarkViewModel.allMark.observe(viewLifecycleOwner, Observer {
            if (it.size != 0) {
                homeModels.add(HomeModel(it, HomeModel.Trademarks, this))
                timer.cancel()
            }
        });
        // to get last Recent Search
//        recentSearchViewModel.lastSearchListLiveDataOneTime.observe(viewLifecycleOwner, Observer {
//            if (it.size != 0) {
//                homeModels.add(HomeModel(HomeModel.RecentSearch, it, this, this, 0))
//            }
//        })

    }

    private fun ReloadData() {
        timer = Timer();
        val handler = Handler()
        val runnable = Runnable {
            try {
                loadHomePage();
                val intent = requireActivity().intent
                requireActivity().finish()
                startActivity(intent)
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

