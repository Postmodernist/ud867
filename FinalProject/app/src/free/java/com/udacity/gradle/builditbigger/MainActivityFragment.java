package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.alexbaryzhikov.presenter.DisplayJokeActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.backend.jokesApi.JokesApi;

import java.io.IOException;
import java.lang.ref.WeakReference;

public class MainActivityFragment extends Fragment {

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_main, container, false);

    AdView adView = root.findViewById(R.id.adView);
    // Create an ad request. Check logcat output for the hashed device ID to
    // get test ads on a physical device. e.g.
    // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
    AdRequest adRequest = new AdRequest.Builder()
        .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
        .build();
    adView.loadAd(adRequest);

    Button jokeButton = root.findViewById(R.id.tell_joke_button);
    jokeButton.setOnClickListener(v -> new EndpointsAsyncTask(this).execute());

    return root;
  }

  public void tellJoke(String joke) {
    Intent intent = new Intent(getActivity(), DisplayJokeActivity.class);
    intent.putExtra(DisplayJokeActivity.JOKE_ID, joke);
    startActivity(intent);
  }

  private static class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {

    private final WeakReference<MainActivityFragment> mainActivityFragment;
    private SimpleIdlingResource idlingResource;
    private JokesApi jokesApiService;

    EndpointsAsyncTask(MainActivityFragment mainActivityFragment) {
      this.mainActivityFragment = new WeakReference<>(mainActivityFragment);
      MainActivity mainActivity = (MainActivity) mainActivityFragment.getActivity();
      if (mainActivity != null) {
        idlingResource = mainActivity.getIdlingResource();
      }
    }

    @Override
    protected String doInBackground(Void... voids) {
      idlingResource.setIdleState(false);
      if (jokesApiService == null) {
        jokesApiService = new JokesApi.Builder(AndroidHttp.newCompatibleTransport(),
            new AndroidJsonFactory(), null)
            .setRootUrl("http://10.0.2.2:8080/_ah/api/")
            .setGoogleClientRequestInitializer(abstractGoogleClientRequest ->
                abstractGoogleClientRequest.setDisableGZipContent(true))
            .build();
      }
      try {
        return jokesApiService.provideJoke().execute().getJoke();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return null;
    }

    @Override
    protected void onPostExecute(String s) {
      if (mainActivityFragment.get() != null) {
        if (!TextUtils.isEmpty(s)) {
          mainActivityFragment.get().tellJoke(s);
        } else {
          Context context = mainActivityFragment.get().getContext();
          Toast.makeText(context, "Backend is not responding", Toast.LENGTH_LONG).show();
        }
      }
      idlingResource.setIdleState(true);
    }
  }
}
