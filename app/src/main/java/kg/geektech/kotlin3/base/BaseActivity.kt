package kg.geektech.kotlin3.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding

abstract class BaseActivity <VB: ViewBinding> : AppCompatActivity() {
    protected lateinit var  binding : VB

    protected abstract fun inflateVB(inflater: LayoutInflater):VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateVB(layoutInflater)
        setContentView(binding.root)

        showInternet()
        initViewModel()
        initView()
        initListener()
    }
    abstract fun showInternet()

    abstract fun initViewModel()

    abstract fun initView()

    abstract fun initListener()


}