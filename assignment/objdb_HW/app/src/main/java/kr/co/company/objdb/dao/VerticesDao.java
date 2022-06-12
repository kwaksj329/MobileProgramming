package kr.co.company.objdb.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import kr.co.company.objdb.entity.Vertices;

@Dao
public interface VerticesDao {
    @Query("SELECT * FROM Vertices")
    List<Vertices> getAll();
    @Query("SELECT * FROM Vertices WHERE x < -6;")
    List<Vertices> getAllByX();
    @Insert
    void insertAll(Vertices... vertices);
    @Query("DELETE FROM vertices")
    void deleteAll();
}
