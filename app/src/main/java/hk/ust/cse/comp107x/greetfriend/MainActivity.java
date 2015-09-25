package hk.ust.cse.comp107x.greetfriend;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



import java.util.Calendar;



public class MainActivity extends Activity implements View.OnClickListener {
    Button greetButton;
    TextView time;

    int hour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        greetButton= (Button)findViewById(R.id.greetButton);
        greetButton.setOnClickListener(this);
        //time= (TextView)findViewById(R.id.textTime);
        //String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        //time.setText(currentDateTimeString);

        greetButton= (Button)findViewById(R.id.greetButton);
        greetButton.setOnClickListener(this);

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
    public void onClick(View view) {
        TextView textMessage= (TextView)findViewById(R.id.textMessage);
        EditText editFriendName=(EditText)findViewById(R.id.editFriendName);

        hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);


        String friendName= editFriendName.getText().toString();
        switch(view.getId())
        {
            case R.id.greetButton:
                if(hour>=0 && hour<12){
                textMessage.setText("Good Morning "+friendName+"!");
                }
                else if(hour>=12 && hour<16){
                    textMessage.setText("Good Afternoon "+friendName+"!");
            }
                else if(hour>=16 && hour<20){
                    textMessage.setText("Good Evening "+friendName+"!");
                }

                else if(hour>=20 && hour<=23){
                    textMessage.setText("Good Night "+friendName+"!");
                }
                break;

            default:
                break;
        }
    }
}
