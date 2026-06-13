package github.snomfish.number;

public class Vector3 {
    

    private double x, y, z;


    public static Vector3 zero() {return new Vector3(0, 0, 0);}
    public static Vector3 unit() {return new Vector3(1, 1, 1);}
    public static Vector3 unitX() {return new Vector3(1, 0, 0);}
    public static Vector3 unitY() {return new Vector3(0, 1, 0);}
    public static Vector3 unitZ() {return new Vector3(0, 0, 1);}

    public static Vector3 add(Vector3 a, Vector3 b) {
        return new Vector3(
            a.getX() + b.getX(),
            a.getY() + b.getY(),
            a.getZ() + b.getZ());
    }
    public static Vector3 sub(Vector3 a, Vector3 b) {
        return new Vector3(
            a.getX() - b.getX(),
            a.getY() - b.getY(),
            a.getZ() - b.getZ());
    }
    public static Vector3 mul(Vector3 a, Vector3 b) {
        return new Vector3(
            a.getX() * b.getX(),
            a.getY() * b.getY(),
            a.getZ() * b.getZ());
    }
    public static Vector3 div(Vector3 a, Vector3 b) {
        return new Vector3(
            a.getX() / b.getX(),
            a.getY() / b.getY(),
            a.getZ() / b.getZ());
    }


    public Vector3() {}
    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }


    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
    public Vector3 copy() {
        return new Vector3(x, y, z);
    }


    // GETTERS
    public double getX() {return x;}
    public double getY() {return y;}
    public double getZ() {return z;}
    
    public int getIntX() {return (int)x;}
    public int getIntY() {return (int)y;}
    public int getIntZ() {return (int)z;}


    // SETTERS
    public void setX(double x) {this.x = x;}
    public void setY(double y) {this.y = y;}
    public void setZ(double z) {this.z = z;}
    
    public void alterX(double val) {this.x += val;}
    public void alterY(double val) {this.y += val;}
    public void alterZ(double val) {this.z += val;}

    public void scaleX(double val) {this.x *= val;}
    public void scaleY(double val) {this.y *= val;}
    public void scaleZ(double val) {this.z *= val;}


    // MATHS
    public Vector3 add(double val) {return new Vector3(x + val, y + val, z + val);}
    public Vector3 sub(double val) {return new Vector3(x - val, y - val, z - val);}
    public Vector3 mul(double val) {return new Vector3(x * val, y * val, z * val);}
    public Vector3 div(double val) {return new Vector3(x / val, y / val, z / val);}

    public Vector3 add(int val) {return new Vector3(x + val, y + val, z + val);}
    public Vector3 sub(int val) {return new Vector3(x - val, y - val, z - val);}
    public Vector3 mul(int val) {return new Vector3(x * val, y * val, z * val);}
    public Vector3 div(int val) {return new Vector3(x / val, y / val, z / val);}

    public Vector3 add(Vector3 v) {
        return new Vector3(
            x + v.getX(), 
            y + v.getY(), 
            z + v.getZ());
    }
    public Vector3 sub(Vector3 v) {
        return new Vector3(
            x - v.getX(), 
            y - v.getY(), 
            z - v.getZ());
    }
    public Vector3 mul(Vector3 v) {
        return new Vector3(
            x * v.getX(), 
            y * v.getY(), 
            z * v.getZ());
    }
    public Vector3 div(Vector3 v) {
        return new Vector3(
            x / v.getX(), 
            y / v.getY(), 
            z / v.getZ());
    }


    public Vector3 floor() {
        return new Vector3(
            Math.floor(x),
            Math.floor(y),
            Math.floor(z)
        );
    }
}
