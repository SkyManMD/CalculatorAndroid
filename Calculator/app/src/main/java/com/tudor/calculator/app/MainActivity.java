package com.tudor.calculator.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tudor.calculator.app.calculateexpresionlib.*;

public class MainActivity extends ActionBarActivity {

    TextView textView1;
    TextView textView2;

    Boolean operationIsSelected = false;
    Boolean pointIsSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);

        textView1.setText("");
        textView2.setText("");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setOperation(String operation) {
        if(!operationIsSelected) {
            operationIsSelected = true;
            pointIsSelected = false;
            textView1.setText(textView1.getText() + operation);
        }
    }

    public void btnMulClick(View view) {
        setOperation("*");
    }

    public void btnDivClick(View view) {
        setOperation("/");
    }

    public void btnAddClick(View view) {
        setOperation("+");
    }

    public void btnDifClick(View view) {
        setOperation("-");
    }

    public void btnPoint(View view) {
      if(!pointIsSelected){
          pointIsSelected = true;
          textView1.setText(textView1.getText() + ".");
      }
    }

    public void btnEqualClick(View view) {
        double result = 0;
        try {
            Expr expr = Parser.parse(textView1.getText().toString());
            result = expr.value();
        } catch (SyntaxException e) {
            e.printStackTrace();
        }
        textView2.setText(String.valueOf(result));
    }

    public void btnClear(View view) {
        textView1.setText("");
        textView2.setText("");
        operationIsSelected = false;
        pointIsSelected = false;
    }

    public void btnDelete1Char(View view) {
        String expresion = textView1.getText().toString();
        if(expresion.length() > 0) {
            expresion = expresion.substring(0, expresion.length() - 1);
            textView1.setText(expresion);
        }
    }

    public void btnParenthesisOpen(View view) {
        textView1.setText(textView1.getText() + "(");
    }

    public void btnParenthesisClose(View view) {
        textView1.setText(textView1.getText() + ")");
    }

    public void btn0Click(View view) {
        setNumbers(0);
    }

    public void btn1Click(View view) {
        setNumbers(1);
    }

    public void btn2Click(View view) {
        setNumbers(2);
    }

    public void btn3Click(View view) {
        setNumbers(3);
    }

    public void btn4Click(View view) {
        setNumbers(4);
    }

    public void btn5Click(View view) {
        setNumbers(5);
    }

    public void btn6Click(View view) {
        setNumbers(6);
    }

    public void btn7Click(View view) {
        setNumbers(7);
    }

    public void btn8Click(View view) {
        setNumbers(8);
    }

    public void btn9Click(View view) {
        setNumbers(9);
    }

    private void setNumbers(int nr) {
        textView1.setText(textView1.getText() + String.valueOf(nr));
        operationIsSelected = false;
    }



}
