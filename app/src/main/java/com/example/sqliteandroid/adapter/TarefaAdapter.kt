package com.jamiltondamasceno.projetolistatarefas.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sqliteandroid.databinding.ItemTarefaBinding
import com.example.sqliteandroid.model.Tarefa


class TarefaAdapter(
    val onClickExcluir: (Int) -> Unit,
    val onClickEditar: (Tarefa) -> Unit
) : RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>() {

    private var listaTarefas: List<Tarefa> = emptyList()

    fun adicionarLista( lista: List<Tarefa> ){
        this.listaTarefas = lista
        notifyDataSetChanged()
    }

    inner class TarefaViewHolder(itemBinding: ItemTarefaBinding)
        : RecyclerView.ViewHolder(itemBinding.root) {

        private val binding: ItemTarefaBinding

        init {
            binding = itemBinding
        }

        fun bind( tarefa: Tarefa ){
            binding.textDescricao.text = tarefa.descricao
            binding.textData.text = tarefa.dataCadastro

            binding.btnExcluir.setOnClickListener {
                onClickExcluir( tarefa.idTarefa )
            }

            binding.btnEditar.setOnClickListener {
                onClickEditar( tarefa )
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemTarefaBinding = ItemTarefaBinding.inflate(
            layoutInflater, parent, false
        )
        return TarefaViewHolder(itemTarefaBinding)
    }

    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {
        val tarefa = listaTarefas[position]
        holder.bind( tarefa )
    }

    override fun getItemCount(): Int {
        return listaTarefas.size
    }

}