package martin.googlesheetsapi;

import android.os.AsyncTask;

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
