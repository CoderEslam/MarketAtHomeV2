package com.doubleclick.marktinhome.ui.ProductActivity

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.widget.*
import androidx.appcompat.widget.AppCompatToggleButton
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.doubleclick.ViewModel.RateViewModel
import com.doubleclick.marktinhome.Adapters.ProductSliderAdapter
import com.doubleclick.marktinhome.BaseApplication.ShowToast
import com.doubleclick.marktinhome.BaseApplication.context
import com.doubleclick.marktinhome.Model.Constantes
import com.doubleclick.marktinhome.Model.Product
import com.doubleclick.marktinhome.R
import com.doubleclick.marktinhome.Repository.BaseRepository.myId
import com.doubleclick.marktinhome.Repository.BaseRepository.reference
import com.doubleclick.marktinhome.ui.MainScreen.Comments.CommentsActivity
import com.github.anastr.speedviewlib.AwesomeSpeedometer
import com.github.anastr.speedviewlib.SpeedView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.nex3z.togglebuttongroup.SingleSelectToggleGroup
import com.nex3z.togglebuttongroup.button.CircularToggle
import com.paypal.android.sdk.v
import lecho.lib.hellocharts.model.PieChartData
import lecho.lib.hellocharts.model.SliceValue
import lecho.lib.hellocharts.view.PieChartView
import java.util.ArrayList
import java.util.HashMap

class productActivity : AppCompatActivity() {

    private lateinit var fab: FloatingActionButton
    private lateinit var banner_slier_view_pager: ViewPager
    private lateinit var productName: TextView
    private lateinit var trarmark: TextView
    private lateinit var price: TextView
    private lateinit var lastPrice: TextView
    private lateinit var TotalRating: TextView;
    private lateinit var yourRate: RatingBar;
    private lateinit var rateViewModel: RateViewModel;
    private lateinit var addToggalsLinearLayout: LinearLayout
    lateinit var plus: ImageView
    lateinit var mins: ImageView
    lateinit var quantity: TextView
    var qNumber: Int = 0
    lateinit var share: ImageView
    lateinit var pieChartView: PieChartView
    lateinit var ratingSeller: TextView
    private var ToggleItem: String? = ""
    lateinit var comments: TextView;
    lateinit var product: Product
    lateinit var toggleGroup: SingleSelectToggleGroup
    lateinit var webView: WebView
    private lateinit var speedView: AwesomeSpeedometer


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        rateViewModel = ViewModelProvider(this)[RateViewModel::class.java]
        fab = findViewById(R.id.fab)
        banner_slier_view_pager = findViewById(R.id.banner_slier_view_pager)
        productName = findViewById(R.id.productName)
        trarmark = findViewById(R.id.trarmark)
        price = findViewById(R.id.price)
        webView = findViewById(R.id.webView);
        lastPrice = findViewById(R.id.lastPrice)
        TotalRating = findViewById(R.id.TotalRating)
        yourRate = findViewById(R.id.yourRate);
        comments = findViewById(R.id.comments);
        speedView = findViewById(R.id.speedView);
        addToggalsLinearLayout = findViewById(R.id.addToggalsLinearLayout);
        plus = findViewById(R.id.plus)
        quantity = findViewById(R.id.quantity)
        mins = findViewById(R.id.mins)
        share = findViewById(R.id.share);
        toggleGroup = findViewById(R.id.toggleGroup)
        ratingSeller = findViewById(R.id.ratingSeller)
        pieChartView = findViewById(R.id.pieChartView);
        product = intent.getParcelableExtra("product")!!
        Log.e("productproducts", product.toString());
        productName.text = product.productName
        trarmark.text = product.tradeMark
        price.text = product.price.toString()
        lastPrice.text = product.lastPrice.toString()
        webView.loadDataWithBaseURL(
            null,
            product.description,
            "text/html",
            "utf-8",
            null
        );

        val spliter =
            product.toggals.toString().replace("[", "").replace("]", "").replace(" ", "").split(",")
        for (i in spliter.indices) {
            val circularToggle = CircularToggle(this)
            circularToggle.text = spliter[i]
            circularToggle.setOnClickListener {
                ToggleItem = spliter[i]

            }
            toggleGroup.addView(circularToggle)
        }
        ratingSeller.text = product.ratingSeller.toInt().toString()
        speedView.speedTo(product.ratingSeller.toFloat());
        setBannerSliderViewPager(product.images)
        rateViewModel.getMyRate(myId, product.productId)
        rateViewModel.myRateing.observe(this) {
            if (it != null) {
                yourRate.rating = it.rate.toFloat();
            }
        }

