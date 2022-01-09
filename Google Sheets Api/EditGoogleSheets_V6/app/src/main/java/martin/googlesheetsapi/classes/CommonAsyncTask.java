package martin.googlesheetsapi.classes;

import android.os.AsyncTask;

import martin.googlesheetsapi.interfaces.CommonFunctionInterface;


public class CommonAsyncTask extends AsyncTask {

    CommonFunctionInterface commonFunctionInterface;

    public CommonAsyncTask(CommonFunctionInterface commonFunctionInterface) {
        this.commonFunctionInterface = commonFunctionInterface;
        execute();
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        commonFunctionInterface.apply();
        return null;
    }


}
