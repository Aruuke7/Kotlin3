package kg.geektech.kotlin3.main

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import kg.geektech.kotlin3.base.BaseActivity
import kg.geektech.kotlin3.databinding.ActivityMainBinding
import java.util.jar.Manifest

class MainActivity : BaseActivity<ActivityMainBinding>() {
    private lateinit var registerForActivityResult: ActivityResultLauncher<Intent>
    private val adapter = MainAdapter()


    override fun showInternet() {
    }

    override fun initViewModel() {
    }

    override fun initView() {
        binding.rvRecycler.adapter = adapter
        binding.rvRecycler.layoutManager = GridLayoutManager(this,3)
    }

    @SuppressLint("ObsoleteSdkInt")
    override fun initListener() {
        binding.btnSelect.setOnClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE,true)
            intent.action = Intent.ACTION_GET_CONTENT
            registerForActivityResult.launch(intent)
        }

        registerForActivityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()
        ) { result ->
            adapter.asseptImages(result.data)
        }
    }

    override fun inflateVB(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(inflater)
    }

}