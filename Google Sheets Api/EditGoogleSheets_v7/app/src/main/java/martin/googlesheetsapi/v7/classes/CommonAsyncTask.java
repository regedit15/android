package martin.googlesheetsapi.v7.classes;

import android.os.AsyncTask;

import martin.googlesheetsapi.v7.interfaces.CommonFunctionInterface;


public class CommonAsyncTask extends AsyncTask {

    CommonFunctionInterface functionDoInBackground;
    CommonFunctionInterface functionOnPostExecute;

    public CommonAsyncTask(CommonFunctionInterface functionDoInBackground) {
        this.functionDoInBackground = functionDoInBackground;
        execute();
    }

    public CommonAsyncTask(CommonFunctionInterface functionDoInBackground, CommonFunctionInterface functionOnPostExecute) {
        this.functionDoInBackground = functionDoInBackground;
        this.functionOnPostExecute = functionOnPostExecute;
        execute();
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        functionDoInBackground.execute();
        return null;
    }


    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        if (functionOnPostExecute != null) {
            functionOnPostExecute.execute();
        }
    }

}
