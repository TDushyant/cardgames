package com.learnon.games.card.dhaglabaazi;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.List;

public class MainActivity extends Activity
        implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    Context mAppContext;
    Deck deck;
    List<Card> l1;
    List<Card> l2;
    ImageView iv;
    ImageView iv2;
    int iL1 = 0;
    int iL2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAppContext = (Context) this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonOnClickHandler(View v) {
        switch (v.getId()) {
            case R.id.playGame:
                callGameActivity();
                break;
        }
    }

    private void callGameActivity() {
        if (deck == null) {
            deck = new Deck();
            deck.dealAllCards();
            l1 = deck.getPlayer1Deck();
            l2 = deck.getPlayer2Deck();
            iv = (ImageView) findViewById(R.id.imageView);
            iv2 = (ImageView) findViewById(R.id.imageView2);
        }

        if (iL1 >= 25) {
            MainActivity.this.finish();
        }

//        String rStr = l1.get(0).getSuitAsString().toLowerCase() + "_" + l1.get(0).getValueAsString().toLowerCase();
//        String rStr2 = l2.get(0).getSuitAsString().toLowerCase() + "_" + l2.get(0).getValueAsString().toLowerCase();
        //iv.setImageResource(R.drawable.class.getField(rStr).getInt(null));
        iv.setImageResource(l1.get(iL1++).getCardDrawableId(mAppContext));
        iv2.setImageResource(l2.get(iL2++).getCardDrawableId(mAppContext));

//        for (Card c : l1) {
//            iv.setImageResource(c.getCardDrawableId(mAppContext));
//            try {
//                TimeUnit.SECONDS.sleep(5);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        for (Card c : l2) {
//            iv.setImageResource(c.getCardDrawableId(mAppContext));
//            try {
//                TimeUnit.SECONDS.sleep(5);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConnected(Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }
}
