package teamgwapro.laundrybear_ptf16.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import teamgwapro.laundrybear_ptf16.R;
import teamgwapro.laundrybear_ptf16.models.Transaction;


/**
 * Created by coderschool on 7/12/16.
 */
public class TransactionsAdapter extends RecyclerView.Adapter<TransactionsAdapter.TransactionViewHolder> {

    List<Transaction> transactions;

    public TransactionsAdapter(List<Transaction> transactions){
        this.transactions = transactions;
    }



    public static class TransactionViewHolder extends RecyclerView.ViewHolder{

        CardView cv;
        TextView transac_id;
        TextView transac_req_date;
        TextView transac_ret_date;
        TextView transac_status;
        TextView transac_shop;
        TextView transac_fee;



        TransactionViewHolder(View view){
            super(view);
            transac_id = (TextView)view.findViewById(R.id.transac_id);
            transac_req_date = (TextView)view.findViewById(R.id.transac_req_date);
            transac_ret_date = (TextView) view.findViewById(R.id.transac_ret_date);
            transac_status = (TextView) view.findViewById(R.id.transac_status);
            transac_shop = (TextView) view.findViewById(R.id.transac_shop);
            transac_fee = (TextView) view.findViewById(R.id.transac_fee);
        }
    }

    @Override
    public TransactionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.partial_transaction,
                parent,false);
        return new TransactionViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TransactionViewHolder holder, int position) {
        Transaction transaction = transactions.get(position);
        holder.transac_id.setText(Integer.toString(transaction.getId()));
        holder.transac_req_date.setText(transaction.getRequestDate());
        holder.transac_ret_date.setText(transaction.getDeliveryDate());
        holder.transac_fee.setText(Integer.toString(transaction.getFee()));
        holder.transac_shop.setText(transaction.getOrders().get(0).getServiceList().get(0).getLaundryShop().getName());
        holder.transac_status.setText(Integer.toString(transaction.getStatus()));
    }

    @Override
    public int getItemCount() {
        return transactions.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}


