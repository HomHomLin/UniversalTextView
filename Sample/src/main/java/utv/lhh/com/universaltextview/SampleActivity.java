package utv.lhh.com.universaltextview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.lhh.utv.views.ImageEditText;
import com.lhh.utv.views.ImageTextView;


public class SampleActivity extends ActionBarActivity {

    private ImageTextView mImageTextView;
    private ImageEditText mImageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        mImageTextView = (ImageTextView)this.findViewById(R.id.utv_imagetextView);
        mImageTextView.appendText(getResources().getString(R.string.hello_utv));
        mImageTextView.appendImage(R.mipmap.ic_launcher);

        mImageEditText = (ImageEditText)this.findViewById(R.id.utv_imageedittext);
        mImageEditText.appendText(getResources().getString(R.string.hello_utv));
        mImageEditText.appendImage(R.mipmap.ic_launcher);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sample, menu);
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
}
