package com.technicalrupu.learningweek1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.HorizontalScrollView
import android.widget.RadioButton
import com.technicalrupu.learningweek1.Helper.Activity
import com.technicalrupu.learningweek1.firebase.ChatApplication.RoomActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = com.technicalrupu.learningweek1.Helper.Button(this)

        val activity = Activity(this)
        val btnActivity = btn.create(R.id.btnActivity)
        val btnFragment = btn.create(R.id.btnFragment)
        val btnCheckbox = btn.create(R.id.btnCheckbox)
        val btnRadioButton = btn.create(R.id.btnRadio)
        val btnListView = btn.create(R.id.btnListView)
        val btnRecyclerView = btn.create(R.id.btnRecyclerView)
        val btnHorizontalScrollView = btn.create(R.id.btnHorizontalScroll)
        val btnVerticalScrollView = btn.create(R.id.btnVerticalScroll)
        val btnTimePicker = btn.create(R.id.btnTimePicker)
        val btnDatePicker = btn.create(R.id.btnDatePicker)
        val btnProgressView = btn.create(R.id.btnProgressView)
        val btnTabLayout = btn.create(R.id.btnTabLayout)
        val btnActionBar = btn.create(R.id.btnActionBar)
        val btnToast = btn.create(R.id.btnToast)
        val btnAutoCompleteTextView = btn.create(R.id.btnAutoCompleteTextView)
        val btnStartActivityForResult = btn.create(R.id.btnStartActivityForResult)
        val btnRoomDb = btn.create(R.id.btnRoomDb)
        val btnSharedPref = btn.create(R.id.btnSharedPreferences)
        val btnErrorHandling = btn.create(R.id.btnErrorHandling)
        val btnWebView = btn.create(R.id.btnWebView)


        btnActivity.setOnClickListener {
            activity.startActivity(ActivityActivity())
        }

        btnFragment.setOnClickListener {
            activity.startActivity(FragmentActivity())
        }

        btnCheckbox.setOnClickListener {
            activity.startActivity(CheckboxActivity())
        }

        btnRadioButton.setOnClickListener {
            activity.startActivity(RadioButtonActivity())
        }

        btnListView.setOnClickListener {
            activity.startActivity(ListViewActivity())
        }

        btnRecyclerView.setOnClickListener {
            activity.startActivity(RecyclerViewActivity())
        }
        btnHorizontalScrollView.setOnClickListener {
            activity.startActivity(HorizontalScrollViewActivity())
        }
        btnVerticalScrollView.setOnClickListener {
            activity.startActivity(VerticalScrollViewActivity())
        }
        btnTimePicker.setOnClickListener {
            activity.startActivity(TimePickerActivity())
        }
        btnDatePicker.setOnClickListener {
            activity.startActivity(DatePickerActivity())
        }

        btnProgressView.setOnClickListener {
            activity.startActivity(ProgressActivity())
        }
        btnTabLayout.setOnClickListener {
            activity.startActivity(TabLayoutActivity())
        }
        btnActionBar.setOnClickListener {
            activity.startActivity(ActionBarActivity())
        }
        btnToast.setOnClickListener {
            activity.startActivity(ToastActivity())
        }
        btnAutoCompleteTextView.setOnClickListener {
            activity.startActivity(AutoCompleteTextView())
        }
        btnStartActivityForResult.setOnClickListener {
            activity.startActivity(StartActivityForResult())
        }

        btnRoomDb.setOnClickListener {
            activity.startActivity(RoomDbActivity())
        }
        btnSharedPref.setOnClickListener {
            activity.startActivity(SharedPreferencesActivity())
        }
        btnErrorHandling.setOnClickListener {
            activity.startActivity(ErrorHandlingActivity())
        }
        btnWebView.setOnClickListener {
            activity.startActivity(WebViewActivity())
        }
        val btnImagePicker=btn.create(R.id.btnImagePicker)
        btnImagePicker.setOnClickListener {
            activity.startActivity(ImagePickerActivity())
        }
        val btnVideoPicker=btn.create(R.id.btnVideoPicker)
        btnVideoPicker.setOnClickListener {
            activity.startActivity(VideoPickerActivity())
        }
        val btnCamera=btn.create(R.id.btnCamera)
        btnCamera.setOnClickListener {
            activity.startActivity(CameraActivity())
        }
        val btnContacts=btn.create(R.id.btnContacts)
        btnContacts.setOnClickListener {
            activity.startActivity(ContactsActivity())
        }
        val btnCustomContentProvider=btn.create(R.id.btnCustomContentProvider)
        btnCustomContentProvider.setOnClickListener {
            activity.startActivity(CustomContentProviderActivity())
        }

        //2/12/2021
        val btnGoogleMap=btn.create(R.id.btnGoogleMap)
        btnGoogleMap.setOnClickListener {
            activity.startActivity(GoogleMapActivity())
        }

        val btnRuntimePermission=btn.create(R.id.btnRuntimePermission)
        btnRuntimePermission.setOnClickListener {
            activity.startActivity(RuntimePermissionsActivity())
        }

        val btnBackgroundService=btn.create(R.id.btnBackgroundService)
        btnBackgroundService.setOnClickListener {
            activity.startActivity(BackgroundServiceActivity())
        }
        val btnFirebaseConnection=btn.create(R.id.btnFireBaseConnection)
        btnFirebaseConnection.setOnClickListener {
            activity.startActivity(FireBaseActivity())
        }
        val btnRetrofit=btn.create(R.id.btnRetrofit)
        btnRetrofit.setOnClickListener {
            activity.startActivity(RetrofitActivity())
        }
        val btnVolley=btn.create(R.id.btnVolley)
        btnVolley.setOnClickListener {
            activity.startActivity(VolleyActivity())
        }
    // 29/12/2021
        val btnChat=btn.create(R.id.btnChat)
        btnChat.setOnClickListener {
            activity.startActivity(RoomActivity())
        }
    }
}