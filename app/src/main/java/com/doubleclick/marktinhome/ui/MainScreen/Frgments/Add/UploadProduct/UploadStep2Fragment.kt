package com.doubleclick.marktinhome.ui.MainScreen.Frgments.Add.UploadProduct

import android.annotation.SuppressLint
import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.MimeTypeMap
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.doubleclick.marktinhome.Adapters.ImageAdapter
import com.doubleclick.marktinhome.BaseFragment
import com.doubleclick.marktinhome.R
import com.google.android.gms.tasks.Continuation
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageTask
import com.google.firebase.storage.UploadTask
import java.util.*
import kotlin.collections.ArrayList


class UploadStep2Fragment : BaseFragment(), ImageAdapter.deleteImage {

    private lateinit var productImages: RecyclerView
    private lateinit var next: Button
    private lateinit var addImages: FloatingActionButton
    private var IMAGES_REQUEST: Int = 100
    private var uris: ArrayList<String> = ArrayList()
    private var downloadUri: ArrayList<String> = ArrayList()
    private lateinit var imageAdapter: ImageAdapter
    val product by navArgs<UploadStep2FragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_upload_step2, container, false)
        productImages = view.findViewById(R.id.productImages);
        next = view.findViewById(R.id.next);
        addImages = view.findViewById(R.id.addImages);



        addImages.setOnClickListener {
            openImage()
        }

        next.setOnClickListener {
            UploadData()
        }


        return view;
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGES_REQUEST && resultCode == Activity.RESULT_OK) {
            val clip = data!!.clipData
            if (clip != null) {
                for (j in 0 until clip.itemCount) {
                    val item = clip.getItemAt(j)
                    uris.add(item.uri.toString())
                }
                imageAdapter = ImageAdapter(uris, this);
                productImages.adapter = imageAdapter
            }
        }
    }

    fun UploadData() {
        if (uris.size != 0) {
            var storageReference = FirebaseStorage.getInstance().getReference("Uploads")
            for (i in 0 until uris.size) {
                val fileReference = storageReference.child(
                    System.currentTimeMillis()
                        .toString() + "." + getFileExtension(Uri.parse(uris[i]))
                )
                val uploadTask: StorageTask<*>
                uploadTask = fileReference.putFile(Uri.parse(uris[i]))
                uploadTask.continueWithTask(Continuation<UploadTask.TaskSnapshot?, Task<Uri?>?> { task ->
                    if (!task.isSuccessful) {
                        throw task.exception!!
                    }
                    fileReference.downloadUrl.addOnSuccessListener(OnSuccessListener {
                        downloadUri.add(it.toString())
                        Log.e("uri", downloadUri.toString());

                    })
                }).addOnCompleteListener { task ->
                    if (task.isSuccessful()) {
                        if (uris.size == downloadUri.size) {
                            val map: HashMap<String, Any> = HashMap()
                            val push = reference.push().key.toString();
                            map["productId"] = push
                            map["price"] = product.product.price
                            map["date"] = Date().time
                            map["adminId"] = myId.toString()
                            map["productName"] = product.product.productName.toString()
                            map["lastPrice"] = product.product.lastPrice
                            map["tradeMark"] = product.product.tradeMark.toString()
                            map["parentCategoryId"] = product.product.parentCategoryId.toString()
                            map["childCategoryId"] = product.product.childCategoryId.toString()
                            map["parentCategoryName"] =
                                product.product.parentCategoryName.toString()
                            map["childCategoryName"] = product.product.childCategoryName.toString()
                            map["TotalRating"] = 0
                            map["discount"] = product.product.discount
                            map["ratingSeller"] = product.product.ratingSeller
                            map["Images"] = ""
                            map["description"] = ""
                            map["Toggals"] = product.product.toggals.toString()
                        }
                    }
                }
            }
        }
    }

    override fun getFileExtension(uri: Uri?): String? {
        val contentResolver = requireContext().contentResolver
        val mimeTypeMap = MimeTypeMap.getSingleton()
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri!!))
    }


    override fun openImage() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
        startActivityForResult(intent, IMAGES_REQUEST)
    }

    private fun progress() {
        val builder = AlertDialog.Builder(requireContext());
        val view =
            LayoutInflater.from(context).inflate(R.layout.upload_progress_layout, null, false);
//        builder.setPositiveButton("Ok", DialogInterface.OnClickListener { dialog, which ->
//
//        })
        builder.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which ->
            dialog.dismiss()
            var intent = requireActivity().intent;
            requireActivity().finish()
            startActivity(intent)
        })
        builder.setView(view)
        builder.show()

    }

    @SuppressLint("NotifyDataSetChanged")
    override fun deleteImage(postion: Int) {
        uris.removeAt(postion)
        imageAdapter.notifyItemRemoved(postion)
        imageAdapter.notifyDataSetChanged()
    }
}