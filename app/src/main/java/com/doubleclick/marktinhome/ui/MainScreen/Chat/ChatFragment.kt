package com.doubleclick.marktinhome.ui.MainScreen.Chat

import android.Manifest
import android.animation.Animator
import android.annotation.SuppressLint
import android.app.Activity
import android.app.DownloadManager
import android.app.ProgressDialog
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.graphics.Color
import android.location.LocationManager
import android.media.MediaRecorder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.ContactsContract
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.*
import android.webkit.MimeTypeMap
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devlomi.record_view.OnRecordListener
import com.devlomi.record_view.RecordButton
import com.devlomi.record_view.RecordView
import com.doubleclick.Api.APIService
import com.doubleclick.OnMessageClick
import com.doubleclick.ViewModel.ChatViewModel
import com.doubleclick.ViewModel.UserViewModel
import com.doubleclick.marktinhome.Adapters.BaseMessageAdapter
import com.doubleclick.marktinhome.BaseFragment
import com.doubleclick.marktinhome.Database.ChatViewModelDatabase
import com.doubleclick.marktinhome.Model.*
import com.doubleclick.marktinhome.Model.Constantes.CHATS
import com.doubleclick.marktinhome.Model.Constantes.USER
import com.doubleclick.marktinhome.Notifications.Client
import com.doubleclick.marktinhome.R
import com.doubleclick.marktinhome.Repository.ChatReopsitory
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.tasks.Task
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.StorageTask
import com.google.firebase.storage.UploadTask
import com.paypal.android.sdk.u
import com.vanniktech.emoji.EmojiPopup
import de.hdodenhof.circleimageview.CircleImageView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.io.IOException
import java.util.*
import kotlin.collections.HashMap


class ChatFragment : BaseFragment(), OnMapReadyCallback, OnMessageClick, ChatReopsitory.StatusChat {

    private lateinit var sendText: ImageView
    private lateinit var et_text_message: EditText
    private lateinit var chatRecycler: RecyclerView;
    private lateinit var chatViewModel: ChatViewModel
    private lateinit var chatAdapter: BaseMessageAdapter
    private lateinit var recordView: RecordView
    private lateinit var sendRecord: RecordButton
    private lateinit var mediaRecorder: MediaRecorder
    private lateinit var googleMap: GoogleMap
    var supportMapFragment: SupportMapFragment? = null
    var mLocationRequest: LocationRequest? = null
    var locationManager: LocationManager? = null
    var client: FusedLocationProviderClient? = null
    private var PICK_CONTACT = 100
    private val REQUEST_CODE = 101;
    private lateinit var file: ImageView
    private lateinit var video: ImageView
    private lateinit var contact: ImageView
    private lateinit var image: ImageView
    private lateinit var location: ImageView
    private lateinit var emotion: ImageView
    private lateinit var attach_file: ImageView
    private lateinit var layout_text: ConstraintLayout
    private lateinit var profile_image: CircleImageView
    private lateinit var continer_attacht: ConstraintLayout;
    private lateinit var username: TextView;
    private lateinit var status: TextView;
    private lateinit var apiService: APIService
    private lateinit var toolbar: Toolbar
    private var sharePost: String = "null".toString()
    private lateinit var chatViewModelDatabase: ChatViewModelDatabase
    private lateinit var userViewModel: UserViewModel
    private lateinit var storageReference: StorageReference
    private lateinit var option: ImageView;
    var fileType: String? = null
    private var chats: ArrayList<Chat> = ArrayList();
    var audioPath: String? = null
    private var cklicked = true
    private lateinit var user: User


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            if (!it.isEmpty) {
                sharePost = it.getString("sharePost").toString()
            }
            if (!it.isEmpty) {
                user = it.getSerializable("user") as User
            }
            if (it.isEmpty) {
                val User by navArgs<ChatFragmentArgs>()
                user = User.user;
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged", "UseCompatLoadingForDrawables")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_chat, container, false)
        sendText = view.findViewById(R.id.sendText);
        et_text_message = view.findViewById(R.id.et_text_message);
        continer_attacht = view.findViewById(R.id.continer_attacht);
        chatRecycler = view.findViewById(R.id.chatRecycler);
        chatRecycler.setHasFixedSize(true);
        sendRecord = view.findViewById(R.id.sendRecord);
        recordView = view.findViewById(R.id.recordView);
        emotion = view.findViewById(R.id.emotion);
        layout_text = view.findViewById(R.id.layout_text)
        attach_file = view.findViewById(R.id.attach_file);
        sendRecord.setRecordView(recordView)
        file = view.findViewById(R.id.file)
        option = view.findViewById(R.id.option);
        location = view.findViewById(R.id.location)
        image = view.findViewById(R.id.image)
        video = view.findViewById(R.id.video)
        contact = view.findViewById(R.id.contact)
        profile_image = view.findViewById(R.id.profile_image)
        username = view.findViewById(R.id.username)
        status = view.findViewById(R.id.status)
        toolbar = view.findViewById(R.id.toolbar)
        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)
        setHasOptionsMenu(true);
        apiService = Client.getClient("https://fcm.googleapis.com/").create(APIService::class.java)
        supportMapFragment =
            requireActivity().supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        client = LocationServices.getFusedLocationProviderClient(requireContext())
        locationManager =
            requireActivity().getSystemService(Context.LOCATION_SERVICE) as LocationManager
        chatViewModelDatabase = ViewModelProvider(this)[ChatViewModelDatabase::class.java]
        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        // TODO get All chat from database and put it in arrayList
        chats.addAll(chatViewModelDatabase.getListData(myId, user!!.id));
        chatAdapter = BaseMessageAdapter(chats, this, myId);
        chatRecycler.adapter = chatAdapter
        chatAdapter.notifyDataSetChanged()

