package com.example.marwaadel.test1;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
     ImageAdapter mMovieAdapter;
    ArrayList<String> list= new ArrayList<>();
    GridView g;


    public MainActivityFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setHasOptionsMenu(true);

    }


    private void updateMovie() {
        FetchMovieTask movieTask = new FetchMovieTask();
        movieTask.execute();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)  {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
         g= (GridView)rootView.findViewById(R.id.gridview);

        return  rootView;

    }

    @Override
    public void onStart() {
        super.onStart();
       updateMovie();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_refresh) {
            updateMovie();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    class FetchMovieTask extends AsyncTask<Void, Void, ArrayList<String>> {
        private final String LOG_TAG = FetchMovieTask.class.getSimpleName();

        @Override
        protected ArrayList<String> doInBackground(Void... params) {
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;

            // Will contain the raw JSON response as a string.
            String movieJsonStr = null;

            try {
                URL url = new URL("http://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=fe3e7286750acc526fce7a8cbdc9e7c1");

                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                // Read the input stream into a String
                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    // Nothing to do.
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {

                    buffer.append(line + "\n");
                }

                if (buffer.length() == 0) {
                    // Stream was empty.  No point in parsing.
                    return null;
                }
                movieJsonStr = buffer.toString();

            } catch (IOException e) {
                Log.e(LOG_TAG, "Error ", e);
                return null;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        Log.e(LOG_TAG, "Error closing stream", e);
                    }
                }
            }
            try {
                return getMovieDataFromJson(movieJsonStr);
            } catch (JSONException j) {
                Log.e(LOG_TAG, "JSON Error", j);
            }
            return null;
        }

        private ArrayList<String> getMovieDataFromJson(String forecastJsonStr)
                throws JSONException {
            JSONObject movieJson = new JSONObject(forecastJsonStr);
            JSONArray movieArray = movieJson.getJSONArray("results");
            ArrayList<String> urls = new ArrayList<>();
            for (int i = 0; i < movieArray.length(); i++) {
                JSONObject movie = movieArray.getJSONObject(i);
                urls.add("http://image.tmdb.org/t/p/w185" + movie.getString("poster_path"));
                for (String s:urls){
                    Log.v(LOG_TAG,"Movie entry"+ s);
                }

            }
            return urls;
        }




        @Override
        protected void onPostExecute(ArrayList<String> strings) {
            super.onPostExecute(strings);
            if(strings!=null) {
                mMovieAdapter= new ImageAdapter(getActivity(),strings);
                g.setAdapter(mMovieAdapter);
                mMovieAdapter.notifyDataSetChanged();
            }
        }
    }


    }