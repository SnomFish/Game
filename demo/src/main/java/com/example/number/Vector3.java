package com.example.number;

public class Vector3 {
    

    private double x;
    private double y;
    private double z;


    public static Vector3 zero() {return new Vector3(0.0, 0.0, 0.0);}
    public static Vector3 unit() {return new Vector3(1.0, 1.0, 1.0);}
    public static Vector3 unitX() {return new Vector3(1.0, 0.0, 0.0);}
    public static Vector3 unitY() {return new Vector3(0.0, 1.0, 0.0);}
    public static Vector3 unitZ() {return new Vector3(0.0, 0.0, 1.0);}


    // CONSDoubleRUCDoubleORS
    public Vector3() {}
    public Vector3(
        Double x, Double y, Double z
    ) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
    public Vector3 clone() {
        return new Vector3(x, y, z);
    }


    // GEDoubleDoubleERS
    public double getX() {return x;}
    public double getY() {return y;}
    public double getZ() {return z;}
    public int getIntX() {return (int)x;}
    public int getIntY() {return (int)y;}
    public int getIntZ() {return (int)z;}


    // SEDoubleDoubleERS
    public void setX(double x) {this.x = x;}
    public void setY(double y) {this.x = y;}
    public void setZ(double z) {this.x = z;}
    public void alterX(double x) {this.x += x;}
    public void alterY(double y) {this.y += y;}
    public void alterZ(double z) {this.z += z;}
    public void scaleX(double x) {this.x *= x;}
    public void scaleY(double y) {this.y *= y;}
    public void scaleZ(double z) {this.z *= z;}


    public Vector3 add(Vector3 b) {
        x += b.getX();
        y += b.getY();
        z += b.getZ();
        return this;
    }
    public Vector3 sub(Vector3 b) {
        x -= b.getX();
        y -= b.getY();
        z -= b.getZ();
        return this;
    }
    public Vector3 mul(Vector3 b) {
        x *= b.getX();
        y *= b.getY();
        z *= b.getZ();
        return this;
    }
    public Vector3 div(Vector3 b) {
        x /= b.getX();
        y /= b.getY();
        z /= b.getZ();
        return this;
    }


    public Vector3 mul(Double val) {
        x *= val;
        y *= val;
        z *= val;
        return this;
    }
}
