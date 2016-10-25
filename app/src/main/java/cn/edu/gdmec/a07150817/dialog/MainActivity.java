package cn.edu.gdmec.a07150817.dialog;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    private TextView tv1,tv2,tv3;
    private EditText et1,et2,et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.charactor);
        tv2 = (TextView) findViewById(R.id.uidate);
        tv3 = (TextView) findViewById(R.id.uitime);
        et1 = (EditText) findViewById(R.id.charactorE);
        et2 = (EditText) findViewById(R.id.uidateE);
        et3 = (EditText) findViewById(R.id.uitimeE);
    }
    public void charactorpickerdialog(View v){
        final String option = "123456789!@#$%^&*()";
        CharacterPickerDialog cpd = new CharacterPickerDialog(this,new View(this),null,option,false){
            @Override
            //这里为什么要加个onclick方法
            //是不是字符选择框的点击，我想是的
            public void onClick(View v) {
                //这里写的应该是字符添加到Textview里的代码
                //下一句有点复杂，应该是把字符选择框里的值取出来转为String类型
                tv1.append(((Button)v).getText().toString());
                et1.append(((Button)v).getText().toString());
                if (((Button)v).getText().toString().equals("")){
                    dismiss();
                }
            }
        };
        cpd.show();
    }
    public void uidatepickerdialog (View v){
        DatePickerDialog dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                tv2.setText("日期"+year+"-"+(month+1)+"-"+dayOfMonth);
                et2.setText("日期2"+year+"-"+(month+1)+"-"+dayOfMonth);
            }
        },2016,10,25);
        dpd.show();
    }
    public void uitimepickerdialog(View v){
        TimePickerDialog tpd = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                tv3.setText(hourOfDay+"时"+minute);
                et3.setText(hourOfDay+"时"+minute);
            }
        },9,15,true);//有趣的是在这里加上具体的时间参数的话，就不会报错
         //貌似是api的版本不够高，我这个api的版本是23需要的是24，上面那个方法也是同样的情况
        tpd.show();
    }
    public void progessdialog(View v){
        //ProgessDialog不同new
        final ProgressDialog pg = ProgressDialog.show(this,"祈祷仪式","少女祈祷中",true);
        new Thread(){
            public void run(){
                try {
                    sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    pg.dismiss();
                }
            }
        }.start();
    }
}