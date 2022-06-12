package kr.co.company.objdb.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import kr.co.company.objdb.entity.Triangles;
import kr.co.company.objdb.entity.Vertices;

@Dao
public interface TrianglesDao {
    @Query("SELECT * FROM Triangles")
    List<Triangles> getAll();
    @Insert
    void insertAll(Triangles... triangles);
    @Query("DELETE FROM triangles")
    void deleteAll();
}
