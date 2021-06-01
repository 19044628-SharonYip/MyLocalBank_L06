package sg.edu.rp.c346.id19044628.mylocalbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    Button btnDBS, btnOCBC, btnUOB;
    String buttonClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDBS=findViewById(R.id.btnDBS);
        btnOCBC=findViewById(R.id.btnOCBC);
        btnUOB=findViewById(R.id.btnUOB);

        registerForContextMenu(btnDBS);
        registerForContextMenu(btnOCBC);
        registerForContextMenu(btnUOB);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0, "Website");
        menu.add(0,1,1,"Contact the bank");
        menu.add(0,2,2,"Add to Favourites");

        if (v==btnDBS)
        {
            buttonClicked="btnDBS";
        }
        else if(v==btnOCBC)
        {
            buttonClicked="btnOCBC";
        }
        else if(v==btnUOB)
        {
            buttonClicked="btnUOB";
        }
    }

    public boolean onContextItemSelected(MenuItem item) {

        if(buttonClicked.equalsIgnoreCase("btnDBS")){
            if(item.getItemId()==0) { //check whether the selected menu item ID is 0
                //code for action
                //Toast.makeText(MainActivity.this, "English is chosen", Toast.LENGTH_SHORT).show();
                Intent intentWebDBS= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg/index/default.page"));
                startActivity(intentWebDBS);
                return true; //menu item successfully handled
            }
            else if(item.getItemId()==1)
            {
                //Toast.makeText(MainActivity.this,"Italian is chosen", Toast.LENGTH_SHORT).show();

                Intent intentCall= new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 1800 111 1111"));
                startActivity(intentCall);
                return true;
            }
            else if (item.getItemId()==2)
            {
                if (btnDBS.getCurrentTextColor()== getResources().getColor(R.color.white))
                {

                    btnDBS.setTextColor(getResources().getColor(R.color.black));

                }
                else if (btnDBS.getCurrentTextColor() == getResources().getColor(R.color.black))
                {
                    btnDBS.setTextColor(getResources().getColor(R.color.white));
                }
            }
        }
        else if(buttonClicked.equalsIgnoreCase("btnOCBC"))
        {
            if(item.getItemId()==0) { //check whether the selected menu item ID is 0
                //code for action
                //Toast.makeText(MainActivity.this, "English is chosen", Toast.LENGTH_SHORT).show();
                Intent intentWebOCBC= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intentWebOCBC);
                return true; //menu item successfully handled
            }
            else if(item.getItemId()==1)
            {
                //Toast.makeText(MainActivity.this,"Italian is chosen", Toast.LENGTH_SHORT).show();
                Intent intentCall= new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 1800 363 3333"));
                startActivity(intentCall);
                return true;
            }
            else if (item.getItemId()==2)
            {
                if (btnOCBC.getCurrentTextColor()== getResources().getColor(R.color.white))
                {

                    btnOCBC.setTextColor(getResources().getColor(R.color.black));

                }
                else if (btnOCBC.getCurrentTextColor() == getResources().getColor(R.color.black))
                {
                    btnOCBC.setTextColor(getResources().getColor(R.color.white));
                }
            }
        }
        else if(buttonClicked.equalsIgnoreCase("btnUOB"))
        {
            if(item.getItemId()==0) { //check whether the selected menu item ID is 0
                //code for action
                //Toast.makeText(MainActivity.this, "English is chosen", Toast.LENGTH_SHORT).show();
                Intent intentWebUOB= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intentWebUOB);
                return true; //menu item successfully handled
            }
            else if(item.getItemId()==1)
            {
                //Toast.makeText(MainActivity.this,"Italian is chosen", Toast.LENGTH_SHORT).show();
                Intent intentCall= new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 1800 222 2121"));
                startActivity(intentCall);
                return true;
            }
            else if (item.getItemId()==2)
            {
                if (btnUOB.getCurrentTextColor()== getResources().getColor(R.color.white))
                {

                    btnUOB.setTextColor(getResources().getColor(R.color.black));

                }
                else if (btnUOB.getCurrentTextColor() == getResources().getColor(R.color.black))
                {
                    btnUOB.setTextColor(getResources().getColor(R.color.white));
                }
            }
        }

        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            btnDBS.setText("DBS");
            btnOCBC.setText("OCBC");
            btnUOB.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            btnDBS.setText("星展银行 ");
            btnOCBC.setText("华侨银行");
            btnUOB.setText("大华银行");
            return true;
        } else {
            Toast.makeText(MainActivity.this,"Error translation", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

}