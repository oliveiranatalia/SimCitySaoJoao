package br.com.zup.simcitysaojoao.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.simcitysaojoao.KEY
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.databinding.FragmentValorTotalBinding
import br.com.zup.simcitysaojoao.model.Produto

class ValorTotalFragment : Fragment() {
    private lateinit var binding: FragmentValorTotalBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentValorTotalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getLista()
        binding.botaoNovoProduto.setOnClickListener{
            getNovoProduto()
        }
        binding.botaoVerProdutos.setOnClickListener{
            exibirLista()
        }
    }

    private fun getLista() {
        var valor = 0.0
        val listaItens = arguments?.getParcelableArrayList<Produto>(KEY)
        listaItens?.forEach { item ->
            valor+=(item.getQuantidade() * item.getValor())
            val resultado = "O valor total de todos os produtos é de R$ $valor"
            binding.tvValorTotal.text = resultado
        }
    }
    private fun getNovoProduto(){
        NavHostFragment.findNavController(this).navigate(R.id.action_valorTotalFragment_to_cadastroFragment)
    }
    private fun exibirLista(){
        NavHostFragment.findNavController(this).navigate(R.id.action_valorTotalFragment_to_produtosFragment)
    }
}