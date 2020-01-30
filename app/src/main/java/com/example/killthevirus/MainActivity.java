package com.example.killthevirus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //now create a model class
        //now create Myholder class
        //now create Adapter class
        //now in the main class
    mRecyclerView=findViewById(R.id.recyclerView);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(this));//thus will set recyclerview in linearlayout
    myAdapter=new MyAdapter(this,getMyList());
    mRecyclerView.setAdapter(myAdapter);


    }
    private  ArrayList<model>getMyList(){
        ArrayList<model> models=new ArrayList<>();
        model m=new model();
        m.setTitle("facebook");
        m.setDescription("This is facebook");
        //first add some images in drawable folder
        m.setImg(R.drawable.facebook);
        models.add(m);


        m=new model();
        m.setTitle("watsapp");
        m.setDescription("This is watsapp");
        //first add some images in drawable folder
        m.setImg(R.drawable.whatsapp);
        models.add(m);


        m=new model();
        m.setTitle("youtube");
        m.setDescription("This is youtube");
        //first add some images in drawable folder
        m.setImg(R.drawable.youtube);
        models.add(m);


        m=new model();
        m.setTitle("spotify");
        m.setDescription("This is spotify");
        //first add some images in drawable folder
        m.setImg(R.drawable.spotify);
        models.add(m);
        return models;
        //as we can see recyclerview width is not same because i am using wrap content in row file

    }
    //first create an interface class
    //now go to myholder class
    //now create another activity(empty activity)
    //->now we will see how to sort recyclerview items with title
    //first create a menu for sorting
    //now create menu function
    //first function onoptionMenu which inflate our menu
    //now create option selected function


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return true;
     }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.sorting){
            sortDailog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void sortDailog() {
        String[] options={"Ascending","Descending"};
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
    }
}
