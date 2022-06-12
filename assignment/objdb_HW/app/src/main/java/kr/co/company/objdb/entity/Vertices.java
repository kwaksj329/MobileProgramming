package kr.co.company.objdb.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Vertices {
    @PrimaryKey(autoGenerate = true)
    public int uid;
    public float x;
    public float y;
    public float z;
}
