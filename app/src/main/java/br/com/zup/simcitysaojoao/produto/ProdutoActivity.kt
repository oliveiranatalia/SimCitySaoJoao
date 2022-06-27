package br.com.zup.simcitysaojoao.produto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import br.com.zup.simcitysaojoao.databinding.ActivityProdutoBinding

class ProdutoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProdutoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProdutoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        appBar()
        toolbar()
    }
    private fun appBar(){
        supportActionBar?.hide()
    }
    private fun toolbar(){
        val navHostFragment = (supportFragmentManager.findFragmentById(binding.navHostFragment.id)) as NavHostFragment
        val navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolbar.setupWithNavController(navController,appBarConfiguration)
    }
}