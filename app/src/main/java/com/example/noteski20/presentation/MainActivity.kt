package com.example.noteski20.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.noteski20.R

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: NotesListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        setupRecycleView()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.noteList.observe(this) {
            adapter.submitList(it)
        }
    }

    private fun setupRecycleView() {
        val rvNoteList = findViewById<RecyclerView>(R.id.rv_notes_list)
        adapter = NotesListAdapter()
        rvNoteList.adapter = adapter
        with(rvNoteList) {
            recycledViewPool.setMaxRecycledViews(
                NotesListAdapter.ENABLED_LAYOUT,
                NotesListAdapter.MAX_POOL_SIZE
            )
            recycledViewPool.setMaxRecycledViews(
                NotesListAdapter.DISABLED_LAYOUT,
                NotesListAdapter.MAX_POOL_SIZE
            )
        }
        setupLongClickListener()
        setupClickListener()
        setupSwipeListener(rvNoteList)
    }

    private fun setupSwipeListener(rvNoteList: RecyclerView) {
        val callback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val item = adapter.currentList[viewHolder.adapterPosition]
                viewModel.deleteNoteItem(item)
            }

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }
        }
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(rvNoteList)
    }

    private fun setupClickListener() {
        adapter.onNoteItemClickListener = {
            Toast.makeText(this, "Soon...", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupLongClickListener() {
        adapter.onNoteItemLongClickListener = {
            viewModel.changeStateItem(it)
        }
    }
}