package helloworld.demo.com.simplechat;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by shyamramesh on 06/02/18.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder>
{
    Context context = null;
    ArrayList<MessageModel> chatList = null;
    private final int SENT_MESSAGE = 0,RECEIVED_MESSAGE =1;
    LayoutInflater layoutInflater;

    public ChatAdapter(Context context,ArrayList<MessageModel>chatList)
    {
        this.context = context;
        this.chatList = chatList;
    }

    @Override
    public int getItemViewType(int position)
    {
        if(chatList.get(position).getSender())
        {
            return SENT_MESSAGE;
        }
        else
        {
            return RECEIVED_MESSAGE;
        }
    }

    @Override
    public ChatAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = null;
        switch(viewType)
        {
            case SENT_MESSAGE:
                view = layoutInflater.from(parent.getContext()).inflate(R.layout.send_message,parent,false);
                break;
            case RECEIVED_MESSAGE:
                view = layoutInflater.from(parent.getContext()).inflate(R.layout.receive_message,parent,false);
                break;
        }
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChatAdapter.ViewHolder holder,int position)
    {
        MessageModel model =chatList.get(position);
        holder.texttosend.setText(model.getMessage());
        holder.date.setText(model.getTime());
    }
    @Override
    public int getItemCount()
    {
        return chatList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView texttosend;
        TextView date;
        public ViewHolder(View itemView)
        {
            super(itemView);
            texttosend = (TextView)itemView.findViewById(R.id.message);
            date = (TextView)itemView.findViewById(R.id.date);
        }
    }
}

