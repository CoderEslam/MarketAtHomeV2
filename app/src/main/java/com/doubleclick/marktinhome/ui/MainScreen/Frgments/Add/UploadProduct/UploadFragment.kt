package com.doubleclick.marktinhome.ui.MainScreen.Frgments.Add.UploadProduct


import android.annotation.SuppressLint
import android.app.Activity.RESULT_OK
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.MimeTypeMap
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatSpinner
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.divyanshu.colorseekbar.ColorSeekBar
import com.doubleclick.ViewModel.TradmarkViewModel
import com.doubleclick.marktinhome.Adapters.ImageAdapter
import com.doubleclick.marktinhome.Adapters.KeywordAdapter
import com.doubleclick.marktinhome.BaseFragment
import com.doubleclick.marktinhome.Model.Constantes.PRODUCT
import com.doubleclick.marktinhome.Model.Product
import com.doubleclick.marktinhome.R
import com.doubleclick.marktinhome.ui.MainScreen.Frgments.Add.KeywordBottomSheet
import com.doubleclick.marktinhome.ui.MainScreen.Frgments.Add.RichFragment
import com.google.android.gms.tasks.Continuation
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageTask
import com.google.firebase.storage.UploadTask
import com.nex3z.togglebuttongroup.SingleSelectToggleGroup
import com.nex3z.togglebuttongroup.button.CircularToggle
import java.util.*
import kotlin.collections.ArrayList


class UploadFragment : BaseFragment(), KeywordAdapter.OnDelete, KeywordBottomSheet.Keywords {


    lateinit var marke: String
    private lateinit var productName: EditText;
    private lateinit var productPrice: EditText;
    private lateinit var productLastPrice: EditText;

    //    private lateinit var RichTable: FrameLayout;
    //    private lateinit var keywords: ConstraintLayout
//    private lateinit var addKeywords: Button
//    private lateinit var keys: RecyclerView;
    private lateinit var trademark: AppCompatSpinner;
    private lateinit var Upload: Button;
    private lateinit var tradmarkViewModel: TradmarkViewModel
    private lateinit var ratingSeller: RatingBar
    private var ToggleButton: ArrayList<String> = ArrayList()
    var rate: Float = 0f
    lateinit var addToggleButton: RadioGroup
    lateinit var addView: ImageView
    private lateinit var builder: AlertDialog.Builder
    private var colorToggle: Int = 0
    private lateinit var keywordAdapter: KeywordAdapter;
    private lateinit var groupColor: SingleSelectToggleGroup
    private lateinit var addViewColor: ImageView
    private var colors: ArrayList<Int> = ArrayList();
    val parent_child by navArgs<UploadFragmentArgs>()
    var begin = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "\n" +
            "<head>\n" +
            "    <style>\n" +
            "        table,\n" +
            "        th,\n" +
            "        td {\n" +
            "            border: 2px solid black;\n" +
            "            border-collapse: collapse;\n" +
            "        }\n" +
            "      table{\n" +
            "        width: 100%\n" +
            "      }\n" +
            "    </style>\n" +
            "</head>\n" +
            "\n" +
            "<body>";
    var end = "</body>\n" +
            "\n" +
            "</html>";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }


    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_upload, container, false)
        productName = view.findViewById(R.id.productName);
        productPrice = view.findViewById(R.id.productPrice);
        productLastPrice = view.findViewById(R.id.productLastPrice);
//        description = view.findViewById(R.id.description);
//        RichTable = view.findViewById(R.id.RichTable);
//        addKeywords = view.findViewById(R.id.addKeywords);
        groupColor = view.findViewById(R.id.groupColor);
//        keys = view.findViewById(R.id.keys);
        addViewColor = view.findViewById(R.id.addViewColor);
//        requireActivity().supportFragmentManager.beginTransaction()
//            .replace(RichTable.id, RichFragment()).commit()
        trademark = view.findViewById(R.id.trademark);
        Upload = view.findViewById(R.id.Upload);
