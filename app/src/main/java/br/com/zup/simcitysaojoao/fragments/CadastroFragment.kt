package br.com.zup.simcitysaojoao.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.simcitysaojoao.*
import br.com.zup.simcitysaojoao.databinding.FragmentCadastroBinding
import br.com.zup.simcitysaojoao.model.Produto


class CadastroFragment : Fragment() {
    private lateinit var binding: FragmentCadastroBinding
    private val listaItens = arrayListOf<Produto>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCadastroBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.botaoNovoCadastro.setOnClickListener{
            addItens()
        }
        binding.botaoVerLista.setOnClickListener{
            exibirItens()
        }
        binding.botaoTotal.setOnClickListener{
            exibirTotal()
        }
    }
    private fun addItens(){
        val produto = checarItens()
        if(produto != null){
            listaItens.add(produto)
            Toast.makeText(context, PROD_CAD, Toast.LENGTH_SHORT).show()
            limparCampos()
        } else{
            msgErro()
        }
    }
    private fun exibirItens(){
        val bundle = bundleOf(KEY to listaItens)
        NavHostFragment.findNavController(this).navigate(R.id.action_cadastroFragment_to_produtosFragment,bundle)
    }
    private fun exibirTotal(){
        val bundle = bundleOf(KEY to listaItens)
        NavHostFragment.findNavController(this).navigate(R.id.action_cadastroFragment_to_valorTotalFragment,bundle)
    }
    private fun checarItens():Produto?{
        val nome = binding.etNome.text.toString()
        val qtd = binding.etQtd.text.toString()
        val valor = binding.etValor.text.toString()
        val receita = binding.etReceita.text.toString()
        if(nome.isNotEmpty() && qtd.isNotEmpty() && valor.isNotEmpty() && receita.isNotEmpty()){
            return Produto(nome,qtd.toInt(),valor.toDouble(),receita)
        }
        return null
    }
    private fun limparCampos(){
        binding.etNome.text.clear()
        binding.etQtd.text.clear()
        binding.etValor.text.clear()
        binding.etReceita.text.clear()
    }
    private fun msgErro(){
        binding.etNome.error = ERROR
        binding.etQtd.error = ERROR
        binding.etValor.error = ERROR
        binding.etReceita.error = ERROR
    }
}