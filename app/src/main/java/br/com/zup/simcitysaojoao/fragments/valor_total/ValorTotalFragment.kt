package br.com.zup.simcitysaojoao.fragments.valor_total

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.simcitysaojoao.KEY
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.TOTAL
import br.com.zup.simcitysaojoao.databinding.FragmentValorTotalBinding
import br.com.zup.simcitysaojoao.model.Produto

class ValorTotalFragment : Fragment() {
    private lateinit var binding: FragmentValorTotalBinding
    private var listaItens = ArrayList<Produto>()

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
        binding.botaoNovoProduto.setOnClickListener {
            getNovoProduto(this.listaItens)
        }
        binding.botaoVerProdutos.setOnClickListener {
            exibirLista(this.listaItens)
        }
    }
   private fun getLista(){
       val lista = arguments?.getParcelableArrayList<Produto>(KEY)
       lista?.let { listaItens = it }
       calculo(listaItens)
   }
    private fun calculo(listaProdutos:ArrayList<Produto>?) {
        var valor = 0.0
       listaProdutos?.forEach { item ->
            valor += item.getQuantidade() * item.getValor()
           if(valor > 0.0) {
               val total = "$TOTAL $valor"
               binding.tvValorTotal.text = total
           }else{
               val semValor = "${R.string.valor_total}"
               binding.tvValorTotal.text = semValor
           }
       }
    }
    private fun getNovoProduto(listaItens:ArrayList<Produto>){
        val bundle = bundleOf(KEY to listaItens)
        NavHostFragment.findNavController(this).navigate(R.id.action_valorTotalFragment_to_cadastroFragment,bundle)
    }
    private fun exibirLista(listaItens:ArrayList<Produto>){
        val bundle = bundleOf(KEY to listaItens)
        NavHostFragment.findNavController(this).navigate(R.id.action_valorTotalFragment_to_produtosFragment,bundle)
    }
}