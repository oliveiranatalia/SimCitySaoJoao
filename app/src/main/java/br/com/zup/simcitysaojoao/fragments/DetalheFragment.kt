package br.com.zup.simcitysaojoao.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.zup.simcitysaojoao.*
import br.com.zup.simcitysaojoao.databinding.FragmentDetalheBinding
import br.com.zup.simcitysaojoao.model.Produto

class DetalheFragment : Fragment() {
    private lateinit var binding: FragmentDetalheBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetalheBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getItem()

        binding.ivIconeFav.setOnClickListener {
            favoritarItem()
        }
    }
    private fun getItem(){
        val produto = arguments?.getParcelable<Produto>(PRODUTO)
        if(produto != null){
            val nome = "${QTD} ${produto.getQuantidade()}"
            val valor = "${VAL} ${produto.getValor()}"
            val receita = "${REC} ${produto.getReceita()}"
            binding.tvNomeProduto.text = produto.getNome()
            binding.tvQtdProduto.text = nome
            binding.tvValorProduto.text = valor
            binding.tvReceita.text = receita
        }
    }
    private fun favoritarItem(){
        Toast.makeText(context, FAV, Toast.LENGTH_SHORT).show()
    }
}