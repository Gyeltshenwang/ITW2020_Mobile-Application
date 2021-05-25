package com.example.todo21;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SympleAsyncTask  extends AsyncTask<Void,Void,String> {
    private WeakReference<TextView>mTextView;

    public SympleAsyncTask(TextView tv) {
        mTextView = new WeakReference<>(tv);
    }

    @Override
    protected String doInBackground(Void... voids) {
        Random r = new Random();
        int n = r.nextInt(11);
        int s = n*200;
        try{
            Thread.sleep(s);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        return "AWAKE AT LAST AFTER SLEEPING FOR "+ s + "MILLISECOND";
    }

    @Override
    protected void onPostExecute(String s) {
        //super.onPostExecute(s);
        mTextView.get().setText(s);
    }
}
