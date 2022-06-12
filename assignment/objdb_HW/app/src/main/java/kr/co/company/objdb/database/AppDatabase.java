package kr.co.company.objdb.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import kr.co.company.objdb.dao.TrianglesDao;
import kr.co.company.objdb.dao.VerticesDao;
import kr.co.company.objdb.entity.Triangles;
import kr.co.company.objdb.entity.Vertices;

@Database(entities = {Vertices.class, Triangles.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract VerticesDao verticesDao();
    public abstract TrianglesDao trianglesDao();
}