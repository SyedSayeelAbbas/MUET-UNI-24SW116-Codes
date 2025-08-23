package SirMoseenPrograms;

public class Keyboard {
    private String type;
    Keyboard(String t)
    {
        this.type=t;
    }
    public void setType(String t)
    {
        this.type=t;
    }
    public String getType()
    {
        return this.type;
    }
    public String toString()
    {
        return "Type of KeyBoard:"+this.type;
    }
}
