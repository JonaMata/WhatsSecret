package me.juanto3.whatssecret;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jonat on 24/02/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private List<Contact> contactList;
    //private View.OnLongClickListener longClickListener;

    public RecyclerViewAdapter(List<Contact> contactList) {
        this.contactList = contactList;
        //this.longClickListener = longClickListener;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_2, parent, false));
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, int position) {
        Contact contact = contactList.get(position);
        holder.nameTextView.setText(contact.getName());
        holder.hashTextView.setText(contact.getHash());
        holder.itemView.setTag(contact);
        //holder.itemView.setOnLongClickListener(longClickListener);
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public void addItems(List<Contact> contactList) {
        this.contactList = contactList;
        notifyDataSetChanged();
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private TextView hashTextView;
        private TextView dateTextView;

        RecyclerViewHolder(View view) {
            super(view);
            nameTextView = (TextView) view.findViewById(android.R.id.text1);
            hashTextView = (TextView) view.findViewById(android.R.id.text2);
        }
    }
}
