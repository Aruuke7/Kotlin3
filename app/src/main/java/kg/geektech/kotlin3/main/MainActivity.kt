package kg.geektech.kotlin3.main

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import kg.geektech.kotlin3.base.BaseActivity
import kg.geektech.kotlin3.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    private lateinit var registerForActivityResult: ActivityResultLauncher<Intent>
    private val adapter = MainAdapter()
    private val imagesUri = mutableListOf<Uri>()


    override fun showInternet() {
    }

    override fun initViewModel() {
    }

    override fun initView() {
        supportActionBar?.title = "Выбрать фотографии"
        binding.rvRecycler.adapter = adapter
        binding.rvRecycler.layoutManager = GridLayoutManager(this,3)
    }

    @SuppressLint("ObsoleteSdkInt")
    override fun initListener() {

        binding.btnSelect.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE,true)
            intent.type = "image/*"
            registerForActivityResult.launch(intent)
            supportActionBar?.title = "Выбранные фотографии"
        }

        registerForActivityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if(result.resultCode==Activity.RESULT_OK){
                val data:Intent? = result.data
                if (data?.clipData != null){
                    val count = data.clipData?.itemCount ?:0
                    for (i in 0 until count){
                        val uri: Uri? = data.clipData?.getItemAt(i)?.uri
                        if (uri != null) {
                            imagesUri.add(uri)
                        }
                    }
                    adapter.acceptImages(imagesUri)
                }
            }
        }
    }

    override fun inflateVB(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(inflater)
    }

}