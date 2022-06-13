package br.com.zup.simcitysaojoao.fragments.lista_produtos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.simcitysaojoao.*
import br.com.zup.simcitysaojoao.databinding.FragmentProdutosBinding
import br.com.zup.simcitysaojoao.model.Produto
import br.com.zup.simcitysaojoao.produto.adapter.ProdutoAdapter


class ProdutosFragment : Fragment() {
    private lateinit var binding: FragmentProdutosBinding
    private val adapter:ProdutoAdapter by lazy {ProdutoAdapter(arrayListOf(),::detalheProduto)}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProdutosBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getLista()
    }
    private fun getLista() {
        val listaItens = arguments?.getParcelableArrayList<Produto>(KEY)
        if (listaItens != null) {
           //if (listaItens.isEmpty()) {
           //    binding.tvTituloItens.text = VAZIO
           //} else {
                adapter.atualizarLista(listaItens)
                getRecyclerView()
            //}
        }
    }
    private fun getRecyclerView(){
        binding.rvListaProdutos.adapter = adapter
        binding.rvListaProdutos.layoutManager = LinearLayoutManager(context)
    }
    private fun detalheProduto(produto:Produto){
        val bundle = bundleOf(PRODUTO to produto)
        NavHostFragment.findNavController(this).navigate(R.id.action_produtosFragment_to_detalheFragment,bundle)
    }
}