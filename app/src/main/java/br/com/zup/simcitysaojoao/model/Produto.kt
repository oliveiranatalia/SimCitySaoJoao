package br.com.zup.simcitysaojoao.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Produto(private var nome:String,private var qtd:Int, private var valor:Double, private var receita:String
) : Parcelable {
    fun getNome() = this.nome
    fun getQuantidade() = this.qtd
    fun getValor() = this.valor
    fun getReceita() = this.receita
}