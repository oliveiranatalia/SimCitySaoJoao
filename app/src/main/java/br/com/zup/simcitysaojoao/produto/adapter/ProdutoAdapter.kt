package br.com.zup.simcitysaojoao.produto.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.simcitysaojoao.databinding.ProdutoItemBinding
import br.com.zup.simcitysaojoao.model.Produto

class ProdutoAdapter(private var listaItens: MutableList<Produto>,
                     private val clickDetalhe: (produto:Produto) -> Unit
):RecyclerView.Adapter<ProdutoAdapter.ViewHolder>() {

    class ViewHolder(val binding: ProdutoItemBinding) :RecyclerView.ViewHolder(binding.root){
        fun exibirLista(produto: Produto){
            val item = "${produto.getQuantidade()} - ${produto.getNome()}"
            binding.tvItem.text = item
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ProdutoItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = listaItens[position]
        holder.exibirLista(produto)
        holder.binding.cvItemLista.setOnClickListener{
            clickDetalhe(produto)
        }
    }

    override fun getItemCount() = listaItens.size

    fun atualizarLista(novaLista: ArrayList<Produto>) {
        if(listaItens.size == 0 || listaItens == novaLista){
            listaItens = novaLista
        }else{
            listaItens.addAll(novaLista)
        }
        notifyDataSetChanged()
    }
}