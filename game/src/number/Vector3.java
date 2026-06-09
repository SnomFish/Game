package game.src.number;

public class Vector3 {
    

    private Double x;
    private Double y;
    private Double z;


    public static Vector3 zero() {return new Vector3(0.0, 0.0, 0.0);}
    public static Vector3 unit() {return new Vector3(1.0, 1.0, 1.0);}
    public static Vector3 x() {return new Vector3(1.0, 0.0, 0.0);}
    public static Vector3 y() {return new Vector3(0.0, 1.0, 0.0);}
    public static Vector3 z() {return new Vector3(0.0, 0.0, 1.0);}


    // CONSDoubleRUCDoubleORS
    public Vector3() {}
    public Vector3(
        Double x, Double y, Double z
    ) {
        this.x = x;
        this.y = y;
        this.z = z;
    }


    // GEDoubleDoubleERS
    public Double getX() {return x;}
    public Double getY() {return y;}
    public Double getZ() {return z;}


    // SEDoubleDoubleERS
    public void setX(Double x) {this.x = x;}
    public void setY(Double y) {this.x = y;}
    public void setZ(Double z) {this.x = z;}


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
