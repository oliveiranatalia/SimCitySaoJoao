package br.com.zup.simcitysaojoao.produto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.simcitysaojoao.PRODUTOS
import br.com.zup.simcitysaojoao.databinding.ActivityProdutoBinding

class ProdutoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProdutoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProdutoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getAppBar()

    }
    private fun getAppBar(){
        supportActionBar?.title = PRODUTOS
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}