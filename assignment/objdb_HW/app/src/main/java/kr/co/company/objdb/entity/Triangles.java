package kr.co.company.objdb.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Triangles {
    @PrimaryKey(autoGenerate = true)
    public int uid;
    public int v0;
    public int v1;
    public int v2;
}