        chatViewModel = ViewModelProvider(this)[ChatViewModel::class.java]
        chatViewModel.ChatById(user!!.id, this)
        userViewModel.getUserById(user.id)
        userViewModel.userInfo.observe(viewLifecycleOwner) {
            Glide.with(requireContext()).load(it!!.image).into(profile_image)
            username.text = it!!.name;
            status.text = it!!.status;
        }

        if (sharePost != "null") {
            et_text_message.setText(sharePost)
            sendRecord.visibility = View.GONE
            sendText.visibility = View.VISIBLE
        }

//        chatViewModel.myChat.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
////            chats = it;
//        })
        sendText.setOnClickListener {
            sentMessage(et_text_message.text.toString().trim(), "text")
        }
        chatViewModel.newInsertChat().observe(viewLifecycleOwner) {
            if (it.sender.equals(myId) && !it.isSeen) {
                if (!chats.contains(it)) {
                    chats.add(it)
                    chatAdapter.notifyItemInserted(chats.size - 1)
                    chatAdapter.notifyDataSetChanged()
                    chatRecycler.scrollToPosition(chats.size - 1)
                    chatRecycler.smoothScrollToPosition(chats.size - 1)
                }
            }
            /*
            * if I'm receiver -> update that i see this message
            * */
            if (it.receiver.equals(myId)) {
                // TODO update status massage to been seen
                val map: HashMap<String, Any> = HashMap();
                map["StatusMessage"] = "beenSeen" //"beenSeen" , "Uploaded"
                map["seen"] = true
                reference.child(CHATS).child(myId).child(user!!.id).child(it.id)
                    .updateChildren(map);
                reference.child(CHATS).child(user!!.id).child(myId).child(it.id)
                    .updateChildren(map);
            }
        };


