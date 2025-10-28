class Pen { //pen class
    private String color;   //attributes
    private int tip;
    
    // Setter
    void setColor(String newColor){ //functions
        color = newColor;
    }

    void setTip(int newTip){
        tip = newTip;
    }

    // Getter
    String getColor(){
        return this.color;
    }

    int getTip(){
        return this.tip;
    }
}

public class GetAndSet {
    public static void main(String[] args) {
        Pen p1 = new Pen();
        p1.setColor("Blue");
        System.out.println(p1.getColor());
        p1.setTip(8);
        System.out.println(p1.getTip());
    }
}