        rateViewModel.getAllRate(product.productId)

        rateViewModel.allRateing.observe(this) {
            TotalRating.text = it.size.toString() + " ratings"
            val map: HashMap<String, Any> = HashMap();
            map["TotalRating"] = (it.size);
            reference.child(Constantes.PRODUCT).child(product.productId).updateChildren(map);
            var r1 = 0f;
            var r2 = 0f;
            var r3 = 0f;
            var r4 = 0f;
            var r5 = 0f
            val list: MutableList<SliceValue> = ArrayList();
            for (i in it) {
                if (0.0 < i.rate.toFloat() && i.rate.toFloat() <= 1.0) {
                    r1 += 1
                    list.add(SliceValue(r1, Color.RED))
                }
                if (1.0 < i.rate.toFloat() && i.rate.toFloat() <= 2.0) {
                    r2 += 1
                    list.add(SliceValue(r2, Color.RED))
                }
                if (2.0 < i.rate.toFloat() && i.rate.toFloat() <= 3.0) {
                    r3 += 1
                    list.add(SliceValue(r3, Color.YELLOW))
                }
                if (3.0 < i.rate.toFloat() && i.rate.toFloat() <= 4.0) {
                    r4 += 1
                    list.add(SliceValue(r4, Color.YELLOW))
                }
                if (4.0 < i.rate.toFloat() && i.rate.toFloat() <= 5.0) {
                    r5 += 1
                    list.add(SliceValue(r5, Color.GREEN))
                }
            }
            val data = PieChartData(list);
            data.setHasCenterCircle(true)
            data.setHasLabels(true)
            data.centerText1 = "Rating"
            data.centerText1FontSize = 18
            data.centerText1Color = Color.BLUE
            pieChartView.pieChartData = data;
        }

        fab.setOnClickListener {
            if (qNumber != 0 && !ToggleItem.equals("")) {
                val id = myId + ":" + product.productId
                val map: HashMap<String, Any> = HashMap();
                map["ProductId"] = product.productId;
                map["BuyerId"] = myId;
                map["SellerId"] = product.adminId;
                map["TotalPrice"] = (qNumber.toDouble() * product.price.toDouble()).toLong();
                map["Quantity"] = qNumber.toLong();
                map["price"] = product.price.toLong();
                map["images"] = product.images;
                map["productName"] = product.productName;
                map["lastPrice"] = product.lastPrice
                map["id"] = id;
                map["ToggleItem"] = ToggleItem!!
                reference.child(Constantes.CART).child(id).setValue(map);
            } else {
                ShowToast("you can't order less than one!");
            }


        }

        yourRate.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            val id = myId + ":" + product.productId
            if (rating > 0f) {
                val map: HashMap<String, Any> = HashMap();
                map["id"] = id
                map["rate"] = rating.toString()
                map["productId"] = product.productId
                map["myId"] = myId
                reference.child(Constantes.RATE).child(id).updateChildren(map);
            }
            if (rating == 0f) {
                reference.child(Constantes.RATE).child(id).removeValue();

            }
        }

        plus.setOnClickListener {
            qNumber++
            quantity.text = qNumber.toString()
        }

        mins.setOnClickListener {
            if (quantity.text.toString() == "0") {
                quantity.text = qNumber.toString()
                ShowToast("you can't order less than one!");
                return@setOnClickListener
            } else {
                qNumber--
                quantity.text = qNumber.toString()
            }

        }

        share.setOnClickListener {
            ShareProduct()
        }

        comments.setOnClickListener {
            val intent = Intent(this, CommentsActivity::class.java)
            intent.putExtra("idproduct", product.productId)
            startActivity(intent)
        }

    }


    fun setBannerSliderViewPager(list: String?) {
        val sliderAdapter = ProductSliderAdapter(list)
        banner_slier_view_pager.adapter = sliderAdapter
        banner_slier_view_pager.clipToPadding = false
        banner_slier_view_pager.pageMargin = 20
    }


    fun ShareProduct() {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(
                Intent.EXTRA_TEXT,
                "https://www.market.doublethink.com/" + product.productId
            )
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }
}