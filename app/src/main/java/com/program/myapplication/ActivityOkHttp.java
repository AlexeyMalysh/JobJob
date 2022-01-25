package com.program.myapplication;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class ActivityOkHttp {
    SharedPreferences sPref;
    final String SAVED_TEXT = "saved_text";

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        ActivityOkHttp.id = id;
    }

    private static int id=0;

    public static String getVacancy() {
        return vacancy;
    }

    public static void setVacancy(String vacancy) {
        ActivityOkHttp.vacancy = vacancy;
    }

    private static String vacancy = "dd";
    private static String vacancyOne = "wffw";

    public static String getVacancyOne() {
        return vacancyOne;
    }

    public static void setVacancyOne(String vacancyOne) {
        ActivityOkHttp.vacancyOne = vacancyOne;
    }

    private String TAG = ActivityOkHttp.class.getSimpleName();

    private Button getb;
    private Button postb;
    private Button getqueryb;
    Model model  = Model.getInstance();
    private TextView respone;



    public void getHttp() {
        //instantiate async task which call service using OkHttp in the background
        // and execute it passing required parameter to it
        //get http request using okhttp
        new OkHttpAync().execute(this, "get", "");


    }public void

    getZ() {
        //instantiate async task which call service using OkHttp in the background
        // and execute it passing required parameter to it
        //get http request using okhttp
        new OkHttpAync().execute(this, "getZ", "");


    }

    public void getQueryHttp(String userData) {
        //same async task is used to call different services
        //request type is sent as parameter to async task to identify which service to call
        //get http request with query string using okhttp

        new OkHttpAync().execute(this, "getquery", userData);
    }

    public void postHttpEmployee(String userData) {
        //post http request using okhttp

        new OkHttpAync().execute(this, "postEmployee", userData);
    }
    public void postHttpEmployer(String userData) {
        //post http request using okhttp

        new OkHttpAync().execute(this, "postEmployer", userData);
    }

    private class OkHttpAync extends AsyncTask<Object, Void, Object> {

        private String TAG = OkHttpAync.class.getSimpleName();
        private Context contx;
        public final String urlEmployee = "http://65.108.86.158/respond-offer";

        public final String urlEmployer = "http://65.108.86.158/save_cv";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Object doInBackground(Object... params) {

            String requestType = (String) params[1];
            String requestParam = (String) params[2];


            Log.e(TAG, "processing http request in async task");

            if ("get".equals(requestType)) {
                Log.e(TAG, "processing get http request using OkHttp");
                return getHttpResponse();
            } else if ("getquery".equals(requestType)) {
                Log.e(TAG, "processing get http request with query parameters using OkHttp");
                return getQueryHttpResponse(requestParam);
            } else if ("postEmployee".equals(requestType)) {
                Log.e(TAG, "processing post http request using OkHttp postEmployee");
                //  return postHttpResponse(requestParam);
                return postJson(requestParam, urlEmployee);
            }
            else if ("postEmployer".equals(requestType)) {
                Log.e(TAG, "processing post http request using OkHttp postEmployerrr");
                //  return postHttpResponse(requestParam);
                return postJson(requestParam, urlEmployer);
            }else if ("getZ".equals(requestType)) {
                Log.e(TAG, "processing post http request using OkHttp postEmployerrr");
                //  return postHttpResponse(requestParam);
                return getOtv();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Object result) {
            super.onPostExecute(result);

            if (result != null) {
                Log.e(TAG, "populate UI after response from service using OkHttp client");
           //     respone.setText((String) result);
//                Log.e(TAG, (String) result);
            }
        }
    }

    public Object getHttpResponse() {
        OkHttpClient httpClient = new OkHttpClient();

        String url = "http://65.108.86.158/offers";
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = null;
        try {
            response = httpClient.newCall(request).execute();
            Log.i("Addddddd",response.body().string());
            setVacancy(response.body().toString());
            Log.e("fewf", getVacancy());

            return response.body();
        } catch (IOException e) {
            Log.e(TAG, "error in getting response get request okhttp");
        }
        return null;
    }

    public Object getQueryHttpResponse(String requestParam) {
        OkHttpClient httpClient = new OkHttpClient();
        String url = "http://www.zoftino.com/api/saveFavorite";

        HttpUrl.Builder httpBuider = HttpUrl.parse(url).newBuilder();
        httpBuider.addQueryParameter("coupon", requestParam);

        Request request = new Request.Builder().url(httpBuider.build()).build();

        Response response = null;
        try {
            response = httpClient.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            Log.e(TAG, "error in getting response get request with query string okhttp");
        }
        return null;
    }
    public Object postJson(String userData, String url)  {





        OkHttpClient httpClient = new OkHttpClient();

//
//        List<NameValuePair> nameValuePairList = new ArrayList<NameValuePair>();
//        nameValuePairList.add(new BasicNameValuePair("service_name", "caltat_black"));
//        nameValuePairList.add(new BasicNameValuePair("uuid", "caltat_black"));
//        nameValuePairList.add(new BasicNameValuePair("destination_url", "caltat_black"));
//        nameValuePairList.add(new BasicNameValuePair("domain", "caltat_black"));

//        RequestBody requestBody = new MultipartBody.Builder()
//                .setType(MultipartBody.FORM)
//                .addFormDataPart("service_name", "a")
//                .addFormDataPart("uuid", "1")
//                .addFormDataPart("destination_url", "1")
//                .addFormDataPart("domain", "1")
//                .build();

//        Queue<Map<String, String >> queue = new SynchronousQueue<>();
//        queue.add(new HashMap<>(new))


        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(MediaType.parse("application/json"), userData))
                .build();
//        Map<String, String> map  = new HashMap<String, String>();
//        map.put("service_name", "a");
//        map.put("sss", "ddd");

//        Request request = new okhttp3.Request.Builder()
//                .url("http://135.181.154.23:8030/api/link")
//                .post(requestBody)
//                .build();
        Response response = null;
        try {
            response = httpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                Log.e(TAG, "Got response from server for JSON post using OkHttp ");

                Log.e("test1", String.valueOf(response.code()));
                Log.e("test3",userData);
                String result = response.body().string();
                JSONObject jObject = new JSONObject(result);
                int aJsonInteger = jObject.getInt("id");

                Model.getInstance().setId(aJsonInteger);
                Log.e("test4", String.valueOf(Model.getInstance().getId()));
             setId(aJsonInteger);
             Log.e("test5", String.valueOf(getId()));

//                sPref = getPreferences(MODE_PRIVATE);
//                SharedPreferences.Editor ed = sPref.edit();
//                ed.putString(SAVED_TEXT, etText.getText().toString());
//                ed.commit();
//
                return aJsonInteger;

            }
            else{
                Log.e("test", response.body().string());
                Log.e("test1", String.valueOf(response.code()));
                Log.e("test3",userData);
            }

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return null;

//        Response response = null;
//        try {
//            response = httpClient.newCall(request).execute();
//            Log.e("test", response.body().string());
//            Log.e("test1", String.valueOf(response.code()));
////            Log.e("test2",pairs.toArray().toString());
//            return response.body().string();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }



//        final MediaType mediaType
//                = MediaType.parse("application/json");
//
//        OkHttpClient httpClient = new OkHttpClient();
//        String url = "http://135.181.154.23:8030/api/link";
//
//        String jsonStr = "{\n" +
//                "    \"service_name\": \"caltat_black\",\n" +
//                "    \"uuid\": \"string\",\n" +
//                "    \"destination_url\": \"string\",\n" +
//                "    \"domain\": \"string\"\n" +
//                "  }";
//
//        //post json using okhttp
//        Request request = new Request.Builder()
//                .url(url)
//                .post(RequestBody.create(mediaType, jsonStr))
//                .build();
//        Response response = null;
//        try {
//            response = httpClient.newCall(request).execute();
//            if (response.isSuccessful()) {
//                Log.e(TAG, "Got response from server for JSON post using OkHttp ");
//                Log.e(TAG, response.peekBody(2048).string());
//                return response.body().string();
//            }
//            else{
//                response.message();
//                Log.e(TAG, "Errrror");
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            Log.e(TAG, "error in getting response for json post request okhttp");
//        }
//        return null;
    }

    public Object postHttpResponse(String requestParam) {
        OkHttpClient httpClient = new OkHttpClient();
        String url = "http://135.181.154.23:8030/api/link";
        //String url = "https://www.zoftino.com/api/saveFavorite";

        RequestBody formBody = new FormBody.Builder()
                .add("caltat_black", requestParam
                )
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        Response response = null;
        try {
            response = httpClient.newCall(request).execute();
            Log.i(TAG, response.body().string());

            if (response.isSuccessful()) {
                Log.e(TAG, "Got response from server using OkHttp ");
                return response.body().string();

            }
            else{
                Log.i(TAG, response.message());
            }

        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG, "error in getting response post request okhttp");
        }
        return null;

    }
    public void getAsyncCall(){
        OkHttpClient httpClient = new OkHttpClient();
        String url = "http://www.zoftino.com/api/storeOffers";
        Request request = new Request.Builder()
                .url(url)
                .addHeader("CLIENT", "AD")
                .addHeader("USERID", "343")
                .build();

        //okhttp asynchronous call
        httpClient.newCall(request).enqueue(new Callback() {
            @Override public void onFailure(Call call, IOException e) {
                Log.e(TAG, "error in getting response using async okhttp call");
            }

            @Override public void onResponse(Call call, Response response) throws IOException {
                ResponseBody responseBody = response.body();
                if (!response.isSuccessful()) {
                    throw new IOException("Error response " + response);
                }

                Log.i(TAG,responseBody.string());
            }
        });
    }

    public void multipart(){
        OkHttpClient httpClient = new OkHttpClient();
        //creates multipart http requests
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("purpose", "xyz store coupons")
                .addFormDataPart("xml", "xyz_store_coupons.xml",
                        RequestBody.create(MediaType.parse("application/xml"), new File("website/static/xyz_store_coupons.xml")))
                .build();

        Request request = new Request.Builder()
                .url("https://dummy....")
                .post(requestBody)
                .build();
        Response response = null;
        try {
            response = httpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                Log.e(TAG, "Got response from server for multipart request using OkHttp ");
            }

        } catch (IOException e) {
            Log.e(TAG, "error in getting response for multipart request okhttp");
        }
    }

    protected String getOtv() {


        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL("http://65.108.86.158/offers");
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();


            InputStream stream = connection.getInputStream();

            reader = new BufferedReader(new InputStreamReader(stream));

            StringBuffer buffer = new StringBuffer();
            String line = "";

            while ((line = reader.readLine()) != null) {
                buffer.append(line+"\n");
                Log.e("Response: ", "> " + line);   //here u ll get whole response...... :-)

            }
            setVacancy(buffer.toString());
            Log.e("httttp", getVacancy());

            return buffer.toString();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }  finally {
            if (connection != null) {
                connection.disconnect();
            }
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    protected String getOtvOne(String numberOffer) {


        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL("http://65.108.86.158/offers/" + numberOffer);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();


            InputStream stream = connection.getInputStream();

            reader = new BufferedReader(new InputStreamReader(stream));

            StringBuffer buffer = new StringBuffer();
            String line = "";

            while ((line = reader.readLine()) != null) {
                buffer.append(line+"\n");
                Log.e("Response: ", "> " + line);   //here u ll get whole response...... :-)

            }
            setVacancyOne(buffer.toString());
            Log.e("htttdwqdtp", getVacancyOne());

            return buffer.toString();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }  finally {
            if (connection != null) {
                connection.disconnect();
            }
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


}
