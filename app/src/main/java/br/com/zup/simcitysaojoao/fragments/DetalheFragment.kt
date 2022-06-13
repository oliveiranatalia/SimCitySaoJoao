package br.com.zup.simcitysaojoao.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.simcitysaojoao.KEY
import br.com.zup.simcitysaojoao.R
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
        getLista()
    }
    private fun getLista(){
        val produto = arguments?.getParcelable<Produto>(KEY)
        if(produto != null){
            binding.tvNomeProduto.text = produto.getNome()
            binding.tvQtdProduto.text = produto.getQuantidade().toString()
            binding.tvValorProduto.text = produto.getValor().toString()
            binding.tvReceita.text = produto.getReceita()
        }
    }
}