        val emojiPopup =
            EmojiPopup.Builder.fromRootView(view.findViewById(R.id.root_view)).build(
                et_text_message
            )
        emotion.setOnClickListener {
            if (cklicked) {
                emojiPopup.toggle()
                cklicked = false
                emotion.setImageDrawable(resources.getDrawable(R.drawable.keyboard))
            } else {
                emojiPopup.dismiss()
                cklicked = true
                emotion.setImageDrawable(resources.getDrawable(R.drawable.ic_baseline_insert_emoticon_24))
            }
        }
        attach_file.setOnClickListener {
            if (continer_attacht.visibility == View.GONE) {
                showLayout()
            } else {
                hideLayout()
            }
        }
        et_text_message.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                sendRecord.isListenForRecord = true
                layout_text.visibility = View.VISIBLE
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString().trim { it <= ' ' }.length == 0) {
                    status("online")
                    sendRecord.visibility = View.VISIBLE
                    sendText.visibility = View.GONE
                    recordView.visibility = View.VISIBLE
                    sendRecord.isListenForRecord = true
                    layout_text.visibility = View.GONE
                    attach_file.visibility = View.VISIBLE
                } else {
                    layout_text.visibility = View.VISIBLE
                    sendRecord.isListenForRecord = true
                    //IMPORTANT
                    sendRecord.visibility = View.GONE
                    sendText.visibility = View.VISIBLE
                    recordView.visibility = View.GONE
                    attach_file.visibility = View.GONE
                    status("typing...")
                    if (sendRecord.isListenForRecord) {
                        sendRecord.isListenForRecord = false
                    }
                }
            }

            override fun afterTextChanged(s: Editable) {
                sendRecord.isListenForRecord = true
                layout_text.visibility = View.VISIBLE
            }
        })
        //Cancel Bounds is when the Slide To Cancel text gets before the timer . default is 8
        //Cancel Bounds is when the Slide To Cancel text gets before the timer . default is 8
        recordView.cancelBounds = 8f
        recordView.setSmallMicColor(Color.parseColor("#FF4081"))
        //prevent recording under one Second
        //prevent recording under one Second
        recordView.setLessThanSecondAllowed(false)
        recordView.setSlideToCancelText("Slide To Cancel")
        recordView.setCustomSounds(R.raw.record_start, R.raw.record_finished, 0)
        recordView.setOnRecordListener(object : OnRecordListener {
            override fun onStart() {
                status("recording...")
                recordView.visibility = View.VISIBLE
                layout_text.visibility = View.INVISIBLE
                setUpRecording()
                try {
                    mediaRecorder.prepare()
                    mediaRecorder.start()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
                sendText.visibility = View.GONE
                Log.d("RecordView", "onStart")
                Toast.makeText(requireContext(), "OnStartRecord", Toast.LENGTH_SHORT).show()
            }

            override fun onCancel() {
                mediaRecorder.reset()
                mediaRecorder.release()
                status("online")
                val file = audioPath?.let { File(it) }
                if (file != null) {
                    if (file.exists()) {
                        file.delete()
                    }
                }
                layout_text.visibility = View.VISIBLE
            }

            override fun onFinish(recordTime: Long) {
                layout_text.visibility = View.VISIBLE
                status("online")
                try {
                    mediaRecorder.stop()
                    mediaRecorder.release()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                sendText.visibility = View.VISIBLE
                sendRecodingMessage(audioPath)
            }

            override fun onLessThanSecond() {
                mediaRecorder.reset()
                mediaRecorder.release()
                val file = audioPath?.let { File(it) }
                if (file != null) {
                    if (file.exists()) {
                        file.delete()
                    }
                }
                layout_text.visibility = View.VISIBLE
                sendText.visibility = View.VISIBLE
            }
        })
        recordView.setOnBasketAnimationEndListener {
            Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show()
            Log.d("RecordView", "Basket Animation Finished")
        }
        image.setOnClickListener {
            fileType = "image"
            openFiles("image/*")
        }
        video.setOnClickListener {
            fileType = "video"
            openFiles("video/*")
        }
        file.setOnClickListener {
            fileType = "file"
            openFiles("application/*")
        }
        location.setOnClickListener {
            getMyLocation()
        }
        contact.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
            startActivityForResult(intent, PICK_CONTACT)
        }
        option.setOnClickListener { v ->
            val pupMenu = PopupMenu(requireContext(), v);
            pupMenu.menuInflater.inflate(R.menu.delete_all_chat, pupMenu.menu);
            pupMenu.setOnMenuItemClickListener {
                if (it.itemId == R.id.delete_all) {
                    chatViewModelDatabase.deleteAll();
                    Toast.makeText(context, "Deleted", Toast.LENGTH_LONG).show()
                }
                true;
            }
            pupMenu.show()
        }
        return view;
    }

    private fun sentMessage(text: String, type: String) {
        val map: HashMap<String, Any> = HashMap()
        val id = reference.push().key.toString()
        val time = Date().time;
        map["sender"] = myId
        map["message"] = text
        map["type"] = type
        map["receiver"] = user!!.id // Id of Admin
        map["date"] = time
        map["id"] = id
        map["StatusMessage"] = "Uploaded"
        val chat = Chat(text, "", type, myId, user!!.id, time, id, "Uploaded", false);
        chatViewModelDatabase.insert(chat);
        upload(id, map);
        et_text_message.setText("")
        makeChatList();
        sendNotifiaction(text);


    }

    private fun upload(id: String, map: HashMap<String, Any>) {
        reference.child(CHATS).child(myId).child(user!!.id.toString())
            .child(id).updateChildren(map);
        reference.child(CHATS).child(user!!.id.toString()).child(myId)
            .child(id).updateChildren(map);
    }

    private fun makeChatList() {
        val map1: HashMap<String, Any> = HashMap();
        map1["id"] = user!!.id
        map1["time"] = -1 * Date().time;
        reference.child(Constantes.CHAT_LIST).child(myId).child(user!!.id).updateChildren(map1)
        val map2: HashMap<String, Any> = HashMap();
        map2["id"] = myId
        map2["time"] = -1 * Date().time;
        reference.child(Constantes.CHAT_LIST).child(user!!.id).child(myId).updateChildren(map2)

    }


    private fun getMyLocation() {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            val task = client!!.lastLocation
            task.addOnSuccessListener { location ->
                if (location != null) {
                    supportMapFragment!!.getMapAsync {
                        val latLng = LatLng(
                            location.latitude,
                            location.longitude
                        )
                        val uri =
                            "https://www.google.com/maps/?q=" + location.latitude + "," + location.longitude
                        Log.e("uri", uri)
                        sentMessage(uri, "location")
                    }
                } else {
                    Toast.makeText(requireContext(), "Open your location", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    private fun getFilePath(): String {
        val contextWrapper = ContextWrapper(requireContext())
        val file = contextWrapper.getExternalFilesDir(Environment.DIRECTORY_MUSIC)
        val date = Date()
        val f = File(file, "chat" + date.time + ".mp3")
        return f.path
    }

    private fun setUpRecording() {
        mediaRecorder = MediaRecorder()
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC)
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
        val file = File(
            Environment.getExternalStorageDirectory(),
            "Chat"
        ) // String f = "/storage/emulated/0/Download";
        if (!file.exists()) {
            file.mkdirs()
        }
        audioPath =
            getFilePath() //file.getAbsolutePath() + File.separator + System.currentTimeMillis() + ".3gp";
        mediaRecorder.setOutputFile(audioPath)
    }


    private fun openFiles(mimeType: String) {
        val intent = Intent()
        intent.type = mimeType
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(intent, REQUEST_CODE)
    }

    private fun status(status: String) {
        val hashMap = HashMap<String, Any>()
        hashMap["status"] = status
        reference.child(USER).child(myId).updateChildren(hashMap)
    }

    override fun onResume() {
        super.onResume()
        status("online")
        currentUser(user!!.id!!)
    }

    override fun onPause() {
        super.onPause()
        status("offline")
        currentUser("none")
    }

    private fun currentUser(userid: String) {
        val editor: SharedPreferences.Editor =
            requireActivity().getSharedPreferences("PREFS", Context.MODE_PRIVATE).edit()
        editor.putString("currentuser", userid)
        editor.apply()
    }


    fun sendRecodingMessage(audioPath: String?) {
        val progressDialog = ProgressDialog(context)
        progressDialog.setMessage("Uploading")
        progressDialog.show()
        if (audioPath != null) {
            val storageReference = FirebaseStorage.getInstance()
                .getReference("/Media/Recording/" + myId + ":" + user!!.id.toString() + System.currentTimeMillis())
            Log.e("audio path", audioPath)
            val audioFile = Uri.fromFile(File(audioPath))
            Log.e("audioFile = ", audioFile.toString())
            storageReference.putFile(audioFile)
                .addOnSuccessListener { success: UploadTask.TaskSnapshot ->
                    val audioUrl = success.storage.downloadUrl
                    audioUrl.addOnCompleteListener { path: Task<Uri> ->
                        if (path.isSuccessful) {
                            val url = path.result.toString()
                            val map: HashMap<String, Any> = HashMap()
                            val time = Date().time
                            val id = reference.push().key.toString()
                            map["sender"] = myId
                            map["receiver"] = user!!.id.toString()
                            map["message"] = url
                            map["type"] = "voice"
                            map["id"] = id
                            map["date"] = time
                            map["StatusMessage"] = "Uploaded" // "Stored" , "beenSeen"
                            val chat = Chat(
                                url,
                                audioPath,
                                "voice",
                                myId,
                                user!!.id,
                                time,
                                id,
                                "Uploaded",
                                false
                            );
                            chatViewModelDatabase.insert(chat);
//                            reference.child(CHATS).child(id).setValue(map)
                            upload(id, map);
                            progressDialog.dismiss()
                            makeChatList()
                            sendNotifiaction("audio")
                        } else {
                            Toast.makeText(context, "Failed!", Toast.LENGTH_SHORT).show()
                            progressDialog.dismiss()
                        }
                    }
                }.addOnProgressListener {
                    val p: Double =
                        100.0 * it.bytesTransferred / it.totalByteCount
                    progressDialog.setMessage("${p.toInt()} % Uploading...")
                }.addOnFailureListener {
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                    progressDialog.dismiss()
                }

        }
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map
        mLocationRequest = LocationRequest()
        mLocationRequest!!.interval = 1000
        mLocationRequest!!.fastestInterval = 1000
        mLocationRequest!!.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
    }

    override fun getFileExtension(uri: Uri?): String? {
        val contentResolver = requireContext().contentResolver
        val mimeTypeMap = MimeTypeMap.getSingleton()
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri!!))
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null && data.data != null) {
            sendFileData(data.data!!)
        } else if (requestCode == PICK_CONTACT && resultCode == Activity.RESULT_OK) {
            PickConact(data!!.data)
        }
    }

    @SuppressLint("Range")
    fun PickConact(contactData: Uri?) {
        val c = requireActivity().managedQuery(contactData, null, null, null, null)
        if (c.moveToFirst()) {
            val id = c.getString(c.getColumnIndexOrThrow(ContactsContract.Contacts._ID))
            val hasPhone = c.getString(c.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))
            if (hasPhone.equals("1", ignoreCase = true)) {
                val phones = requireContext().contentResolver.query(
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + id,
                    null, null
                )
                phones!!.moveToFirst()
                val cNumber = phones.getString(phones.getColumnIndex("data1"))
                val name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                Log.e("NameContact", name + cNumber)
                val message = """
                    $name
                    $cNumber
                    """.trimIndent()
                sentMessage(message, "contact")
            }
        }
    }

    private fun showLayout() {
        val radius = Math.max(continer_attacht.width, continer_attacht.height).toFloat()
        val animator =
            ViewAnimationUtils.createCircularReveal(
                continer_attacht,
                continer_attacht.left,
                continer_attacht.top,
                0f,
                radius * 2
            )
        animator.duration = 500
        continer_attacht.visibility = View.VISIBLE
        animator.start()
    }


    private fun hideLayout() {
        val radius = Math.max(continer_attacht.width, continer_attacht.height).toFloat()
        val animator =
            ViewAnimationUtils.createCircularReveal(
                continer_attacht,
                continer_attacht.left,
                continer_attacht.top,
                radius * 2,
                0f
            )
        animator.duration = 500
        animator.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {}
            override fun onAnimationEnd(animation: Animator) {
                continer_attacht.visibility = View.GONE
            }

            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
        animator.start()
    }

    fun sendFileData(uri: Uri) {
        val uploadTask: StorageTask<*>
        val progressDialog = ProgressDialog(context)
        progressDialog.setMessage("Uploading")
        progressDialog.show()
        if (uri.toString() != "") {
            storageReference =
                FirebaseStorage.getInstance().getReference("/Media/Recording/ChatData")
            val fileReference = storageReference.child(
                System.currentTimeMillis().toString() + "." + getFileExtension(uri)
            )
            uploadTask = fileReference.putFile(uri).addOnSuccessListener {
                val url = it.storage.downloadUrl
                url.addOnCompleteListener {
                    if (it.isSuccessful) {
                        val url = it.result.toString()
                        val map = HashMap<String, Any>()
                        val id = reference.push().key.toString()
                        val time = Date().time;
                        map["sender"] = myId
                        map["receiver"] = user!!.id
                        map["message"] = url
                        map["type"] = fileType.toString()
                        map["id"] = id
                        map["date"] = time
                        map["StatusMessage"] = "Uploaded" // "Stored" , "beenSeen"
                        val chat =
                            Chat(
                                url,
                                uri.toString(),
                                fileType.toString(),
                                myId,
                                user!!.id,
                                time,
                                id,
                                "Uploaded",
                                false
                            );
                        chatViewModelDatabase.insert(chat);
//                    reference.child(CHATS).child(id).setValue(hashMap)
                        upload(id, map);
                        progressDialog.dismiss()
                        makeChatList()
                        sendNotifiaction(fileType.toString())
                    } else {
                        Toast.makeText(context, "Failed!", Toast.LENGTH_SHORT).show()
                        progressDialog.dismiss()
                    }
                }
            }.addOnProgressListener {
                val p: Double =
                    100.0 * it.bytesTransferred / it.totalByteCount
                progressDialog.setMessage("${p.toInt()} % Uploading...")
            }.addOnFailureListener {
                Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                progressDialog.dismiss()
            }
        } else {
            Toast.makeText(context, "No image selected", Toast.LENGTH_SHORT).show()
        }
    }

    private fun sendNotifiaction(message: String) {
        val data = Data(
            myId,
            R.mipmap.ic_launcher,
            "${user!!.name.toString()}: $message",
            "New Message",
            user!!.id.toString()
        )
        val sender = Sender(data, user!!.token.toString())
        apiService.sendNotification(sender)
            .enqueue(object : Callback<MyResponse> {
                override fun onResponse(
                    call: Call<MyResponse>,
                    response: Response<MyResponse>
                ) {
                    if (response.code() == 200) {
                        if (response.body()!!.success != 1) {
                            Toast.makeText(context, "Failed!", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }

                override fun onFailure(call: Call<MyResponse>, t: Throwable) {}
            })
    }


    @SuppressLint("NotifyDataSetChanged")
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Throws(java.lang.Exception::class)
    override fun download(chat: Chat, pos: Int, progressBar: ProgressBar) {
        try {
            val request = DownloadManager.Request(Uri.parse(chat.message))
            request.setDestinationInExternalPublicDir(
                Environment.DIRECTORY_DOWNLOADS,
                "" + chat.type + Date().time
            )
            request.setTitle(requireContext().resources.getString(R.string.app_name));
            request.setDescription("Downloading");
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED) // to notify when download is complete
            request.allowScanningByMediaScanner() // if you want to be available from media players
            request.setVisibleInDownloadsUi(false);
            val manager =
                requireContext().getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            val uri = manager.getUriForDownloadedFile(manager.enqueue(request))
            val chat = Chat(
                chat.message,
                uri.toString(),
                chat.type,
                chat.sender,
                chat.receiver,
                chat.date,
                chat.id,
                chat.statusMessage,
                chat.isSeen
            )
            chats[pos] = chat
            chatAdapter.notifyItemChanged(pos)
            chatAdapter.notifyDataSetChanged()
            // TODO Update Message
            chatViewModelDatabase.update(chat)
        } catch (e: IllegalStateException) {
            Log.e("Exception", e.message!!)
        } catch (e: NullPointerException) {
            Log.e("Exception", e.message!!)
        } catch (e: Exception) {
            Log.e("Exception", e.message!!)
        }
    }

    /*
    *  TODO Store data when friend sent it to me
    *  لمه صاحبي يبعت رساله وانا اشوفها
    */
    @SuppressLint("NotifyDataSetChanged")
    override fun BeenSeenForFriend(chat: Chat?) {
        chatViewModelDatabase.insert(chat!!)
        chats.add(chat)
        chatAdapter.notifyItemInserted(chats.size - 1)
        chatAdapter.notifyDataSetChanged()
        chatRecycler.scrollToPosition(chats.size - 1)
        chatRecycler.smoothScrollToPosition(chats.size - 1)
    }


    /*
    * TODO when i send message and my friend see it
    *  بتتنفذ لمه انا ابعت الرساله و صاحبي يشوفها
    * */
    override fun BeenSeenForMe(chat: Chat?) {
        chatViewModelDatabase.update(chat!!)
        try {
            // TODO update in ArrayList
            chats[chats.indexOf(chat)] = chat
            // TODO update in adapter
            chatAdapter.notifyItemChanged(chats.indexOf(chat))
            chatRecycler.scrollToPosition(chats.size - 1)
            chatRecycler.smoothScrollToPosition(chats.size - 1)

        } catch (e: ArrayIndexOutOfBoundsException) {

        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun deleteForMe(chat: Chat, pos: Int) {
        chatViewModelDatabase.delete(chat)
        chats.removeAt(pos)
        reference.child(CHATS).child(myId).child(user!!.id).child(chat.id).removeValue()
        chatAdapter.notifyItemRemoved(pos)
        chatAdapter.notifyDataSetChanged()
    }

    /*
    * this method implimented from OnClickListner
    * working when I make delete for all
    * delete in firebase and update for friend that is deleted
    * */
    @SuppressLint("NotifyDataSetChanged")
    override fun deleteForAll(chat: Chat, pos: Int) {
        try {
            reference.child(CHATS).child(myId).child(user.id).child(chat.id).removeValue()
                .addOnCompleteListener {
                    reference.child(CHATS).child(user.id).child(myId).child(chat.id).removeValue()
                        .addOnCompleteListener {
                            val c = chat;
                            c!!.message = "this message deleted";
                            c.type = "text"
                            // TODO update in database
                            chatViewModelDatabase.update(c!!)
                            // TODO update in ArrayList
                            chats[pos] = c
                            // TODO update in Adapter
                            chatAdapter.notifyItemChanged(pos)
                            chatAdapter.notifyDataSetChanged()
                        }
                }
        } catch (e: ArrayIndexOutOfBoundsException) {
            Log.e("ArrayIndexOutOfBound", e.message.toString())
        }
    }

    /*
    *this method implimented from statusMessage
    * working when friend make delete for all
    * */
    @SuppressLint("NotifyDataSetChanged")
    override fun deleteForAll(chat: Chat?) {
        try {
            val c = chat;
            c!!.message = "this message deleted";
            c.type = "text"
            chatViewModelDatabase.update(c!!)
//            chats.remove(c)
            chats[chats.indexOf(c)] = c
            chatAdapter.notifyItemChanged(
                chats.indexOf(c)
            )
            chatAdapter.notifyDataSetChanged()
        } catch (e: ArrayIndexOutOfBoundsException) {
            Log.e("ArrayIndexOutOfBound", e.message.toString())
        }
    }


}