//        keywords = view.findViewById(R.id.keywords);
        ratingSeller = view.findViewById(R.id.ratingSeller);
        addToggleButton = view.findViewById(R.id.addToggleButton);
        addView = view.findViewById(R.id.addView);
        tradmarkViewModel = ViewModelProvider(this)[TradmarkViewModel::class.java]
        tradmarkViewModel.namesMark.observe(viewLifecycleOwner, Observer {
//            var trademarkAdapter  = TrademarkAdapter(it)
            trademark.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    marke = it.get(position)
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                    marke = it.get(0)

                }
            }
            val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, it)
            trademark.setAdapter(adapter)
        })

        ratingSeller.setOnRatingBarChangeListener({ ratingBar, rating, fromUser ->
            rate = rating;
        })
        Upload.setOnClickListener {
            if (productName.text.toString() == "") {
                productName.error = "input name of product"
            } else if (productPrice.text.toString() == "") {
                productPrice.error = "input price of product"
            } else if (productLastPrice.text.toString() == "") {
                productLastPrice.error = "input last of product"
            } else {
                try {
                    SendData(
                        productName.text.toString(),
                        productPrice.text.toString().toDouble(),
                        productLastPrice.text.toString().toDouble(),
                        marke,
                        parent_child.parent!!.pushId,
                        parent_child.child!!.pushId,
                        parent_child.parent!!.name,
                        parent_child.child!!.name
                    )
                } catch (e: Exception) {
                    Toast.makeText(
                        context,
                        "" + resources.getString(R.string.cantUploadEmpty),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }


//        addKeywords.setOnClickListener {
//            var keywordBottomSheet = KeywordBottomSheet(this);
//            keywordBottomSheet.show(requireActivity().supportFragmentManager, "keywords")
//        }

        addView.setOnClickListener {
            builder = AlertDialog.Builder(requireContext())
            var radio = RadioButton(requireContext())
            val view = LayoutInflater.from(context).inflate(R.layout.add_toggal, null, false)
            val cardView: CardView = view.findViewById(R.id.cardView);
            val editorder: TextInputEditText = view.findViewById(R.id.editname)
            val color_seek_bar: ColorSeekBar = view.findViewById(R.id.color_seek_bar);
            color_seek_bar.visibility = View.INVISIBLE
            builder.setTitle("Add Options")
            builder.setPositiveButton("ok", DialogInterface.OnClickListener { dialog, which ->
                radio.setText("" + editorder.text.toString().trim())
                ToggleButton.add(editorder.text.toString().trim());
                addToggleButton.addView(radio)
                dialog.dismiss()
            })
            builder.setNegativeButton("cancel", DialogInterface.OnClickListener { dialog, which ->
                dialog.dismiss()
            })
            builder.setView(view)
            builder.show()
        }
        addViewColor.setOnClickListener {
            builder = AlertDialog.Builder(requireContext())
            var circuleToggle = CircularToggle(requireContext())
            val view = LayoutInflater.from(context).inflate(R.layout.add_toggal, null, false)
            val cardView: CardView = view.findViewById(R.id.cardView);
            val editorder: TextInputEditText = view.findViewById(R.id.editname)
            val color_seek_bar: ColorSeekBar = view.findViewById(R.id.color_seek_bar);
            color_seek_bar.visibility = View.VISIBLE
            color_seek_bar.setOnColorChangeListener(object : ColorSeekBar.OnColorChangeListener {
                override fun onColorChangeListener(color: Int) {
                    //gives the selected color
                    colorToggle = color;
                    cardView.setBackgroundColor(color)
                }
            })
            builder.setTitle("Add Options")
            builder.setPositiveButton("ok", DialogInterface.OnClickListener { dialog, which ->
                circuleToggle.setText("" + editorder.text.toString().trim())
//                circuleToggle.setBackgroundColor(colorToggle)
                circuleToggle.markerColor = colorToggle
                groupColor.addView(circuleToggle)
                dialog.dismiss()
            })
            builder.setNegativeButton("cancel", DialogInterface.OnClickListener { dialog, which ->
                dialog.dismiss()
            })
            builder.setView(view)
            builder.show()
        }
        return view;
    }


    fun SendData(
        name: String,
        price: Double,
        LastPrice: Double,
        trademark: String,
        ParentId: String,
        ChildId: String,
        ParentName: String,
        ChildName: String,
    ) {
        var lastMoney = 0.0
        var money = 0.0
        if (price > LastPrice) {
            var helper = LastPrice;
            lastMoney = price
            money = helper;
        } else {
            money = price
            lastMoney = LastPrice
        }
        val discount = (-1 * (100 - ((price / LastPrice) * 100.0)))


        val product = Product(
            "",
            money,
            "",
            0,
            myId.toString(),
            name.toString(),
            lastMoney,
            trademark.toString(),
            ParentName.toString(),
            ChildName.toString(),
            ParentId.toString(),
            ChildId.toString(),
            0,
            discount,
            "",
            "",
            ToggleButton.toString(),
            rate
        );

//        reference.child(PRODUCT).child(Objects.requireNonNull(push)).updateChildren(map)
        findNavController().navigate(
            UploadFragmentDirections.actionUploadFragmentToUploadStep2Fragment(
                product
            )
        )
    }


    override fun onItemDelete(pos: Int) {

    }

    override fun ItemsKeyword(items: ArrayList<String>) {

    }

}

