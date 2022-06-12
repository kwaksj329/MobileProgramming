package kr.co.company.objdb;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import kr.co.company.objdb.dao.TrianglesDao;
import kr.co.company.objdb.dao.VerticesDao;
import kr.co.company.objdb.database.AppDatabase;
import kr.co.company.objdb.entity.Triangles;
import kr.co.company.objdb.entity.Vertices;


public class MainActivity extends AppCompatActivity {
    private AppDatabase db;
    private static final String DATABASE_NAME = "spheregeom.db";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, DATABASE_NAME).allowMainThreadQueries().build();

    }

    public void readSphere(View view) {
        // delete all the records from vertices.
        // delete all the records from triangles.
        VerticesDao verticesDao = db.verticesDao();
        TrianglesDao trianglesDao = db.trianglesDao();

        verticesDao.deleteAll();
        trianglesDao.deleteAll();

        // open the file R.raw.sphere and get InputStream instance
        // Create a BufferedReader instance

        InputStream inputStream = this.getResources().openRawResource(R.raw.sphere);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String line;

        // Using the readLine() method, read each line from the file and
        // insert the data into the associated table. That is,
        // "v 0.1 0.3 2.5" --> insert into vertices values (null, 0.1, 0.3, 2.5);
        // "f 10 3 23" --> insert into triangles value (null, 10, 3, 23);
        try {
            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(" ");
                if (tokens[0].equals("v")) {
                    Vertices vertices = new Vertices();
                    vertices.x = Float.parseFloat(tokens[1]);
                    vertices.y = Float.parseFloat(tokens[2]);
                    vertices.z = Float.parseFloat(tokens[3]);
                    verticesDao.insertAll(vertices);
                }
                else if (tokens[0].equals("f")){
                    Triangles triangles = new Triangles();
                    triangles.v0 = Integer.parseInt(tokens[1]);
                    triangles.v1 = Integer.parseInt(tokens[2]);
                    triangles.v2 = Integer.parseInt(tokens[3]);
                    trianglesDao.insertAll(triangles);
                }
            }
        }catch (IOException e){

        }
    }

    public void queryDatabase(View view) {
        ListView listView = findViewById(R.id.queryListView);
        VerticesDao verticesDao = db.verticesDao();
        // select vertices with x less than -6 from the table vertices
        // take the three values, x, y, z from each record and output them with Log.v().
        List<Vertices> result = verticesDao.getAllByX();
        ArrayList<String> values = new ArrayList<>();
        for (Vertices vertices : result) {
            values.add("(" + vertices.x + "," + vertices.y + "," + vertices.z + ")");
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
        listView.setAdapter(adapter);
    }
}
